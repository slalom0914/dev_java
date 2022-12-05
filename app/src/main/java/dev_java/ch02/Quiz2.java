package dev_java.ch02;

public class Quiz2 {
  public static void main(String[] args) {
    int tot = 0;// 지변이니까 초기화 해야돼
    int cnt;
    cnt = 1;
    // for(초기화;조건식;증감연산자){
    for (; cnt <= 10; cnt = cnt + 1) {
      //너 짝수니?
      if(cnt%2 == 1){
        tot = tot + cnt;// 1
      }
    }
    System.out.printf("tot: %d , cnt : %d %n",  tot, cnt );
  }
}
