package ch02;

public class Variable4 extends Object {
    //사용자 정의 메서드를 구현하였다.
    //b=1; 재정의에 대한 위치에 따라 결과가 달라질 수 있다는 점 확인하는 코드추가
    //변수 a에 b를 대입하기 전에 추가했을 때와 후에 추가했을 때가 결과에 영향이 있다|없다.
    void methodA(){
        int a = 1;
        int b = 2;
        System.out.println("methodA before: a:"+a+",b:"+b);//1, 2
        b = 1;
        a = b;//a=2
        System.out.println("methodA after: a:"+a+",b:"+b);//2, 2
    }
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println("before: a:"+a+",b:"+b);//1, 2
        a = b;//a=2
        b = 1;
        System.out.println("after: a:"+a+",b:"+b);//2, 2
        System.out.println("===================[[ main ]]======================");
        //내 안에 선언한 메서드 이더라도 main안에서 호출할 땐 인스턴스화
        Variable4 v4 = new Variable4();
        v4.methodA();
        System.out.println("methodA호출 후");
    }
}
