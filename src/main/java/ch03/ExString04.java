package ch03;
// String - 읽기 전용 클래스 이다.
// 원본이 바뀌지 않음. - 불변객체이다.
public class ExString04 {
    public static void main(String[] args) {
        String s1 = "Hello";
        System.out.println(System.identityHashCode(s1));
        s1 = s1 + " World!!!";
        System.out.println(System.identityHashCode(s1));
        s1 = s1 + " Java";
        System.out.println(System.identityHashCode(s1));
        //s1 객체가 3개가 만들어 졌다.
    }
}
