package dev_java.ch02;

public class Shuffle {
  public static void main(String[] args) {
    int a = 3;
    int b = 5;
    int imsi = 0;
    imsi = a;
    a = b;
    b = imsi;
    System.out.println("a : "+a + ", b : "+b);
  }
}
