package ch02;

public class Variable3 {
    //당신의 나이를 담을 수 있는 전역변수를 선언하시오.
    //타입은 무엇으로 하나요? int
    //변수명은 무엇으로 할까요? age
    //초기화는 메인메서드에서 하라고 하니 여기서는 0으로 할께요
    int age = 0;
    //메인메소드를 선언하여 전역변수에 초기화를 30살로 해 보시오.
    public static void main(String[] args) {
        //main메서드에서 전변을 사용하려면 인스턴스화를 합니다.
        //호출 할 때는 인스턴스변수.나이변수로 함.
        Variable3 v3 = new Variable3();//전역변수를 호출하기 위해 인스턴스화를 함.
        //전역변수 age는 Variable3클래스가 메모리에 로딩 될 때 같이 초기화 된다.
        //아래 문장을 만나기 전까지는 0을 쥐고 있다가 아래코드가  실행되면 30으로 바뀜
        v3.age = 30;//전역변수 age에 대해서 재정의 하였다.
        System.out.println(v3.age);//30이 출력되었다.
    }//end of main
}// end of Variable3
