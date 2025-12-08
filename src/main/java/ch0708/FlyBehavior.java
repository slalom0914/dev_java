package ch0708;
//추상적이다 는 아직 결정되지 않았다. 미정이다.
public interface FlyBehavior {
    //메서드 이름 뒤에 {} 이면 구현이고
    //세미콜론으로 끝나면 추상메서드 이다.
    //인터페이스는 추상클래스 보다 더 추상적이어서 일반메서드
    //생성자 모두 가질 수 없다.
    public void fly();
}
