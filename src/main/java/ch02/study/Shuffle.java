package ch02.study;
/*
변수에는 한 번에 하나만 담을 수 있다.
변수 a에 b의 값을 담기 전에 a의 값을 다른 변수에 담아 둔다.
 */
public class Shuffle {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int imsi = 0;
        imsi = a;
        a = b;
        b = imsi;
        System.out.println("a:"+a+", b:"+b);
    }
}
