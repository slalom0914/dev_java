package ch05;
class EmpVO extends Object{
    int empno;
    String ename;
    String job;
    /*
    @Override
    public String toString(){
        return "사번은 7566이고 이름은 SCOTT, 그리고 Job은 개발 입니다.";
    }
    */
}
public class EmpMain {
    public static void main(String[] args) {
        //객체 배열이라고 함.
        EmpVO evos[] = new EmpVO[3];//null, null, null
        for(int i=0;i<evos.length;i++){
            evos[i] = new EmpVO();
            evos[i].empno = 7566;
            evos[i].ename = "SCOTT";
            evos[i].job = "개발";
            System.out.println(evos[i].job);
        }
    }
}
