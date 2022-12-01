package dev_java.ch01;

import java.util.Scanner;

public class Scanner1 {
  public static void main(String[] args) {
    System.out.println("0부터 9사이의 숫자를 입력하세요.");
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    System.out.println("사용자가 입력한 값은 " + str);
    scanner.close();
  }
}
