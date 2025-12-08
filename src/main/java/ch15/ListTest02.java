package ch15;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
//추상클래스보다 더 추상적임
//추상클래스는 extends하지만 인터페이스는 implements한다.
//상속은 결합도가 증가되지만 인터페이스는 결합도를 낮춰준다.
//협업을 할 때는 서로 단위테스트 정도는 배려하자
//추상클래스와 인터페이스에 대해서는 기본적인 약속들을 기억해 둔다.
public class ListTest02 {
    public static void main(String[] args) {
        ArrayList   list1   = new ArrayList();
        Vector      v1      = new Vector();
        List        list2   = new ArrayList();
        List        list3   = new Vector();
        String[] names = new  String[3];
        v1.copyInto(names);
        //부모에 대한 구현체 클래스 관계에 있을 때 자손은 부모의
        //전역변수나 메서드를 호출할 수 있다.
        //그러나 부모는 자손이 정의하는 변수나 메서드를 사용할 수 없다.
        //list3.copyInto(names);사용이 불가함. 왜냐면 List타입에는 없는 메서드임
    }
}
