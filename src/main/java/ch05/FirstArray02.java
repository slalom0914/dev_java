package ch05;

public class FirstArray02 {
    //변수는 선언이 먼저 사용이 나중 입니다.
    public static void main(String[] args) {
        String is[] = new String[]{"국어","영어","수학"};
/*        for(int i=0;i<is.length;i++){
            System.out.println(is[i]);
        }*/
        for(String s:is){
            System.out.println(s);
        }
    }
}
