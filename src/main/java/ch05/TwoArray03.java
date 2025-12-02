package ch05;
// 다차원 배열
// for문 -> while문
// while문 -> for문
// while문에서는 조건식에 초기화 부분이 없다. - 관찰 -> 따로 해야 함
public class TwoArray03 {
    // main에서 for문으로 출력한 결과를 while문으로 변경해 본다.
    // for문에서는 구간이 조건문에 들어가니까 제한적으로 반복이 일어남
    // while문 증감연산자가 빠져 있으면 무한루프 위험이 높은 편임.
    void methodA(int[][] is){
        int row = 0;
        while(row<is.length){
            int cols=0;//위치
            while(cols<is[row].length){
                System.out.println("is["+row+"]["+cols+"]="+is[row][cols]);
                //여기에 무한루프 방지 코드
                cols++;
            }//end of inner for
            //여기에 무한루프 방지코드
            row++;
        }//end of outter for
    }
    public static void main(String[] args) {
        //원소의 갯수는 몇 개 일까요?
        int is[][] = new int[3][];
        is[0] = new int[]{1,2,3};
        is[1] = new int[]{4,5};
        is[2] = new int[]{6,7,8,9};
        TwoArray03 ta3 = new TwoArray03();
        //나는 개발자가 정의한 메서드를 호출할 수 있다.
        //나는 정의한 메서드의 파라미터 타입과 갯수 그리고 리턴타입까지도 맞춰 쓸 수 있다.
        ta3.methodA(is);//이 부분을 작성할 수 있도록 연습하기
        // is == is[0]
        System.out.println("=============[[ for문으로 처리 ]]================");
        for(int row=0;row<is.length;row++){
            for(int cols=0;cols<is[row].length;cols++){
                System.out.println("is["+row+"]["+cols+"]="+is[row][cols]);
            }//end of inner for
        }//end of outter for

    }
}
