package ch05.aobject2;
class N{}
//접근제한자
//public > protected > friendly(아무것도 없으면) > private
//private으로 하면 캡슐화를 실현하는 것이다.
//해당 변수의 위변조를 막아야 한다.
public class NoticeVO {
    //캡슐화로 인한 제약을 메서드로 해결해 본다.
    private int n_no;//primary key
    private String n_title;//공지 제목
    private String n_content;
    //getter메서드 - 리턴타입이 있다. - 그러나 파라미터는 없다. - 읽기전용
    //전변에 담긴 값을 읽는다.
    //그러면 전변에는 누가 언제 값을 담는거죠? - setter메서드로 저장함
    //어떻게 쓰죠? -인스턴스화
    public String getN_title() {
        return n_title;
    }
    //setter메서드 - 리턴타입 비어있다. - 돌려받을 수 없는 메서드 이다.
    //이 메서드 내부에서 사용된 지변의 값을 외부에서 사용 불가함.
    //파라미터는 있어야 함. - 왜냐면 파라미터값을 전변에 저장해야 함.
    public void setN_title(String n_title) {
        this.n_title = n_title;
    }

    public int getN_no() {
        return n_no;
    }

    public void setN_no(int n_no) {
        this.n_no = n_no;
    }

    public String getN_content() {
        return n_content;
    }

    public void setN_content(String n_content) {
        this.n_content = n_content;
    }



}
