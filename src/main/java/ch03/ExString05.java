package ch03;
//String은 좀 특이한 객체이다.
//StringBuilder 나 혹은 StringBuffer 중 하나를 사용합니다.
public class ExString05 {
    public static void main(String[] args) {
        String s1 = "Hello";
        System.out.println(s1);//Hello
        System.out.println(s1 + " World!!!");//Hello World!!!
        System.out.println(s1);//Hello
        String s2 = "jaja";
        System.out.println(s2.replace('j','h'));//haha
        System.out.println(s2);//jaja
    }
}
