package ch02;
/*
전역변수 와 지역변수
지역변수의 위치 : 생성자의 파라미터 자리, 메서드 파라미터 자리
, for문 내에 선언한 변수
 */
public class Variable5 {
    //메서드 자리에 선언된 변수도 지변
    //지변이면 초기화를 어떻게 하지? -> 메서드가 호출될 때
    //메서드 괄호 다음에 좌중괄호와 우중괄호가 있으면 선언이다.
    void methodA(int i, int j){
        System.out.println(i + ", " + j);
    }
    void methodB(int i, int j){
        i = 10;
        j = 20;
        System.out.println(i + ", " + j);//10, 20
    }
    public static void main(String[] args) {
        Variable5 v5 = new Variable5();
        v5.methodA(1,2);
        //insert here
        v5.methodB(3,4);
    }
}
