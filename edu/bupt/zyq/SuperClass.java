package edu.bupt.zyq;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class SuperClass {
	public static final int i = 0;
	HashMap hmp = new HashMap<>();
	Hashtable<Integer, String> htbHashtable;
	static ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		concurrentHashMap.put("qqq", "www");
	}

}
