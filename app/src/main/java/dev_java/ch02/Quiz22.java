package dev_java.ch02;

import java.util.Scanner;

public class Quiz22 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("구하고자 하는 합의 두번째 숫자를 입력하세요.");
    int user_end = s.nextInt();
    int tot = 0;// 지변이니까 초기화 해야돼
    int cnt;
    cnt = 1;
    // for(초기화;조건식;증감연산자){
    while (cnt <= user_end) {
      // 너 짝수니?
      if (cnt % 2 == 1) {
        tot = tot + cnt;// 1
      }
      cnt ++;
    }
    System.out.printf("tot: %d , cnt : %d %n", tot, cnt);
    s.close();
  }
}
