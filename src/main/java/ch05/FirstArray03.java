package ch05;

public class FirstArray03 {
    public static void main(String[] args) {
        //나는 객체 배열 입니다.
        String is[] = new String[3];
        is[0] = new String("국어");
        is[1] = new String("영어");
        is[2] = new String("수학");
        for(String s:is){
            System.out.println(s);
        }
    }
}
