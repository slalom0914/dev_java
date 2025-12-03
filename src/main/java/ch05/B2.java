package ch05;

public class B2 {
    int i = 1;
    B2 b1 = null;//여기 b1변수는 전변이고
    void methodA(){
        if(b1 !=null) {//흐름이 바뀌었다.
            System.out.println(b1.i);
        }else{
            System.out.println("여기");
        }
    }
    public static void main(String[] args) {
        B2 b1 = new B2();//여기 b1은 지변이다.- 서로 다르다
        b1.methodA();
    }
}
