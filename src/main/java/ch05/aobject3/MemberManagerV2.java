package ch05.aobject3;
//java.lang패키지는 자동으로 임포트 되지만 나머지는 따로 해야 함.
import jdbc.MemberVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberManagerV2 implements ActionListener {
    /*  오라클 서버 연동하기  */
    private final String _DRIVER    = "oracle.jdbc.driver.OracleDriver";
    private final String _URL       = "jdbc:oracle:thin:@localhost:1521:orcl11";
    private final String _USER      = "scott";
    private final String _PW        = "tiger";
    Connection          con     = null;
    PreparedStatement   pstmt   = null;
    ResultSet           rs      = null;
    JFrame          jf              = new JFrame();
    MemberVO[]      mvos            = null;
    JPanel          jp_north        = new JPanel();
    String          cols[]          = {"아이디","이름","나이"};
    String          data[][]        = new String[0][3];
    DefaultTableModel dtm_member    = new DefaultTableModel(data,cols);
    //JTable은 양식(폼) - <table> - JTable이 데이터를 가질 수 없음
    //테이블구조를 그려주는 클래스와 데이터셋을 만들어주는 클래스가 분리됨
    JTable          jtb_member      = new JTable(dtm_member);
    JTableHeader    header          = jtb_member.getTableHeader();
    JScrollPane     jsp_member      = new JScrollPane(jtb_member);
    JButton         jbtn_all        = new JButton("조회");
    public MemberManagerV2(){
        //생성자 안에서 내 안에 선언된 메서드를 호출할 땐
        //인스턴스 변수가 필요없음.
        initDisplay();
    }
    //화면 그리기 구현
    //front-end와 back-end 경계되는부분
    public void initDisplay(){
        System.out.println("initDisplay");
        jbtn_all.addActionListener(this);
        jf.add("North",jbtn_all);//북쪽에 버튼 배치하기
        jf.add("Center",jsp_member);//중앙에 배치하기
        jf.setSize(500,400);//가로세로 크기
        jf.setVisible(true);//화면 보여줌
    }

    /************************************************************************
     * 오라클 서버에 접속해서 회원정보 가져오기
     * sql: SELECT mem_id, mem_name, mem_age FROM member
     * @param null
     * @return MemberVO[]
     ************************************************************************/
    public MemberVO[] getMemberList(){
        //String은 불변객체이고  또 읽기 전용 클래스 이어서 불편함
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT mem_id, mem_name, mem_age");
        //from절 앞에 띄어쓰기 확인요망. 맨 뒤에 세미콜론제거되었는지
        sql.append(" FROM member");
        //예외상황 발생할 수 있을 때 try..catch블록을 사용함.
        try {
            //오라클 제조사가 제공하는 드라이버 클래스를 로딩하기.
            Class.forName(_DRIVER);//오라클제품이다
            //연결객체 생성하기 -파라미터가 세 개 필요함.
            con = DriverManager.getConnection(_URL, _USER, _PW);
            //개발자 작성한 select문 전달
            pstmt = con.prepareStatement(sql.toString());
            //오라클 서버에게 처리 요청하고 응답을 받아오기
            //select문 요청시에는 executeQuery사용함. 그리고 리턴타입은 ResultSet
            rs = pstmt.executeQuery();
            //n개 행을 담기 위해서 객체 배열을 선언했음. 그런데 size정할 수 없음.
            //MemberVO[] mvos = null;
            //한 행에 3종류의 컬럼이 있으므로 한 행을 담는 클래스는 MemberVO 하였음.
            //VO패턴에는 한 번에 오직 한 행만 담을 수 있다.
            //여러행을 담고 싶다면 객체 배열을 선언함.
            //아래 인스턴스화에서 선언만하고 생성은 반복문에서 해야함.
            MemberVO mvo = null;
            Vector<MemberVO> v = new Vector<>();
            while(rs.next()){
                //반복문 안에서 왜 객체생성을 해야하나?
                mvo = new MemberVO();
                mvo.setMem_id(rs.getString("mem_id"));
                mvo.setMem_name(rs.getString("mem_name"));
                mvo.setMem_age(rs.getInt("mem_age"));
                //count수를 알 수 없으므로 벡터 자료구조에 담기
                //v.size()메서드를 통해서 count수를 알아낼 수 있다.
                v.add(mvo);
            }
            System.out.println(v.size());//3출력-> add가 세번 반복됨
            //반복문에서 add한 숫자만큼 배열의 크기가 됨
            mvos = new MemberVO[v.size()];
            //위 객체배열은 현재 빈 깡통이다.
            //벡터안에 담긴 MemberVO를 MemberVO[]에 복사해주는 메서드가
            //copyInto메서드 이다.
            v.copyInto(mvos);
        } catch (Exception e) {
            System.out.println("Exception :" + e.getMessage());
        }
        return mvos;//반환되는 mvos는 전역변수
    }
    public static void main(String[] args) {
        MemberManagerV2 mm = new MemberManagerV2();
        //mm.initDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("조회버튼을 눌렀을 때만 호출됨.-개발자가 호출하는게 아님");
        String command = e.getActionCommand();//버튼의 라벨을 읽어옴.
        //조회 버튼 누른거야? 네
        if("조회".equals(command)){
            //아래 메서드에서 하는 역할은 MemberVO[]의 의미있는데이터를 초기화 하는 부분임.
            //즉 아래 메서드를 주석으로 막으면 초기화가 안됨->  null, null, null -> NullPointerException
            getMemberList();
            //조회 버튼을 눌렀을 때 기존에 있는 행은 모두 삭제하는
            //코드를 작성하시오.
            //행의 수가 0보다 크다면 기존에 조회된 결과가 남아있음.
            while(dtm_member.getRowCount() > 0){
            // 왜 0만 지우는거야? -> DefaultTableModel의 행이 지워질때마다
            // 행의 인덱스값이 1씩 줄어드니까 큰숫자부터 지우게 되면 지워진 다음에
            // 행의 인덱스값이 1 줄어들어서 존재하지 않으므로 맨앞에 부터 지움
                dtm_member.removeRow(0);
            }//end of while
            for(int i=0;i<mvos.length;i++){
                //객체배열에 들어 있는 MemberVO의 주소번지를 mvo에 초기화하기
                MemberVO mvo = mvos[i];
                //벡터클래스를 생성한 이유는 DefaultTableModel에 데이터를
                //출력하려면 addRow메서드를 사용해야 하는데 파라미터로 Vector타입만 가능함.
                //그래서 Vector를 생성하고 배열에서 차례대로 꺼낸 주소번지를 활용하여
                //getter메서드로 값을 넣어줌.
                Vector<Object> v = new Vector<>();
                v.add(mvo.getMem_id());
                v.add(mvo.getMem_name());
                v.add(mvo.getMem_age());
                dtm_member.addRow(v);
            }//end of for
        }
    }
}
