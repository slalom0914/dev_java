package dev_java.ch01;
class EmpVO {
  //사원번호를 담기
  int empno;
  //사원이름 담기
  String ename;
}
public class EmpVOMain {
  public static void main(String[] args) {
    EmpVO empVO = new EmpVO();
    empVO.empno = 7566;
    empVO.ename = "이순신";
    System.out.println(empVO.empno +", "+ empVO.ename);
    empVO = new EmpVO();
    empVO.empno = 7499;
    empVO.ename = "강감찬";
    System.out.println(empVO.empno +", "+ empVO.ename);
  }
}
