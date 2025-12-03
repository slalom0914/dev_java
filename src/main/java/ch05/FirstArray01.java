package ch05;

public class FirstArray01 {
    public static void main(String[] args) {
        //선언과 생성을 한 번에 처리하기(타임라인에 걱정은 덜함)
        //만일 선언과 생성을 분리해서 처리할 때는 타임라인에 사전 대비
        //NullPointerException발생할 수 있다는 점
        int is[] = new int[3];
        int is1[] = null;//배열 선언
        //자바에서는 선언부가 아닌 생성부의 이름으로 결정됨
        is1 = new int[5];//배열 생성
    }
}
