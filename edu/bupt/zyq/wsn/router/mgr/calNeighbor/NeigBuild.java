package edu.bupt.zyq.wsn.router.mgr.calNeighbor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;


public class NeigBuild extends SysInfo {
	private static int neigsMax;// �ھ�������
	private static int neigsMin;// �ھ�������
	private static int neigsDefault;// Ĭ���ھ���
	private static int neigsCount = 0; // ��ǰ�ھ���
	public static String answerOrder; // socket serverӦ��ָ��
	private static ArrayList<String> neigsIPArray;// �����ѽ��ھ�

	public static ConcurrentHashMap<String, Node> map;//�������ھӵĽڵ㼯��

	public NeigBuild() {
		neigsIPArray = new ArrayList<String>();
		map = new ConcurrentHashMap<String, Node>();
	}

	// �����ھ���������
	public void setValue(int max, int min, int def) {
		neigsMax = max;
		neigsMin = min;
		neigsDefault = def;
	}

	// ���ر����ھ���
	public int getNeigCount() {
		return neigsCount;
	}

	// ȡ���ѽ������ھ�ip�б�
	public ArrayList<String> getBuildedNeigsIP() {
		return neigsIPArray;
	}

	// ��һ�ι����������ھ��б�
	public ArrayList<String> BuildAGetNeigs(){// ��ȡ�ھ��б�
		map.clear();
		for (GroupUnit g : groupMap.values()) {
			if (!lsdb.isEmpty() && lsdb.containsKey(g.name)) {
				map.put(g.addr, new Node(g.addr,g.netmask,g.name,lsdb.get(g.name).distBtnNebrs.size()));
			} else {
				map.put(g.addr, new Node(g.addr,g.netmask,g.name,0));
			}
		}
		ArrayList<String> selectedNeigsIP = ipSelected();
		selectedNeigsIP = this.neigsCountCheck(selectedNeigsIP);
		ArrayList<String> selectedGroups = new ArrayList<String>();
		Iterator<String> iterator = selectedNeigsIP.iterator();
		for (int j = 0; j < selectedNeigsIP.size() && j < neigsDefault+0.5; j++) {
				String addr = iterator.next();
				if (addr != null && map.containsKey(addr) && !selectedGroups.contains(map.get(addr).name)) {
					selectedGroups.add(map.get(addr).name);
				}
			}
		return selectedGroups;
	}

	// �ھ����仯��ʱ�����Ƿ���Ҫ��������ھӣ����������ھ��б�
	public ArrayList<String> NeigsChange(ArrayList<String> out) {
		ArrayList<String> neigsAdd = new ArrayList<String>();
		neigsIPArray.clear();
		map.clear();
		for(String name : neighbors) {
			neigsIPArray.add(groupMap.get(name).addr);
		}
		neigsCount = neighbors.size();
		for (GroupUnit g : groupMap.values()) {
			//�ų�����ip
			if (g.addr.equals(localAddr) || neighbors.contains(g.name) || out.contains(g.name)) {
				continue;
			}
			//
			if (!lsdb.isEmpty() && lsdb.containsKey(g.name)) {
				map.put(g.addr, new Node(g.addr,g.netmask,g.name,lsdb.get(g.name).distBtnNebrs.size()));
			} else {
				map.put(g.addr, new Node(g.addr,g.netmask,g.name,0));
			}
		}
		neigsIPArray = neigsCountCheck(neigsIPArray);
		
		Iterator<String> iterator = neigsIPArray.iterator();
		for (int j = 0; j < neigsIPArray.size() && j < neigsDefault+0.5; j++) {
				String addr = iterator.next();
				if (addr != null && map.containsKey(addr) && !neigsAdd.contains(map.get(addr).name)) {
					neigsAdd.add(map.get(addr).name);
				}
			}
		return neigsAdd;
	}

	// ��ÿ��ip�ָ���Ķ�int��
	public static int[] ipAddressSplit(String ipAddress) {
		
		String[] ipSplit = ipAddress.split("\\.");
		System.out.println("ipAddress"+ipAddress+ipSplit.toString()+ipSplit[0]);
		int[] ip = new int[4];
		if(ipAddress.equals("localhost")){
			
			ip[0]=0;ip[1]=0;ip[2]=0;ip[3]=0;
			return ip;
		}
		if (ipSplit.length == 4) {
			for (int i = 0; i < ipSplit.length; i++) {
				ip[i] = Integer.parseInt(ipSplit[i]);
			}
		}
		return ip;
	}

