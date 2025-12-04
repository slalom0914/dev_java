package ch05.aobject2.design;

import ch05.aobject.MemberVO;
//클래스 쪼개기 연습시 주의사항 - 절대로 static은 사용하지 않고서 해보기
//나는 어떤 클래스도 상속받지 않고 어떤 인터페이스도  implements하지 않는다.
//override를 해야 한다. - 강제함
//나는 순수하다.- 다른 것과 섞어쓸 때는 훨씬 유리하다.
//순수한 것은 세련되지 않다.
//재사용성이 높다. -> 결합도는 낮춰야 한다.-> 독립성 높아진다. -> 단위테스트가 쉽다->통합테스트->
//상속은 결합도를 높인다. -> 인터페이스 중심의 설계를 하고 코딩을 한다.
public class JFrame01Logic {
    public JFrame01Logic(){
        System.out.println("JFrame01Logic 생성자 호출 성공");
    }
    public MemberVO[] getList(){
        System.out.println("getList 호출 성공");
        return null;
    }
}
