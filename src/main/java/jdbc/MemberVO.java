package jdbc;
// VO는 Value Object 약자임
// 자바 변수와 오라클 컬럼 타입 사이에 인터페이스 역할 필요함.
// String --> varchar2
// int --> number(3)
public class MemberVO {
    private String mem_id = null;//아이디 저장
    private String mem_pw = null;//비번 저장
    private String mem_name = null;//이름 저장
    private String mem_nickname = null;//닉네임 저장
    private int    mem_age = 0;//나이

    public String getMem_nickname() {
        return mem_nickname;
    }

    public void setMem_nickname(String mem_nickname) {
        this.mem_nickname = mem_nickname;
    }

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
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

    public int getMem_age() {
        return mem_age;
    }

    public void setMem_age(int mem_age) {
        this.mem_age = mem_age;
    }

}
