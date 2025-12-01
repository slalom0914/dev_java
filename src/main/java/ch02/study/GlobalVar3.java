package ch02.study;

import javax.swing.*;
// main메서드는 엔트리 포인트 입니다. - main thead -> 가장 먼저 호출 된다.
// main가 있어야 exe파일이 생성됨 -> c++ dll, exe
// main메서드는 개발자가 호출하는 메서드가 아니다. -> 그래서 main메서드 코딩을 적게 해야 함.
//main메서드 밖에 구현한 것들이 자유도가 높다.
// 전역변수 isView를 사용하여 윈도위 창이 화면에 출력되도록
// 코드를 작성하시오.
public class GlobalVar3 {
    boolean isView = false;
    //파라미터 자리도 변수를 선언하는 자리이다.
    //초기화가 안되어 있다.- 원본이어야 한다.
    //나를 호출하기 전에 isiView를 true로 변경해 주는
    //코드가 먼저 호출되어야 함. - 그렇지 않으면 isView에 false
    //methodA를 호출하기 전에 반드시 methodB를 경유한다.
    void methodA(JFrame jf){
        jf.setVisible(isView);
    }
    //메서드는 호출해야 실행문이 실행 기회를 갖는다.
    //isView가 false이므로 true로 변경되기 위해서는 methodB를 경유해야 함
    void methodB(){
        isView = true;
    }
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400,300);
        //insert here - setVisible()
        //아래 코드의 문제점은 무엇입니까?
        GlobalVar3 gv3 = new GlobalVar3();
        //gv3.isView = true;
        gv3.methodB();//isView가 false였는데 true로 변경되었다.-원본
        gv3.methodA(jf);
        //jf.setVisible(gv3.isView);

    }
}
