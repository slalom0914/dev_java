package ch02;
class A{
    int age;
}
public class AMain {
    public static void main(String[] args) {
        //변수 a는 참조변수 입니다.클래스 A를 가리키는 주소번지를 갖는다.
        A a = new A();
        a.age = 10;
        System.out.println(a+", a.age:"+a.age);
        //같은 타입의 변수 a에 새롭게 인스턴스화를 함 -> 주소번지가 다르다.
        //그래서 9번에서 age변수에 10으로 재정의된 것은 14번 결과에 영향이 없다.
        a = new A();
        System.out.println(a+", a.age:"+a.age);
    }
}
