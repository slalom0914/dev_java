package ch02;
// 클래스 선언하기
// 클래스 파일에 코딩을 한다. - 코딩을 하는 최소 파일이 클래스
// Variable1.java -> 컴파일 -> Variable1.class(이진)- 배포하는 파일이다.
// 왜냐면 .java고급언어(주석-회사업무내용, 프로세스,,, 포함) -> build(레거시:Maven, Gradle)
public class Variable1 {
    //선언부

    //사용자 정의 메서드
    //우리는 어제 JDK21을 설치함(JVM-Java Virtual Machine:이 로컬에 설치됨)
    //자바코딩을 한다. -> 클래스 선언하고 그 안에 코딩을 한다.
    //자바코딩을 위해서는 XXX.java파일을 만든다.
    //컴파일은 고급언어를 저급언어로 변경해 주는 것
    //컴파일 위해서 JVM설치함
    //컴파일 과정에서 타입을 체크한다.- 타입이 틀리면 문법에러 발생함.- 실행 불가함
    //문법 오류가 없어야 정상적으로  XXX.class생성됨 -> 실제로 이파일이 실행됨.
    //운영서버에 올리는 파일도 XXX.class파일이다.
    //보안 이슈로 패키지(폴더)가 없는 클래스는 에러임
    //실행파일로 만들기 위해서는 main메서드가 있어야 한다.- 웹기반이 아니다.
    //로컬 에서 실행할 때 필요한 메서드 이다.
    //가장 먼저 실행되는 것이 main메소드 입니다. - entry point - main thread
    public static void main(String[] args) {//14-15
        System.out.println("main 호출");
        // 변수 선언 및 초기화
        // 원시형 타입의 변수 선언하기(8가지)
        int empno = 7566;
        empno = 7499;
        int deptno;//변수 선언
        deptno = 10;//초기화
        System.out.println("사원번호 : "+empno);
    }
}
