package ch06;
class C6{
    int ival;
    private C6(){
        System.out.println("C6()디폴트 생성자 호출");
    }
    C6(int ival){
        System.out.println("C6(int)생성자 호출 성공");
        this.ival = ival;
    }
    //메서드의 리턴타입을 활용하여 객체를 주입받을 수도 있다.
    public static C6 getInstance(){
        C6 c=new C6();
        return c;
    }
}//end of C6
public class C6Main {
    public static void main(String[] args) {
        //C6 c6=new C6();
        C6 c6=C6.getInstance();
        C6 c61=new C6(1);
        System.out.println(c6.ival);
    }
}
