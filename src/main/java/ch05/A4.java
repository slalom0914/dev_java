package ch05;

public class A4 {
    int i = 1;
    //아래 a5는 전역변수 이다.
    A4 a5 = null;
    void methodA(A4 a5){
        System.out.println(a5);
        System.out.println(a5.i);
    }
    //entry point가 main메서드이다. main thread라고 함.
    public static void main(String[] args) {
        //a5는 지역변수 이다.
        A4 a5 = new A4();
        a5.methodA(a5);
    }
}
