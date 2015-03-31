package edu.bupt.zyq.wsn.router.mgr.calNeighbor;

import java.io.Serializable;
import java.util.Date;

public class GroupUnit implements Serializable {

	//����group�Ļ�����Ϣ
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String addr;//group�ĵ�ַ
	
	public String netmask; //group��������
	
	public String name;//group������
	
	public int tPort;//group��TCP�˿ں�
	
	public Date date;//����ʱ��
	
	public long id; //��������ʱ��
	
	public int uPort; //group��UDP�˿ں�
	
	public GroupUnit(String addr, int port, String name) {
		this.addr = addr;
		this.name = name;
		this.tPort = port;
		date = new Date();
	}
	
	public GroupUnit(String addr, String netmask, int tPort, int uPort, long id, String name) {
		this.addr = addr;
		this.netmask = netmask;
		this.name = name;
		this.tPort = tPort;
		this.uPort = uPort;
		this.id = id;
		date = new Date();
	}
	
	public GroupUnit() {
		
	}
}
