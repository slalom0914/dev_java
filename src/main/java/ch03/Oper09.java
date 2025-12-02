package ch03;
/*
불필요한 연산은 안 한다. -> 최적화 부분과 관련이 있는 예제
앞이 이미 false이면 뒤는 안 본다.(AND) - 교집합
앞이 이미 true이면 뒤는 안 본다.(OR) - 합집합
 */
public class Oper09 {
    boolean left(){
        System.out.println("left() 호출");
        return false;
    }//end of left - 사용자 정의 메서드이다.
    boolean right(){
        System.out.println("right() 호출");
        return true;
    }//end of left - 사용자 정의 메서드이다.
    public static void main(String[] args) {
        Oper09 o09 = new Oper09();
        System.out.println("=== AND 연산 ===");
        //논리 연산자가 &이면 참 참 일 때만 결과도 참이다.
        //둘 하나라도 거짓이면 결과는 거짓이다.
        //첫번째 조건에서 false가 나왔으므로 뒤에 있는 조건을 따질
        //필요가 없지 않나?
        boolean result1 = o09.left() & o09.right();
        //boolean result1 = o09.left() && o09.right();
        System.out.println("결과 : " + result1);
        System.out.println("=== OR 연산 ===");
        //OR연산자는 둘 중에 하나라도 참이면 결과도 참이다.
        //참 거짓=참, 거짓 참 = 참, 참 참 = 참
        //앞에 결과가 참이 나왔다 그렇다면 결과값은 참인 것이 결정되었다.
        //결정되었음에도 굳이 뒤에 있는 조건을 따질 필요가 있는건가?
        boolean result2 = o09.right() || o09.left();
        System.out.println("결과 : " + result2);
    }
}
