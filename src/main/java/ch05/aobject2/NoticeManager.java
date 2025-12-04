package ch05.aobject2;
// NoticeVO에는 main선언하지 않는다. - 왜지?
public class NoticeManager {
    public static void main(String[] args) {
        //변수 이름은 같지만 주소번지는 서로 다르다. 왜???
        NoticeVO[] nvos = new NoticeVO[3];
        NoticeVO nvo = new NoticeVO();
        nvo.setN_title("금연");
        nvos[0] = nvo;
        nvo = null;//초기화(로그아웃) - candidate 상태가 되는 지점이다.
        nvo = new NoticeVO();
        nvo.setN_title("단수");
        nvos[1] = nvo;
        nvo = null;//초기화
        nvo = new NoticeVO();
        nvo.setN_title("난방");
        nvos[2] = nvo;
        nvo = null;
        for(int i=0;i<nvos.length;i++){
            //nvos[i] = nvo;
            //금연, 단수, 난방
            //난방, 난방, 난방
            System.out.println("공지사항 제목 출력하기 "+nvos[i].getN_title());
        }
        System.out.println("여기");
    }
}
