package ch06;
//자바에서는 같은 이름의 메서드를 여러개 선언할 수 있다.
//메서드 오버라이딩 이거나 메서드 오버로딩이면 가능함.
public class A10 {
    void methodA(){
        System.out.println("methodA() 호출");
    }
    void methodA(String s){
        System.out.println("methodA(String)");
    }
    void methodA(boolean isOk){
        System.out.println("methodA(boolean)");
    }
    void methodA(int i, String name){
        System.out.println("methodA(int, String)");
    }
    public static void main(String[] args) {
        A10 a=new A10();
        a.methodA();
        a.methodA("String");
        a.methodA(false);
        a.methodA(2,"String");
    }
}
