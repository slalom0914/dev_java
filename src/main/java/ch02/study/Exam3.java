package ch02.study;
//Exam3.java 안에 Other클래스와 Exam3클래스 2개가 생김
//Other.class,  Exam3.class
//주의사항은 둘 중에 하나만 public을 붙일 수 있음.
class Other{
    int ival;
    //지역변수는 메서드 영역안에서 선언된 변수 이다.
    //또는 파라미터 자리에 선언된 변수 이다.
    //아래는 메서드 선언 입니다.
    void methodA(int x){
        int y = 0;
    }
}

public class Exam3 {
    public static void main(String[] args) {
        //Other클래스를 메모리에 로딩하기
        //클래스는 heap메모리 영역에 살고
        //지역변수는 stack메모리 영역에 있음.
        Other other = new Other();
        System.out.println(other.ival);//0이 출력됨
        //System.out.println(other.x);
        //System.out.println(other.y);
    }
}
