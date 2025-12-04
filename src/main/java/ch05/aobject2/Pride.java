package ch05.aobject2;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;

//클래스를 상속 받을 수 있다. -> extends
//A is a B의 관계이면 상속관계로 정의함
//부모가 제공하는 메서드도 내가 사용(호출)할 수 있다.
//자바 API가 제공하는 것들을 활용하여 개발한다.
public class Pride extends Object {
    int speed;
    public Pride(){
        System.out.println("Pride디폴트 생성자 호출");
        System.out.println(this.speed);
    }
    //annotation - 클래스 동일한 취급 - spring
    //자바에서는 같은 이름의 메서드를 인정함
    //단 메서드 오버라이딩 또는 메서드 오버로딩 규칙을 준수한다면....
    //선언부(접근제한자, 리턴타입, 파라미터)는 손대지 않는다.
    //부모 가졌던 toString()메서드가 은닉메서드가 된다. shadow
    @Override
    public String toString(){
        return "나는 프라이드 자동차이고 현재 속도는 " + speed + " 입니다.";
    }
    public static void main(String[] args) {
        //인스턴스화라고 함. yourCar는 인스턴스변수
        Pride yourCar = new Pride();
        //main에서는 static영역이어서 this를 사용할 수 없음
        //System.out.println(this.speed);
        System.out.println(yourCar.speed);
        System.out.println(yourCar.toString());
        System.out.println(yourCar);
    }
}
