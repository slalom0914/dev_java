package ch02.study;
// 지변은 초기화를 생략할 수 없다.
public class LocalVar1 {
    int methodA(){
        int i;//
        i = 2;
        //System.out.println(i);
        return i;
    }
    //automatic variable, local variable
    //파라미터 자리에 지변을 선언하면 언제 초기화가 되나요?
    //왜냐면 지변은 초기화를 생략할 수 없다.
    //메서드는 호출 될 때마다 여러 번 실행됨.
    void methodB(int i){
        System.out.println("methodB i : "+i);
    }
    public static void main(String[] args) {
        //문제 지역변수 i의 값을 굳이 main메서드에서 출력하도록
        //코드를 작성해 보시오.
        LocalVar1 lv1 = new LocalVar1();
        //변수 i는 지역변수 이므로 아래와 같이 호출이 불가함.
        //System.out.println(lv1.i);
        lv1.methodB(3);
        //methodB는 리턴타입이 void이므로 대입연산자를 통해 반환받을  수 없음
        //int i = lv1.methodB(3);
        //methodA에서 선언된 지변 i와 main에서 선언된 지변 i는 서로 다르다.
        int i = lv1.methodA();
        System.out.println(i);
        lv1.methodB(3);
    }
}
