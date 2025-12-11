package ch0708;
//FlyBehavior는 인터페이스 이므로 반드시 구현체 클래스가 있어야 인스턴스화 가능함.
//이 때 인터페이스가 선언만 하고 있는 메서드를 재정의(Overriding)한다.
//클래스 설계시에 필요한 chapter이다.
//결합도가 낮은 설계, 독립적인 설계 -> 재사용성을 높이고 이식성을 좋게 한다.
public class FlyWithWing implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("나는 날고 있어요.");
    }
}