	// �ھӼ�������㷨
	private static ArrayList<String> ipSelected() {// ip��ַ�ɽ���Զ����

		String[] mask = localNetmask.split("\\.");
		int[] neigsIPInt = new int[mask.length]; // �ھ�ip��ַ�ֶ�int
		int[] netmaskInt = new int[mask.length]; // �ھ���������ֶ�int
		int[] networkAddInt = new int[mask.length]; // �ھ������ַ�ֶ�int
		int[] localNetworkInt = new int[mask.length];// ���������ַ�ֶ�int
		int[] localIPInt = new int[mask.length]; // ����ip��ַ�ֶ�int
		int[] localNetworkAddrInt = new int[mask.length]; // ������������ֶ�int
		ArrayList<Integer> neighborsCount = new ArrayList<Integer>(); //�ھӼ���
		long[] networkAddrNum;// �ھ������ַ����ֵ
		long localNetworkAddrNum;// ���������ַ����ֵ

		// ��ȡ���������ַ
		for (int i = 0; i < mask.length; i++) {
			localNetworkAddrInt[i] = Integer.parseInt(mask[i]);
		}

		localIPInt = ipAddressSplit(localAddr);
		for (int i = 0; i < 4; i++) {
			localNetworkInt[i] = localIPInt[i] & localNetworkAddrInt[i];
		}
		localNetworkAddrNum = localNetworkInt[0] * 255 * 255 * 255
				+ localNetworkInt[1] * 255 * 255 + localNetworkInt[2] * 255
				+ localNetworkInt[3];

		networkAddrNum = new long[map.size()];
		Iterator<Node> iterator = map.values().iterator();
		ConcurrentHashMap<Integer, String> m = new ConcurrentHashMap<Integer, String>();
		System.out.println("map:"+map.keySet().size());
		for (int k = 0; k < map.size(); k++) {
			Node node = iterator.next();
			neigsIPInt = ipAddressSplit(node.addr); // ��Ŀ�ĵ�ַip��ȡ��
			System.out.println("neigsIPInt:"+k+neigsIPInt.length);
			netmaskInt = ipAddressSplit(node.netmask);
			System.out.println("netmaskInt:"+k+netmaskInt.length+netmaskInt[0]+netmaskInt[1]+netmaskInt[2]+netmaskInt[3]);
			for (int i = 0; i < 4; i++) {
				networkAddInt[i] = neigsIPInt[i] & netmaskInt[i]; // �ھ������ַ
			}

			neighborsCount.add(node.neighborCount);
			networkAddrNum[k] = networkAddInt[0] * 255 * 255 * 255
					+ networkAddInt[1] * 255 * 255 + networkAddInt[2] * 255
					+ networkAddInt[3];
			m.put(k, node.addr);
		}

		// ��׼�ھ������ַ��ֵ�뱾�������ַ��ֵ֮��ľ���ֵ����
		NeigSelect localNeigsSelect = new NeigSelect();
		localNeigsSelect.buildUDN(localNetworkAddrNum, networkAddrNum,
				neighborsCount);// ����ȫ�ִ�Ȩ��
		// ���㱾���ھӣ���ȡ��ѡ���ھӵ��±�
		ArrayList<Integer> neigsIPSubNum = localNeigsSelect.accuNeigsIPNum(
				localNetworkAddrNum, networkAddrNum, localNeigsSelect.getUDN());
		ArrayList<String> selectedNeigsIP = new ArrayList<String>();
		for (Integer i : neigsIPSubNum) {
			selectedNeigsIP.add(m.get(i));
			neigsCount++;
			// neigsIPArray.add(neigsIP[neigsIPSubNum.get(i)]);//���㷨ѡ�����ھӴ���ȫ���������
			// System.out.println("����ѡ����ھӵ�"+(i+1)+"����"+selectedNeigsIP[i]);
		}

		// //���ԣ���ӡȫ�ִ�Ȩ��
		// System.out.println("ȫ��UDN����");
		// for(int m=0; m<=downloadIP2.size(); m++){
		// for(int n=0; n<=downloadIP2.size(); n++){
		//
		// System.out.print(localNeigsSelect.getUDN().arcs[m][n]+"  ");
		// }
		// System.out.println();
		// }
		//
		// //���ԣ���ӡȫ��RNGͼ
		// System.out.println("ȫ��RNGͼ��");
		// localNeigsSelect.globalRNG(localNetworkAddrNum, networkAddrNum,
		// localNeigsSelect.getUDN());
		// for(int m=0; m<=downloadIP2.size(); m++){
		// for(int n=0; n<=downloadIP2.size(); n++){
		// System.out.print(localNeigsSelect.getRNG().arcs[m][n]+"  ");
		// }
		// System.out.println();
		// }

		return selectedNeigsIP;

	}

	// �ھ������
	public ArrayList<String> neigsCountCheck(ArrayList<String> selectedIP) {// �ھ������

		for (int k = 0; k < neigsMin; k++) {
			if ((map.size() - neigsCount) > 0 && neigsCount < neigsMin) {
				for (String addr : map.keySet()) {
					for (int j = 0; j < selectedIP.size(); j++)
						if (selectedIP.get(j).equals(addr)) {
							map.remove(addr);
						}
				}
				selectedIP.addAll(ipSelected());
			} else {
				break;
			}
		}
		return selectedIP;
	}

}
