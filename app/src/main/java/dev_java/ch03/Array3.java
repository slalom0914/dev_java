package dev_java.ch03;

import java.util.Arrays;

public class Array3 {
  public static void main(String[] args) {
    int i[] = {1,2,3};
    int j[];
    j = i;
    int k[];
    k = new int[3];
    j = k;//왜 에러이죠??? - 에러가 발생하지 않도록 11번라인에 코드를 추가하세요
    //insert here
    System.out.println(Arrays.toString(j));
    System.out.println(j.length);
    String s1 = "안녕";
    System.out.println(s1.length());
    String s2 = s1;

  }
}
