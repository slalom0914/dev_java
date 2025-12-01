package ch03;

public class B {
    //전역변수 선언 위치에서는 선언과 초기화를 분리하지 않습니다.
    //지역변수는 선언하기와 초기화 하는 것을 분리하여 작성할 수 있음.
    int i;
    //i = 1;
    public static void main(String[] args) {
        int i;
        i = 5;
        System.out.println(i);//5가 출력됨
        B b = new B();
        System.out.println(b);
        System.out.println(b.toString());
        String s = "hello";
        System.out.println(s);//주소번지가 아니라 값이 출력됨
    }
}
