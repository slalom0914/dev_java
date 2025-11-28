package ch02;
// 메서드의 리턴타입 자리에도 정수 타입이 올 수 있다.
// 리턴 타입으로 반환받은 값을 어떻게 다른 메서드에서 사용하는가?
// 메서드 안에서 선언된 변수는 지변이다.
// 지변은 선언 된 메서드 내에서만 접근이 가능하다.
public class Variable6 {
    //메서드 선언시에 리턴타입을 줄 수 있다.
    //반환값이 없다면 void라고 쓰고 반환값이 있을 땐 타입을 맞춰서 사용할것.
    //괄호앞에 이름이 있다면 메서드이다. 이름 앞에는 리턴타입에 대해 추가 할 수 있다.
    int methodA(){
        int i = 1;
        System.out.println("methodA : "+i);
        i = i + 2;
        return i;
    }//end of methodA
    public static void main(String[] args) {
        // 굳이 main메서드 안에서 methodA에 선언된 지변 i의 값을 사용하고
        // 싶다. 어떻게 하지?
        Variable6 v6 = new Variable6();
        int i = v6.methodA();
        System.out.println("main : " + i);
    }//end of main
}
