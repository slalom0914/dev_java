package ch02.study;
//문제 : 사원번호를 7566으로 변경하는 코드를 작성하시오.
public class GlobalVar1 {
    //전역변수를 선언하는 위치 입니다.
    //global variable은 이 클래스 전역에서 사용이 가능함.
    int empno = 0;
    void methodA(){//Method관리하는 Stack영역에 따로 관리됨
        empno = 7499;
    }
    public static void main(String[] args) {
        //insert here
        //클래스 이름 뒤에 괄호가 있으면 생성자라고 함
        //괄호안에 파라미터가 없는 생성자를 디폴트 생성자라고 함
        //클래스는 heap메모리 영역에 로딩됨
        GlobalVar1 gv1 = new GlobalVar1();//인스턴스화
        //재정의
        //전역변수를 main메서드 영역 안에서 접근할 수 있다.
        gv1.empno = 7566;
        System.out.println(gv1.empno);//7566
    }
}
