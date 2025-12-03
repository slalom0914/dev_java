package ch05.aobject;
// M1.java -> M.class, M1.class -> CPU -> 연산, 처리 -> 그래서 JVM필요함
// 컴퓨터 구조(H/W, S/W,,,+ 네트워크)
class M{
    int i;
}

public class M1 {
    public static void main(String[] args) {
        //객체 생성이 되지 않았는데 인스턴스변수로 사용하면 NullPointerException발생함.
        //예외처리 할 수 있다. - 여유
        M[] ms = new M[2];
        //굳이 M클래스에 선언된 변수 i가 필요하다.
        M m = new M();
        System.out.println("before M : "+m);//주소번지 출력함
        //재정의 위치와 값을 변경하는 위치
        m.i = 1;
        ms[0] = m;
        m = null;
        m = new M();
        m.i = 2;
        ms[1] = m;
        //for(배열안에 들어가는 클래스 타입선언:배열객체의 인스턴스변수이름){
        for(M m1:ms){//2번 반복하기 -> 왜냐면 ms.length-> 객체배열의 크기가 2이다.
            System.out.println(m1.i);
        }
        System.out.println("after M : "+m);//주소번지 출력함
        String s = new String("hello");
        //Front와 Backend가 만나는 부분(타입문제-이종간임)
        //json과 List<M> -> 풀스택 -> Product개발자
        if(s instanceof String){
            System.out.println("String 타입입니다.");
        }
        if(m instanceof M){
            System.out.println("M 타입입니다.");
        }

    }
}
