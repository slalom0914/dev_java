package ch05;

public class FirstArray01 {
    public static void main(String[] args) {
        //선언과 생성을 한 번에 처리하기(타임라인에 걱정은 덜함)
        //만일 선언과 생성을 분리해서 처리할 때는 타임라인에 사전 대비
        //NullPointerException발생할 수 있다는 점
        int is[] = new int[3];
        //변하는 것과 변하지 않는 것을 관찰해 보기
        //변하지 않는 것들은 공통으로 분리할 수 있다. -> 보일러플레이트 코드 줄임
        is[0] = 1;
        is[1] = 2;
        is[2] = 3;
        // 개선된 for문이다.
        for(int i:is){
            System.out.println(i);
        }
        for(int i=0;i<is.length;i++){
            System.out.println(is[i]);
        }
        int is1[] = null;//배열 선언
        //자바에서는 선언부가 아닌 생성부의 이름으로 결정됨
        is1 = new int[5];//배열 생성
    }
}
