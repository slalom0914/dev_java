package dev_java.ch02;

public class For1 {
  public static void main(String[] args) {
    for(int i=1;i<=3;i++){
      System.out.println(i);//1 2 3
    }//end of for
    int i= 0;
    while(i<=3){
      System.out.println(i);
      //while문 사용시에는 조건식에 사용된 변수의 증감연산자가 있는지 반드시 확인할것.
      i++;
      //++i;
    }
  }
}
