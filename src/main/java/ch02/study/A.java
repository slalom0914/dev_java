package ch02.study;

public class A {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a);
        System.out.println(a.toString());
        a = null;//객체 초기화
        //a = null로 치환되었다가 다시 새로운 객체를 생성하는 그 시점(순간)
        //GC가 Candidate상태로 찜을 해둠 - 언젠가 처리됨 -> 메모리 크기를 출력해봄
        a = new A();//여기서 생성된 객체는 5번에서 생성된 객체와는 전혀 다른 객체임
        System.gc();

    }
}
