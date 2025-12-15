package ch15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListTest03 {
    public static void main(String[] args) {
        List li1 = new ArrayList();
        ArrayList al1 = new ArrayList();
        List li2 = new Vector();
        List li3 = new LinkedList();
        //li1타입은 List타입이라서 List인터페이스에 선언된 메서드만 호출가능함
        li1.add("A");
        //al1타입은 ArrayList타입이라서 List에 있는 것 + ArrayList에만 있는것
        //모두 호출이 가능함.
        al1.add("A");
        //spring boot는 코드 레벨의 인스턴스화를 하지 않음
        //객체 주입에 대한 책임이 개발자가 아닌 컨테이너(자바-ApplicationContext)에 있다.
        //컬렉션 프레임워크에서 제공하는 클래스들은 정렬, 검색기능, 부가 기능들이 많이 있다.
        //읽고 쓰기, 그리고 자료구조안에 데이터가 있는지 없는지 판단하는 boolean인 것
    }
}
