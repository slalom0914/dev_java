package ch03;
// String은 불변객체이다. 원본이 바뀌지 않는다.
// String은 클래스 이다. 참조형 타입이다.
// 클래스 타입 중에서 유일하게 변수를 호출하면 문자열 값을 반환해 줌
public class Oper081 {
    public static void main(String[] args) {

        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");
        //주소번지가 같니? true
        //s1이 가리키는 값과 s2가 가리키는 값이 같니? true
        //s1처럼 new를 사용하지 않고 문자열을 생성하는 경우 기존에 있는 값을
        //참조함 -> 새로운 문자열 객체가 생성되는 것이 아니다.
        //문제 제기 : s1이 가리키는 문자열과 s2가 가리키는 문자열이 다르면 어떻게 되나요?
        System.out.println(s1==s2);//true인가? 아니면 false
        System.out.println(s3==s4);//false출력됨-둘의 주소번지가 같아?
        //s3이 가리키는 문자열값과 s4가 가리키는 문자열이 같니?  true
        System.out.println(s3.equals(s4));//true가 출력됨.
        System.out.println(s1.equals(s3));//true가 출력됨.
        System.out.println(s1==s3);//false가 출력됨.왜냐하면 주소번지를 비교하는 문장이다.
        System.out.println(s1.equals(s4));//true
        System.out.println(s2==s3);//false
        System.out.println(s2.equals(s3));//true
        System.out.println(s2==s4);//false
        System.out.println(s2.equals(s4));//true
        System.out.println(s2==s4);//주소번지가 같니? false

    }
}
