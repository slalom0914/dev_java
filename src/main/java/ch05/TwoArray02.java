package ch05;
//2차 배열
public class TwoArray02 {
    public static void main(String[] args) {
        int is[][] = null;
        is = new int[2][3];
        is[0] = new int[]{1,3,5};
        is[1] = new int[]{2,4,6};
        System.out.println(is);
        System.out.println("is.length는 행의 숫자 : "+is.length);//2
        //insert here - 나는 컬럼의 숫자를 출력하고 싶다.어떡하지?
        System.out.println("is[0].length는 컬럼의 숫자 : "+is[0].length);//3
        System.out.println("is[1].length는 컬럼의 숫자 : "+is[1].length);//3
        for(int x=0;x<is.length;x++){
            System.out.println(is[x]);
        }
    }//end of main
}//end of TwoArray02
