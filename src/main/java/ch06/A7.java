package ch06;
/*
원시형 타입 - 호출하면 값이 출력됨
byte와 short사용하지 않음. 왜냐면 어차피 JVM처리할 때 int자동 형전환됨
char < short < byte < int < long < float < double
boolean
참조형 타입 - 호출하면 16진수 주소번지 출력됨 - 간접참조방식 - 제네릭

정적변수(static <-> non-static) - 하나를 공유함
인스턴스화가 필요없음
주의: static영역에서 non-static타입을 사용불가함

 */
public class A7 {
    //전변은 클래스 전역에서 사용할 수 있다.
    //전변은 클래스 외부에서 인스턴스화를 한다면 사용할 수  있다.
    int a;
    //파라미터가 없는 생성자 - 디폴트 생성자
    public A7() {
        //생성자 안에서도 메서드 호출이 가능함.
        methodA();
    }
    //사용자 정의메서드
    void methodA(){
        //methodA();
        int i = 1;
        System.out.println(this.a);
        //System.out.println(this.i);
    }//end of methodA
    //main메서드  - dll,exe
    public static void main(String[] args) {
        A7 a7 = new A7();
        //methodA();
        System.out.println(a7.a);
        //System.out.println(i);
    }
}
