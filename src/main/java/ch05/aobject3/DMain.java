package ch05.aobject3;
// DMain.java -> D1.class, D2.class, DMain.class
class D1{

}
class D2{

}
public class DMain {
    public static void main(String[] args) {
        D1 d1 = new D1();
        System.out.println(d1);
        D1 d11 = d1;
        System.out.println(d11);
        System.out.println(d1 == d11);//true출력 - 둘의 16진수로 된 주소번지를 비교함.
        System.out.println(d1.equals(d11));//true출력
    }
}
