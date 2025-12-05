package ch06;

public class P166 {
    public static void main(String[] args) {
        String str = "자바,오라클,스프링";
        String[] strs = str.split(",");
        //개선된 for문
        for(String s: strs){
            System.out.println(s);
        }
        System.out.println("=======================");
        for(int i=0;i<strs.length;i++){
            System.out.println(strs[i]);
        }
    }
}
