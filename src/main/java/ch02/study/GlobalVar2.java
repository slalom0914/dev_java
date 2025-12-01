package ch02.study;

public class GlobalVar2 {
    String ename = "나초보";
    public static void main(String[] args) {
        GlobalVar2 gv2 = new GlobalVar2();
        System.out.println(gv2.ename);//나초보
        gv2.ename = "SCOTT";
        System.out.println(gv2.ename);//SCOTT
    }
}
