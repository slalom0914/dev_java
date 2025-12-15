package ch15;
/*
ChildMain.java
Parent.class, Child.class, ChildMain.class
 */
abstract class Parent {
    void methodA(){
        System.out.println("Parent methodA");
    }

}
class Child extends Parent {

    //@Override
    void methodB(){
        System.out.println("Parent methodB");
    }
}
public class ChildMain {
    public static void main(String[] args) {
        //인터페이스와 추상클래스는 단독으로 인스턴스화 할 수 없다.
        //즉 반드시 구현체 클래스가 있어야 함.
        //다시 말해 선언부 타입과 생성부에 타입이 반드시 다르다.
        //선언부 타입과 생성부에 타입이 다르기 때문에 다형성을 누릴 수 있다.
        //선언부에 추상클래스나 인터페이스를 사용한다.
        //Parent p1 = new Parent();
        //인스턴스변수 p로는 methodB()를 호출할 수 없다.
        Parent p = new Child();
        Child c = new Child();
        p.methodA();
        //인스턴스변수 p가 Parent타입이므로 Parent에 선언되지 않은
        //메서드는 호출이 불가하다.
        //인스턴스변수 c는 만일 Child클래스에 methodA()가 구현되지 않아도
        //methodA()를 호출할 수 있다.
        //p.methodB();
        c.methodA();

    }
}
/*
    List li1 = new ArrayList();
    List li2 = new Vector();
    List li3 = new LinkedList();

*/