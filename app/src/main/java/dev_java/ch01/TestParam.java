package dev_java.ch01;

class Param {
  int ival;
}

public class TestParam {
  void effectParam(Param p) {
    // insert here - 여기에 p = new Param()이 있으면 결과가 달라진다 아니다 같다?????
    p.ival = 500;
    System.out.println("sub ival ===> " + p.ival);
  }

  public static void main(String[] args) {
    TestParam tp = new TestParam();
    Param p = new Param();
    tp.effectParam(p);
    System.out.println("main ival ===> " + p.ival);
  }
}
