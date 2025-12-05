package ch06;
/*
substring(int beginindex)
substring(int beginindex, int endindex)
 */
public class P162 {
    public static void main(String[] args) {
        String s = "Oracle Project";
        String result = s.substring(3);
        System.out.println(result);
        result = s.substring(3,5);
        System.out.println(result);
    }
}
