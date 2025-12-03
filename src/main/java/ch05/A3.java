package ch05;

public class A3 {
    int i = 1;
    static A3 a5 = null;
    static A3 a51 = new A3();
    static void methodA(){
        System.out.println(a5.i);
    }
    public static void main(String[] args) {
        methodA();
    }
}
