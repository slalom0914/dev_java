package ch02;

public class GlobalVariable1 {
    int empno = 7566;
    public static void main(String[] args) {
        //여기에서 사원번호 7566을 출력하려고 한다. 어떻게 하나요?
        //insert here
        GlobalVariable1 gv1 = new GlobalVariable1();
        System.out.println("변경 전 사원 번호 : "+gv1.empno);//7566
        //사원번호를 7499로 변경해 주세요
        gv1.empno = 7499;
        System.out.println("원본 사원 번호 : "+gv1.empno);//7499
        //gv1 = new GlobalVariable1();
        GlobalVariable1 gv2 = new GlobalVariable1();
        gv1.empno = 8000;
        System.out.println("복사본 사원 번호 : "+gv2.empno);//여기서는 얼마가 출력될까요?
    }
}
