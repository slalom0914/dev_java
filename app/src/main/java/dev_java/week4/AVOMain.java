package dev_java.week4;


public class AVOMain {
	public static void main(String[] args) {
		//AVO avo = new AVO();
		//avo.setAge(10);
		//System.out.println(avo.getAge());
		AVO avo2 = AVO.builder().age(20).name("강감찬").build();
		System.out.println(avo2.getAge()+", "+avo2.getName());
	}
}
