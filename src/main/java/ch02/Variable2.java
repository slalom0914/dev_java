package ch02;
// 클래스 내부에서 코딩을 한다.
// 자바에서는 8가지 타입을 제공합니다. - int(4byte), long(8byte-64)
// int와 long은 모두 정수를 담을 수 있는데 담을 수 있는 값의 크기 차이가 있다.
// 윈도우를 32bit로 설치하면 램을 8GB사용 못함
// 어차피 char, byte 는 JVM이 int로 형전환하여 처리하므로 의미없음
// 일괄처리, 상태값 관리
public class Variable2 {
    //선언부 - 여기에 선언하면 전역변수임(member variable, global variable)
    int empno;//원본이다 재정의하면 원본이 바뀐다. -> 싱글턴
    //사용자 정의 메서드

    //main 메서드
    public static void main(String[] args) {
        //자바에서는 자원관리를 가비지 컬렉터가 담당함
        //사용 한 후에 다시 사용되지 않으면 캔디데이트 상태로 체크했다가
        //가비지 컬렉터가 회수 함.
        //변수 선언하기-> 타입을 쓴다, 변수이름을 쓴다, 초기화를 한다.
        //지변은 초기화를  생략할 수 없다.
        int salary = 0;//지역변수(local variable, automatic variable)
        System.out.println("지역변수 : "+salary);
        //지역변수는 선언 후 바로 사용이 가능하지만 전역변수는 내안에 있어도
        //반드시 인스턴스화를 하고 사용한다.
        Variable2 v2 = new Variable2();//인스턴스화 하면 내가 만든 클래스가 heap메모리에 로딩됨
        //전역변수를 호출하려면 변수 이름 앞에 인스턴스 변수명.닷트연산자 붙이고 호출함
        //인스턴스화에 사용된 변수 v2를 인스턴스변수라고 한다.
        v2.empno = 8000;
        System.out.println(v2.empno);//0출력됨. 전변은 초기화를 생략할 수 있고 디폴트값은 0이다.
    }
}
