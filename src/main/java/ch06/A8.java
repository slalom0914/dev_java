package ch06;
//static을 사용하는 대신 생성자를 활용하기
public class A8 {
    //생성자를 여러가지 가질 수 있다.
    //파라미터 갯수가 다르거나 타입이 다르면 중복해서 선언이 가능함
    public A8(){
        System.out.println("디폴트 생성자");

    }
    public A8(int a){
        System.out.println("A8(int)");
    }
    public A8(int a,int b){
        System.out.println("A8(int, int)");
    }

    public static void main(String[] args) {
        new A8();
        new A8(1);
        new A8(1,2);
    }

}
