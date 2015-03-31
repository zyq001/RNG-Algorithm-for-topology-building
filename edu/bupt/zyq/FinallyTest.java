package edu.bupt.zyq;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FinallyTest {
	
	private static class SingletonHolder //私有静态类   

    {    

		static{
			System.out.println("私有静态类的初始化");
		}
		public static int i ;
//        public final static Singleton instance = new Singleton();    

    }    
	
	public static SingletonHolder shHolder;
	
	private static int i = 0;
	private static int rest(){
//		int i = 1;
		try{
			i = 2;
			return i;
		}finally{
			i = 3;
//			return 3;
		}
	}
	
	public static void test(int[] t){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SingletonHolder.i);
//		ConcurrentHashMap<K, V>
//		Collections 
//		StringBuilder
//		int[] it = new int[1];
//		it[1] = 1;
//		while(true){
//			int i= 0;
//		}
		test(null);
		int j=1,i=0;
		int n = 5,count = 0;

		for(int k = 0;k < n;k++){
		j = i + j;  
		i = j - i;
		++count;
		}
		byte[] a = new byte[9];
		String string = new String();
		int [] ina = new int[2];
		class Ass{
			
		}
		Ass aa = new Ass();
		System.out.println("aa:" + aa);
		
//		SubClass sbClass = new SubClass();
		System.out.println(SubClass.class);
		
		System.out.println(ina);
		System.out.println(string);
		System.out.println(a);
		System.out.println(count + "  " + j);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("ss", 2);
//		map["ss"];
		String s = "i am   ,  a   code";
		System.out.println(s.replaceAll("\\s{2,}", " "));
	}

}
