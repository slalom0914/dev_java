package jdbc;


import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class MemberDao {
    private final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String _URL = "jdbc:oracle:thin:@localhost:1521:orcl11";
    private final String _USER = "scott";
    private final String _PW = "tiger";
    //물리적으로 떨어져 있는 오라클서버에 세션을 연결함
    Connection          con     = null;
    //개발자가 작성한 select문 전달하고 요청함
    PreparedStatement   pstmt   = null;
    //아래는 오라클의 cursor를 추상화한 인터페이스임
    ResultSet           rs      = null;
    /*************************************************************************************
     * 오라클 scott계정에서 회원정보 가져오기 구현
     * SELECT mem_id, mem_pw, mem_name, mem_nickname, mem_age
     *  FROM SCOTT.member
     * WHERE mem_id = 'kiwi'
     * @param  mem_id
     * @return MemberVO[] - 객체배열
     * 나는 메서드를 설계할 수 있다.
     * 나는 파라미터 갯수와 타입을 결정하고 리턴타입을 선택할 수 있다.
     ************************************************************************************/
    public MemberVO[] getMemberList(String mem_id){
        System.out.println("getMemberList");
        System.out.println("사용자가 입력한 아이디는 : "+mem_id);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT mem_id, mem_pw, mem_name, mem_nickname, mem_age");
        sql.append(" FROM SCOTT.member");//From앞에 띄어쓰기 안하면 SQLException보게됨
        try {
            //1. 오라클 제조사가 제공하는 드라이버 클래스를 메모리에 로딩함.
            Class.forName(_DRIVER);
            //2. 오라클 서버와 연결 객체 생성
            // JDBC API -> MyBatis -> JPA(Hibernate)
            con = DriverManager.getConnection(_URL, _USER, _PW);
            //3. 연결객체를 통해서 쿼리문을 전달하고 오라클 에게 select문 처리 요청함.
            pstmt = con.prepareStatement(sql.toString());
            //4. select문을 요청하면 오라클은 open..cursor..fetch과정을 거침
            //rs.next():커서를 다음으로 rs.previous():커서를 이전으로 rs.absolute(3):커서를 세번째로
            rs = pstmt.executeQuery();
            MemberVO[] mvos = null;
            MemberVO mvo = null;
            //데이터베이스 테이블에 몇 명이 있는지 알수가 없다.
            //그래서 자료 구조 중 size()제공하는 List계열의 객체를 생성하고
            //반복문이 돌때마다 add()호출하여 파라미터로 mvo주소번지를 담아줌.
            //이렇게 하는 이유는 배열의 원소의 갯수를 개발자가 알 수 없기 때문임.
            Vector al =new Vector();
            while(rs.next()){
                mvo = new MemberVO();//
                mvo.setMem_id(rs.getString("mem_id"));
                mvo.setMem_age(rs.getInt("mem_age"));
                mvo.setMem_name(rs.getString("mem_name"));
                al.add(mvo);
            }
            //while문 밖에서 배열객체의 생성이 가능함.
            mvos = new MemberVO[al.size()];
            //문제제기 : 배열안에는 null만 세 개 있다.
            //회원에 대한 정보는 Vector안에는 들어 있다.
            //그래서 벡터안에 있는 데이터를 배열에 복사해주는 메서드를 찾았다.
            al.copyInto(mvos);
            for(int i=0;i<mvos.length;i++){
                MemberVO rmvo = mvos[i];
                System.out.println(rmvo.getMem_id()+", "+rmvo.getMem_age()+", "+rmvo.getMem_name());
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("드라이버 클래스를 찾을 수 없음.");
        //} catch (SQLException se){

        } catch (Exception e) {
            System.out.println("[[Exception]]" + e.getMessage());
        }
        System.out.println("예외가 발생하지 않으면 여기...");
        return null;
    }
    public static void main(String[] args) {
        //XXXXDao -> Data Access Object
        MemberDao mDao = new MemberDao();
        MemberVO[] mvos = mDao.getMemberList("kiwi");
    }
}
