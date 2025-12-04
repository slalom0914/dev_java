package ch05.aobject2;

public class Hint1 {
    //6->7(객체배열-3개-null,null,null)-8(선언만-객체)-9(반복문)
    //조건비교-10
    public static void main(String[] args) {
        NoticeVO[] nvos = new NoticeVO[3];
        NoticeVO nvo = null;
        for(int i=0;i<nvos.length;i++){
            nvos[i] = nvo;
        }
        for(NoticeVO nvo2: nvos){
            System.out.println(nvo2);
        }
    }
}
