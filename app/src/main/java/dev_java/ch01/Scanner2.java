package dev_java.ch01;

import java.util.Scanner;

public class Scanner2 {
  public static void main(String[] args) {
    Scanner scanner = null;
    while (true) {
      System.out.println("0부터 9사이의 숫자를 입력하세요.");
      scanner = new Scanner(System.in);
      String str = scanner.nextLine();
      if (str.equals("exit")) {
        scanner.close();
        break;
      } else {
        System.out.println("사용자가 입력한 값은 " + str);
      }
    }
    // scanner.close();
  }
}
