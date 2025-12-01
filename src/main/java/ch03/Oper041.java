package ch03;

public class Oper041 {
    public static void main(String[] args) {
        int a = 2;//호출하면 값이 나온다
        //출력이 먼저야? 아니면 증가연산자가 먼저 처리되는거야?
        System.out.println(a++);//출력이 먼저다:2, 증가가 먼저라면:3
        //아래 초기화를 주석으로 하면 a = 2, a = 4가 출력된다.
        //주석을 풀어주면 a = 2, a = 3이 출력됨
        a = 2;
        System.out.println(++a);// 3
    }
}
