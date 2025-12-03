package ch05;

public class B1 {
    int i = 1;
    //클래스를 선언만 했음 -> 사용하면 NullPointerException이 발생함.
    B1 b1 = null;//여기 b1변수는 전변이고
    void methodA(){
        System.out.println(b1.i);
    }
    public static void main(String[] args) {
        //main메서드는  선언부에 static이 있어서 non-static타입은
        //호출할  수 없음.
        B1 b1 = new B1();//여기 b1은 지변이다.- 서로 다르다
        b1.methodA();
    }
}
