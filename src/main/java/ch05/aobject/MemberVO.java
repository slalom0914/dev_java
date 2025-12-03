package ch05.aobject;
// getter와 setter
// Spring Boot수업에서는 Lombok 사용할께요
// 하나의 클래스 안에서는 여러가지 종류의 변수 선언이 가능함.
public class MemberVO {
    //접근제한자 private은 클래스 내부에서만 접근이 가능함.
    //private으로 변경하면 외부 클래스에서 직접 변조가 불가함.
    //변수는 읽기와 쓰기가 가능해야 함.
    private String mem_id   = null;//아이디
    private String mem_pw   = null;//비번
    private String mem_name = null;//이름
    private String mem_nick = null;//닉네임
    //getter메서드 - 읽기
    //getter는 리턴타입이 있음. 파라미터는 필요없음
    public String getMem_id() {
        return mem_id;
    }
    //setter메서드 - 쓰기, 저장
    //setter는 리턴타입은 필요없음. 파라미터는 무엇을 쓸 것인가 이므로 필요함.
    public void setMem_id(String mem_id) {
        //대입연산자 오른쪽은 지변이고 왼쪽은 전변이다.
        //인스턴스변수명.변수명 -> this는 나(MemberVO) 자신을 가리키는 수정자 이다.
        //전변에 대한 위변조를 막기 위해서 캡슐화 하였다.
        //대신 읽기와 쓰기를 지원하기 위해서 getter 와 setter가 추가됨.
        this.mem_id = mem_id;
    }

    public String getMem_pw() {
        return mem_pw;
    }

    public void setMem_pw(String mem_pw) {
        this.mem_pw = mem_pw;
    }

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    public String getMem_nick() {
        return mem_nick;
    }

    public void setMem_nick(String mem_nick) {
        this.mem_nick = mem_nick;
    }



}
