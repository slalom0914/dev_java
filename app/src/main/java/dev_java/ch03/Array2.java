package dev_java.ch03;

import java.util.Arrays;

/* 
 * 배열의 장애
 * 같은 타입만 담을 수 있다
 * 중간에 끼워넣기 불가함
 * 원소의 갯수 고정 - 변경 불가함
*/
public class Array2 extends Object {
  // 이른 인스턴스화
  int i[] = new int[3];
  int j[] = new int[] { 1, 2, 3 };
  int x[] = { 1, 2, 3 };

//변수 - 원시배열 - 객체배열 - 자료구조(List, Map) - 쿠키와 세션

  public static void main(String[] args) {
    Array2 a2 = new Array2();
    System.out.println(a2.x.toString());
    System.out.println(Arrays.toString(a2.i));
    System.out.println(Arrays.toString(a2.j));
    System.out.println(Arrays.toString(a2.x));
    for (int a=0;a<a2.j.length;a++) {
      System.out.println(a2.j[a]);
    }
    for (int y : a2.x) {
      System.out.println(y);
    }
  }//end of main
}
