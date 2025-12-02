package ch05;
// 배열을 생성할 때 new 예약어를 사용하고 있다. - 참조형 타입이다.
// 컬렉션 프레임워크 - 제네릭 활용
// 메모리에는 2층이 없다.
// 1차배열과 2차 배열 비교
// int is[0] 1차 배열의 경우에는 값을 반환합니다.
// 동일한 표현식 int is[0]이 2차 배열에서는 1차배열의 주소번지임.
// 1차배열이 두 개 모인게 2차 배열이다.
// 그래서 2차배열의 값을 출력하려면 배열 기호가 2개 있어야 한다.
// System.out.print(is[0][1])
public class TwoArray01 {
    public static void main(String[] args) {
        // 0,0, 0,1, 0,2
        // 1,0, 1,1, 1,2
        int is[][] = new int[2][3];
        for(int row=0;row<is.length;row=row+1){
            for(int cols=0;cols<is[row].length;cols=cols+1){
                System.out.println("is["+row+"]["+cols+"]="+is[row][cols]);
            }//end of inner for
        }//end of outter for
    }
}
