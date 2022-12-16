package dev_java.tables;

import java.util.Vector;

public class Vector5 {
	public static void main(String[] args) {
		//과일가게에 진열 상품
		String fruits[] = { "키위", "포도", "사과","토마토","메론","파인애플","바나나","복숭아" };
		//내가 좋아하는 과일명
		String myFruits[] = {"키위", "토마토","딸기", "복숭아","체리"};
		//저 과일 중에서 본인이 좋아하는 과일만 골라서 Vector에 담아주세요
		Vector<String> vfruit = new Vector<>();
		//insert here
		for(int i=0;i<fruits.length;i++){
			for(int j=0;j<myFruits.length;j++){
				if(fruits[i].equals(myFruits[j])){
					vfruit.add(fruits[i]);
				}
			}
		}//end of for
		//구매한 과일 출력하시오.
		System.out.print("내가 좋아하는 과일은 ");
		for(String f:vfruit){
			System.out.print(f+" ");
		}
	}////end of main
}
