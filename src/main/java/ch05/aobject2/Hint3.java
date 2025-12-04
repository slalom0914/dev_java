package ch05.aobject2;

public class Hint3 {
    public static void main(String[] args) {
        NoticeVO[] nvos = new NoticeVO[3];
        NoticeVO nvo = null;
        int i = 0;
        //인스턴스화를 반복문 안에서
        while(i<nvos.length){
            nvo = new NoticeVO();
            nvos[i] = nvo;
            i++;//증감연산자가 있어야 무한루프에 빠지지 않음.
        }
        for(NoticeVO nvo2: nvos){
            System.out.println(nvo2);
        }
    }
}
