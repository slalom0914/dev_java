package ch05;

public class A5 {
    int i = 1;
    //아래 a5는 전역변수 이다.
    //인스턴스화 할 때 선언만 했을 경우 NullPointerException발생할 수 있다.
    //해결하는 방법은 생성부 까지 작성을 해야 함.
    A5 a5 = null;
    //A5 a51 = new A5();
    void methodA(A5 a5){
        System.out.println(a5);
        System.out.println(a5.i);
    }
    //entry point가 main메서드이다. main thread라고 함.
    public static void main(String[] args) {
        //a5는 지역변수 이다.
        A5 a5 = new A5();
        a5.methodA(a5);
    }
}
