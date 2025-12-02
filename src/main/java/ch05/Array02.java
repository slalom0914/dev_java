package ch05;

public class Array02 {
    public static void main(String[] args) {
        int is[] = new int[3];// 0 0 0
        int js[] = new int[]{1,2,3};//1 2 3
        int xs[] = {2,4,6};//2 4 6
        for(int a = 0; a<is.length; a=a+1){
            System.out.println(is[a]+", "+ js[a] + ", "+xs[a]);
        }
    }
}
