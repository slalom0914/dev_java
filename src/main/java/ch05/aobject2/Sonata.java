package ch05.aobject2;
//객체(추상)와 클래스(설계도) 구별
//클래스 선언하기
//접근제한자 class 클래스이름
//클래스는 필드와 메서드(단일책임원칙)로 구성됨.
public class Sonata {
    //선언부
    //고유명사를 전변으로 한다.
    private int     speed;
    private int     wheelNum;
    private String  carColor;
    //아래를 생성자라고 부른다. - 파라미터가 없는 생성자를 디폴트 생성자라 함.
    //디폴트 생성자는 파라미터를 결정할 필요가 없어서 JVM제공해줌. - 생략해도 괜찮아
    //파라미터가 있는 생성자는 JVM이 제공할 수 없다.- 누가 결정해야 하지?
    //처리(메서드)에 대해 설계하기 - 파라미터(갯수,타입), 리턴타입(응답->출력)
    //생성자가 있어서 전변에 대한 초기화를 생략할 수 있었다.
    //생성자
    public Sonata(){
        System.out.println("소나타 디폴트 생성자 이다.");
    }
    //메인메서드 - main thread라고 함. - 가장 먼저 실행됨 - entry point
    public static void main(String[] args) {
        Sonata myCar = null;
        //어떤 이름뒤에 괄호가 있는 두 가지가 있다.
        //메서드, 생성자
        myCar = new Sonata();
        myCar.speedUp();
        System.out.println(myCar.speed);//?
    }
    void speedUp() {
        System.out.println("speedUp호출");
        //오직 전변만이 변수이름 앞에 인스턴스변수나 혹은 this수정자를 쓸 수 있다.
        this.speed = this.speed + 1;
    }
}
