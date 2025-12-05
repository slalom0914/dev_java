package ch06;
//파라미터에 원시형 타입 넘기기  - 쉬움
//파라미터에 참조형 타입 넘기기 - 어렵다
public class B6 {
    void methodA(int is[]){
        for(int i=0;i<is.length;i++){
            System.out.println(is[i]);
        }
    }//end of methodA(1차배열)
    void methodA(int is[][]){
        //외부 for문은 행에 대한 인덱스 갯수만큼 반복
        for(int i=0;i<is.length;i++){
            //내부 for문은 열에 대한 인덱스 갯수만큼 반복
            for(int j=0;j<is[i].length;j++){
                System.out.println(is[i][j]);
            }
        }
    }//end of methodA(2차배열)
    public static void main(String[] args) {
        B6 b6 = new B6();
        int is[] = new int[3];//0,0,0
        int is1[] = {1,2,3};//1,2,3
        int is2[] = new int[]{4,5,6};//4,5,6
        //b6.methodA(new int[]{1,2,3});
        b6.methodA(is);
        b6.methodA(is1);
        b6.methodA(is2);
        int is3[][] = new int[2][3];
        int is4[][] = {{1,2,3},{4,5,6}};
        int is5[][] = new int[][]{{10,20,30},{40,50,60}};
        b6.methodA(is3);
        System.out.println("===========================");
        b6.methodA(is4);
        System.out.println("===========================");
        b6.methodA(is5);

    }//end of main
}
