package dev_java.week4;

import java.util.ArrayList;
import java.util.Iterator;
//자바에서 제공하는 자료구조는 java.util폴더에 있음
import java.util.List;
import java.util.Vector;

public class List2 {
	public static void main(String[] args) {
		// 자료구조를 지원하는 클래스 들은 오브젝트의 존재유무 체크
		// 포함여부
		// 비어있는지 혹은 채워져 있는지 확인할 수 있는 api를 제공하고 있다
		List<String> fruitList = new Vector<>();// 멀티스레드안전-속도느림-안전
		fruitList.add("사과");// 0
		fruitList.add("토마토");// 1
		boolean isExist = fruitList.contains("바나나");
		isExist = fruitList.contains("토마토");
		if (isExist) {
			System.out.println("들어있다.");
		} else {
			System.out.println("들어있지 않다.");
		}
		boolean isEmpty = fruitList.isEmpty();
		System.out.println(isEmpty);// false
		//Vector나 ArrayList는 오브젝트 추가, 꺼내는 기능 제공
		//Iterator는 그 안에 오브젝트 존재유무
		Iterator<String> iter = fruitList.iterator();
		while(iter.hasNext()){
			String fname = iter.next();
			System.out.println(fname);
		}
		Iterator iter2 = fruitList.iterator();
		while(iter2.hasNext()){
			//다이아몬드연산자에 의미임 - 타입을 명시적으로 작성함
			String fname = (String)iter2.next();//제네릭타입을 지정하지 않아서 에러임
			System.out.println(fname);
		}
		//아래와 같이 사용할 수  없다.
		//왜냐하면 Vector 의 제네릭 타입이 String이니까...
		Iterator<Object> iter3 = fruitList.iterator();
		Iterator<String> iter4 = fruitList.iterator();

	}
}
