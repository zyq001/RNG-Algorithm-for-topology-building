package edu.bupt.zyq.wsn.router.mgr.calNeighbor;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

//import org.apache.servicemix.wsn.router.mgr.BrokerUnit;
import org.apache.servicemix.wsn.router.msg.tcp.LSA;
import org.apache.servicemix.wsn.router.msg.tcp.GroupUnit;

import edu.bupt.zyq.wsn.router.mgr.calNeighbor.NeigBuild;

public abstract class SysInfo {

	//����������
	protected static String adminAddr;//�����ߵĵ�ַ
	protected static int adminPort;//�����ߵ�TCP�˿ں�
	public static String groupName;//����Ⱥ������
	protected static int tPort;//����TCP�˿ں�
	public static String localAddr;//��ϵͳ�ĵ�ַ
	protected static String localNetmask; //������������
	protected static int queueSize;//·��ģ����г���
	protected static int poolCount;//�̳߳�����
	protected static int connectCount;//���ӳ�����
//	protected static long thresholdInitialize;//��ʼ�������ж�������ʱ�ķ�ֵ
//	protected static long sendPeriodInitialize;//��ʼ����������������ʱ����
//	protected static long scanPeriodInitialize;//��ʼ������ɨ��������ʱ����
//	protected static long synPeriodInitialize;//��ʼ���������͸��¶��ĵ�ʱ����

	//Զ��������
	protected static BrokerUnit rep;//����Ⱥ����ĵ�ַ
	protected static int neighborSize;//����ĺ��ӽڵ������
	public static String multiAddr;//�鲥��ַ
	public static int uPort;//UDP�˿ںţ�ͬʱҲ���鲥�˿ں�
	protected static int joinTimes;//���Լ���Ĵ���
	public static long threshold;//�ж�������ʱ�ķ�ֵ
	public static long sendPeriod;//����������ʱ����
	public static long scanPeriod;//ɨ��������ʱ����
	public static long synPeriod;//���͸��¶��ĵ�ʱ����

	//others
	public static ConcurrentHashMap<String, GroupUnit> groupMap;//���浱ǰ�����ڳ��˱���Ⱥ�����м�Ⱥ����Ϣ��keyΪ��Ⱥ��
	protected static ArrayList<String> neighbors; //�ھӼ�Ⱥ
	public static ConcurrentHashMap<String, BrokerUnit> fellows;//�������ڼ�Ⱥ����������keyΪ�����ַ
	protected static int lsaSeqNum; //LSA�����к� 
	protected static long policyTime; // ������Ϣ�ĸ���ʱ��
	protected static long treeTime; // ������ʱ��

	protected static ConcurrentHashMap<String, LSA> lsdb; //LSA���ݿ⣬�Լ�Ⱥ���Ʊ�ʾ�ü�Ⱥ������LSA��Ϣ
	protected static LSA cacheLSA; //����LSA��������Ҫ���͵�LSA����
	protected static String askMsg; // ����LSDB�Ͳ�����Ϣ���͵��ַ���
	protected static boolean joinOK;//��ʶ�����Ƿ�ɹ�
	protected static ArrayList<String> waitHello;//��Ⱥhello��ʱʱ�����Ա�Ǹü�Ⱥ������ѡ����
	protected static long id;//�����idֵ�����뼯Ⱥʱ�ɴ������

	//���ı�
	public static ArrayList<String> clientTable;//���صĶ�����Ϣ,����broker��������ļ���
	public static ConcurrentHashMap<String, TreeSet<String>> brokerTable;//����Ⱥ����������Ķ�����Ϣ��keyΪ���⣬valueΪ���Ĵ���ĵ�ַ
	protected static MsgSubsForm groupTableRoot; //������Ⱥ�������ĸ�

	protected static boolean udpMsgThreadSwitch;//���ڿ��ƽ���udp��Ϣ���߳������Ŀ���
	protected static boolean tcpMsgThreadSwitch;//���ڿ��ƽ���tcp���ӵ��߳������Ŀ���
	
	protected static NeigBuild nb; // �ھ�ѡ��ģ��

	public static String getAdminAddr() {
		return adminAddr;
	}

	public static void setAdminAddr(String adminAddr) {
		SysInfo.adminAddr = adminAddr;
	}

	public static int getAdminPort() {
		return adminPort;
	}

	public static void setAdminPort(int adminPort) {
		SysInfo.adminPort = adminPort;
	}

	public static String getGroupName() {
		return groupName;
	}

	public static void setGroupName(String groupName) {
		SysInfo.groupName = groupName;
	}

	public static int gettPort() {
		return tPort;
	}

	public static void settPort(int tPort) {
		SysInfo.tPort = tPort;
	}

	public static String getLocalAddr() {
		return localAddr;
	}

	public static void setLocalAddr(String localAddr) {
		SysInfo.localAddr = localAddr;
	}

	public static String getLocalNetmask() {
		return localNetmask;
	}

	public static void setLocalNetmask(String localNetmask) {
		SysInfo.localNetmask = localNetmask;
	}

	public static int getQueueSize() {
		return queueSize;
	}

	public static void setQueueSize(int queueSize) {
		SysInfo.queueSize = queueSize;
	}

	public static int getPoolCount() {
		return poolCount;
	}

	public static void setPoolCount(int poolCount) {
		SysInfo.poolCount = poolCount;
	}

	public static int getConnectCount() {
		return connectCount;
	}

