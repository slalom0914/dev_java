package ch02;

public class LocalVariable1 {
    int b;
    public static void main(String[] args) {
        //select empno from emp;14명 사원번호가 있었다.
        //14명의 사원번호를 담기 위해 변수 선언을 14번 해야 한다.
        int empno1 = 7001;
        int empno2 = 7002;
        int empno3 = 7003;
        int a=0;//지변은 반드시 초기화를 해야 합니다.
        //사용하기 전에는 에러가 발생하지 않음
        //아래 에러 원인에 대해 설명하고 문제를 해결하시오.
        //a= 5;
        System.out.println(a);
        LocalVariable1 lv = new LocalVariable1();
        System.out.println(lv.b);//0
    }
}
