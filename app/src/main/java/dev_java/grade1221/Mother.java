package dev_java.grade1221;

import java.util.Vector;

public class Mother {
	Money m = new Money(10000);
	public static void main(String[] args) {
		Vector<Mother> v = new Vector<>();//0
		Mother m1 = new Mother();
		v.add(0,m1);
		v.get(0).m.money = 20000;
		Mother m2 = new Mother();
		v.add(1,m2);
		Mother m3 = new Mother();
		v.add(2,m3);
		/* 
		for(Mother m:v){
			System.out.println(m);
		}
		*/
		for(int i=0;i<v.size();i++){
			Mother mot = v.get(i);
			System.out.println(mot.m.money);
			//System.out.println(m);
			//System.out.println(m.toString());
		}
	}
}
