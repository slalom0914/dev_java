package ch03;
// 증감연산자 - for문 사용됨, 대입연산자,
// i = i + 1; i = i - 1;
// 전위 연산자 와 후위 연산자
public class Oper04 {
    public static void main(String[] args) {
        int a = 1;
        //대입연산자가 먼저인가요? 아님 증가하는게 먼저 인가요?
        int b = ++a;//
        System.out.println("a : "+a+" , b : "+b);
        System.out.printf("a : %d, b : %d%n",a,b);
        //b = a++;
    }
}
