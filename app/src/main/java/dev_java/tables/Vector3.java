package dev_java.tables;

import java.util.Vector;

public class Vector3 {
	public static void main(String[] args) {
		//객체는 생성되었으나 방은 없다
		Vector<Integer> v = new Vector<>();
		//그러니까 0
		System.out.println(v.size());//0
		//방이 비어 있니?
		System.out.println(v.isEmpty());//true
		
		boolean isExist = v.add(1);
		
		System.out.println(v.get(0));//1
		
		System.out.println(isExist);//true
		
		System.out.println(v.isEmpty());//false
		
		System.out.println(v.contains(1));//true
		
		v.add(1,2);
		
		System.out.println(v.contains(2));//false -> true
		
		System.out.println(v.remove(1));
		
		boolean isOk = v.remove(new Integer(1));
		
		System.out.println(v.size());//1
	}
}
