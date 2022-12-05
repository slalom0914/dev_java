package dev_java.ch02;

public class P21_1 {

  public static void main(String[] args) {
    int i = 5;
    switch(i){
      case 0:
        ++i;//실행문
      case 1:
        ++i;//실행문 2
        break;//switch탈출
      default:
        ++i;//3
    }// end of switch
    //insert here - i는 얼마일까요?
    System.out.println(i);
  }
}