	public static void setConnectCount(int connectCount) {
		SysInfo.connectCount = connectCount;
	}

	public static BrokerUnit getRep() {
		return rep;
	}

	public static void setRep(BrokerUnit rep) {
		SysInfo.rep = rep;
	}

	public static int getNeighborSize() {
		return neighborSize;
	}

	public static void setNeighborSize(int neighborSize) {
		SysInfo.neighborSize = neighborSize;
	}

	public static String getMultiAddr() {
		return multiAddr;
	}

	public static void setMultiAddr(String multiAddr) {
		SysInfo.multiAddr = multiAddr;
	}

	public static int getuPort() {
		return uPort;
	}

	public static void setuPort(int uPort) {
		SysInfo.uPort = uPort;
	}

	public static int getJoinTimes() {
		return joinTimes;
	}

	public static void setJoinTimes(int joinTimes) {
		SysInfo.joinTimes = joinTimes;
	}

	public static long getThreshold() {
		return threshold;
	}

	public static void setThreshold(long threshold) {
		SysInfo.threshold = threshold;
	}

	public static long getSendPeriod() {
		return sendPeriod;
	}

	public static void setSendPeriod(long sendPeriod) {
		SysInfo.sendPeriod = sendPeriod;
	}

	public static long getScanPeriod() {
		return scanPeriod;
	}

	public static void setScanPeriod(long scanPeriod) {
		SysInfo.scanPeriod = scanPeriod;
	}

	public static long getSynPeriod() {
		return synPeriod;
	}

	public static void setSynPeriod(long synPeriod) {
		SysInfo.synPeriod = synPeriod;
	}

	public static ConcurrentHashMap<String, GroupUnit> getGroupMap() {
		return groupMap;
	}

	public static void setGroupMap(ConcurrentHashMap<String, GroupUnit> groupMap) {
		SysInfo.groupMap = groupMap;
	}

	public static ArrayList<String> getNeighbors() {
		return neighbors;
	}

	public static void setNeighbors(ArrayList<String> neighbors) {
		SysInfo.neighbors = neighbors;
	}

	public static ConcurrentHashMap<String, BrokerUnit> getFellows() {
		return fellows;
	}

	public static void setFellows(ConcurrentHashMap<String, BrokerUnit> fellows) {
		SysInfo.fellows = fellows;
	}

	public static int getLsaSeqNum() {
		return lsaSeqNum;
	}

	public static void setLsaSeqNum(int lsaSeqNum) {
		SysInfo.lsaSeqNum = lsaSeqNum;
	}

	public static ConcurrentHashMap<String, LSA> getLsdb() {
		return lsdb;
	}

	public static void setLsdb(ConcurrentHashMap<String, LSA> lsdb) {
		SysInfo.lsdb = lsdb;
	}

	public static LSA getCacheLSA() {
		return cacheLSA;
	}

	public static void setCacheLSA(LSA cacheLSA) {
		SysInfo.cacheLSA = cacheLSA;
	}

	public static String getAskMsg() {
		return askMsg;
	}

	public static void setAskMsg(String askMsg) {
		SysInfo.askMsg = askMsg;
	}

	public static boolean isJoinOK() {
		return joinOK;
	}

	public static void setJoinOK(boolean joinOK) {
		SysInfo.joinOK = joinOK;
	}

	public static ArrayList<String> getWaitHello() {
		return waitHello;
	}

	public static void setWaitHello(ArrayList<String> waitHello) {
		SysInfo.waitHello = waitHello;
	}

	public static long getId() {
		return id;
	}

	public static void setId(long id) {
		SysInfo.id = id;
	}

	public static ArrayList<String> getClientTable() {
		return clientTable;
	}

	public static void setClientTable(ArrayList<String> clientTable) {
		SysInfo.clientTable = clientTable;
	}

	public static ConcurrentHashMap<String, TreeSet<String>> getBrokerTable() {
		return brokerTable;
	}

	public static void setBrokerTable(
			ConcurrentHashMap<String, TreeSet<String>> brokerTable) {
		SysInfo.brokerTable = brokerTable;
	}

	public static MsgSubsForm getGroupTableRoot() {
		return groupTableRoot;
	}

	public static void setGroupTableRoot(MsgSubsForm groupTableRoot) {
		SysInfo.groupTableRoot = groupTableRoot;
	}

	public static boolean isUdpMsgThreadSwitch() {
		return udpMsgThreadSwitch;
	}

	public static void setUdpMsgThreadSwitch(boolean udpMsgThreadSwitch) {
		SysInfo.udpMsgThreadSwitch = udpMsgThreadSwitch;
	}

	public static boolean isTcpMsgThreadSwitch() {
		return tcpMsgThreadSwitch;
	}

	public static void setTcpMsgThreadSwitch(boolean tcpMsgThreadSwitch) {
		SysInfo.tcpMsgThreadSwitch = tcpMsgThreadSwitch;
	}

	public static NeigBuild getNb() {
		return nb;
	}

	public static void setNb(NeigBuild nb) {
		SysInfo.nb = nb;
	}
	
	public static long getPolicyTime() {
		return policyTime;
	}

	public static void setPolicyTime(long policyTime) {
		SysInfo.policyTime = policyTime;
	}
	
	public static long getTreeTime() {
		return treeTime;
	}

	public static void setTreeTime(long treeTime) {
		SysInfo.treeTime = treeTime;
	}

}
