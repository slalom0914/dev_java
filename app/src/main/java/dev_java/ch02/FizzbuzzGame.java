package dev_java.ch02;

public class FizzbuzzGame {
  void methodA() {
    System.out.println("============[[ methodA호출 ]]=============");
    for (int i = 1; i < 101; i++) {
      switch (i % 35) {
        case 0:
          System.out.println("fizzbuzz");
          break;
        case 5:
        case 10:
        case 15:
        case 20:
        case 25:
        case 30:
          System.out.println("fizz");
          break;
        case 7: case 14: case 21: case 28:
          System.out.println("buzz");
          break;
        default:
          System.out.println(i);
      }///// end of switch
    } ////// end of for
  }/////// end of methodA

  public static void main(String[] args) {
    FizzbuzzGame fbg = new FizzbuzzGame();
    fbg.methodA();
    for (int i = 1; i < 101; i++) {
      if (i % 35 == 0)
        System.out.println("fizzbuzz");
      else if (i % 5 == 0)
        System.out.println("fizz");
      else if (i % 7 == 0)
        System.out.println("buzz");
      else
        System.out.println(i);
    }
  }
}
