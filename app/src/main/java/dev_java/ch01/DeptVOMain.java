package dev_java.ch01;

public class DeptVOMain {
  public static void main(String[] args) {
    DeptVO deptVO = new DeptVO();
    deptVO.deptno = 10;
    deptVO.dname = "개발1팀";
    System.out.println(deptVO.deptno);//10
    System.out.println(deptVO.dname);//개발1팀
    System.out.println(deptVO.deptno);//10
    System.out.println(deptVO);
    deptVO = new DeptVO();//변수 선언이 아니라 객체생성
    System.out.println(deptVO);
    deptVO.deptno = 30;
    deptVO.dname = "개발2팀";
    System.out.println(deptVO.deptno);//30
    System.out.println(deptVO.dname);//개발2팀
    System.out.println(deptVO.loc);
  }
}
