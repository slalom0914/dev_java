package ch03;
// 직사각형의 면적을 구하는 프로그램을 작성하시오.
// 변수가 몇 개 필요한가요? - 2개
// 2개 변수의 타입은 무엇으로 할까요? - 정수로 한다.
public class RectAngle01 {
    public static void main(String[] args) {
        //가로길이를 담을 변수 선언하기
        int width = 2;
        //높이를 담을 변수 선언하기
        int height = 3;
        //면적을 구해서 담을 변수도 선언해 보자 - 변수가 3개 필요함.
        int area = 0;
        //면적을 구하는 식
        area = width * height;
        System.out.println("직사각형의 면적은 " + area);
    }
}
