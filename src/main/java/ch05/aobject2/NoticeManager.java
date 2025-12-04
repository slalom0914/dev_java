package ch05.aobject2;
// NoticeVO에는 main선언하지 않는다. - 왜지?
public class NoticeManager {
    public static void main(String[] args) {
        //변수 이름은 같지만 주소번지는 서로 다르다. 왜???
        NoticeVO nvo = new NoticeVO();
        nvo.setN_title("금연");
        nvo = null;//초기화(로그아웃)
        nvo = new NoticeVO();
        nvo.setN_title("단수");
        nvo = null;//초기화
        nvo = new NoticeVO();
        nvo.setN_title("난방");
        System.out.println("여기");
    }
}
