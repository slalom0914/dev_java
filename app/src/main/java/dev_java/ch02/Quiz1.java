package dev_java.ch02;

public class Quiz1 {
  public static void main(String[] args) {
    // 합을 담을 변수 선언
    // 0으로 초기화 하는 이유는 답에 영향을 주면 안되니까....
    int tot = 0;// 지변이니까 초기화 해야돼
    // 1씩 세는 변수 선언
    int cnt;
    cnt = 1;
    // for(초기화;조건식;증감연산자){
    for (; cnt <= 3; cnt = cnt + 1) {
      tot = tot + cnt;//1
      System.out.println("tot:"+tot + ", cnt : " + cnt);
    }
  }
}
