package ch03;

public class ExString02 {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        System.out.println(s1 == s2);//
        System.out.println(s1.equals(s2));//
        System.out.println(s1.hashCode() == s2.hashCode());//true
    }
}
/*
String클래스가 제공하는 hashCode()는 내용 기반이므로
같은 내용이면 같은 해시값을 반환함.
즉 객체가 서로 다르더라도 내용이 같으면 같은 hashCode를 만든다.
 */
