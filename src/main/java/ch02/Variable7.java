package ch02;
// 메서드 이름 앞에 void일때 와 리턴타입이 있을 때
public class Variable7 {
    void methodA(){
        System.out.println("methodA() 호출");
    }
    int methodB(){
        System.out.println("methodB() 호출");
        return 5;
    }
    //자바에서는 메서드의 리턴타입 자리에 두 개를 반환할 수 없다.
    public static void main(String[] args) {
        int x = 2;
        boolean isFlag = false;
        //println()호출함
        System.out.println(x);//2
        System.out.println(isFlag);//false
        Variable7 v7 = new Variable7();
        //반환타입이 없는 경우에 println()메서드 내에서 호출이 불가함.
        //메서드 파라미터 자리에서 또 다른 메서드 호출이 가능함.
        //System.out.println(v7.methodA());
        v7.methodA();
        //메서드 내부에서 계산된 결과를 그 메서드 외부에서
        //사용하고자 할 때는 아래와 같이 사용할 수 있다.
        System.out.println(v7.methodB());//5출력
    }
}
