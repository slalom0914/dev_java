package ch03;
/*
identityHashCode()는 객체가 실제로 같은 인스턴스 인지 구분하는데 사용하는 값을 반환.
identityHashCode()의 값은 실제 메모리 주소는 아니다.
하지만 JVM이 객체를 식별할 때 사용할 수 있는 가상의 식별코드이다.

 */
public class ExString03 {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = new String("Java");
        System.out.println(s1==s2);//주소번지가 다르다 - false
        //변수가 가리키는 문자열 값을 비교하는것임
        System.out.println(s1.equals(s2));//true
        //만일 s1과 s2가 같은 객체이라면 identityHashCode값도 같다.
        //다른 객체이라면 identityHashCode값은 다르다.
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
    }
}
