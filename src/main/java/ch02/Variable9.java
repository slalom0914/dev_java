package ch02;
/*
원본과 복사본
Variable9.java -> Param.class, Variable9.class
 */
class Param {
    //전역변수 - 외부에 다른 클래스에서도 접근이 가능함.
    //단 인스턴스화를 하고 사용한다.
    //초기화는 안됨 - 디폴트값이 0이다.
    int ival;
}
public class Variable9 {
    void effectParam(Param p){
        p = new Param();
        p.ival = 100;
        System.out.println("Sub ival : "+p.ival);
    }//end of effectParam
    //19-20-21-22(0->500)-23-13-14(500->100)-15(100출력)
    //16-24(100출력함)
    public static void main(String[] args) {
        Variable9 v9 = new Variable9();
        Param p = new Param();
        p.ival = 500;
        v9.effectParam(p);
        System.out.println("Main ival : "+p.ival);
    }//end of main
}// end of Variable9
