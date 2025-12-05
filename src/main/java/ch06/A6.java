package ch06;
//Object는 자바가 제공하는 클래스 이고
//A6은 사용자가 정의한 클래스이다.
public class A6 extends Object{

    //부모가 정의하고 있는 메서드를 재정의하면 그 이후부터
    //부모의 메서드는 은닉됨
    /*
    @Override
    public String toString(){
        return "A6";
    }
     */
    public static void main(String[] args) {
        A6 a6 = new A6();
        //모든 클래스의 부모클래스인 Object가 정의하고 있는 메서드
        System.out.println(a6);//주소번지가 출력됨
        //toString()메서드는 A6클래스가 구현하는 메서드가 아니라
        //부모인 Object가 구현해 논 메서드이다.
        //부모가 구현(선언)하고 것들은 자손 클래스가 사용할 수 있다. - 재사용성
        System.out.println(a6.toString());//주소번지가 출력됨
        //만일 재정의를 하려고 하면 할 수 있는데 단 원형을 훼손하면 안됨
        //원형- 파라미터, 리턴타입
        //재정의 -> 메서드 오버라이딩 -> 부모와 자손 관계
    }
}
