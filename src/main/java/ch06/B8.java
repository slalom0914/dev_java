package ch06;

public class B8 {
    public static void main(String[] args) {
        int[] is = null;
        //System.out.println(null.length);
        try{
            //예외가 발생할 가능성이 있는 코드를 쓰기
            System.out.println(is.length);
        }catch(NullPointerException e){
            System.out.println("is가 생성되지 않아서 에러가 발생함");
        }
        System.out.println("여기");
    }
}
