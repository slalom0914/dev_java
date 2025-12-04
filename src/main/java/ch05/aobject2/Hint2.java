package ch05.aobject2;

public class Hint2 {
    public static void main(String[] args) {
        NoticeVO[] nvos = new NoticeVO[3];
        //for문 밖에서 인스턴스화를 하고 있다.-> 같은것만 들어갔다.
        NoticeVO nvo = new NoticeVO();
        for(int i=0;i<nvos.length;i++){
            nvos[i] = nvo;
        }
        for(NoticeVO nvo2: nvos){
            System.out.println(nvo2);
        }
    }
}
