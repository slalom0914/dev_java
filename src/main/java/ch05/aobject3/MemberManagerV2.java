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
    MemberVO[]      mvos            = new MemberVO[3];
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
    public MemberVO[] getMemberList(){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT mem_id, mem_name, mem_age");
        sql.append(" FROM member");
        try {
            Class.forName(_DRIVER);//오라클제품이다
            con = DriverManager.getConnection(_URL, _USER, _PW);
            pstmt = con.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            MemberVO[] mvos = null;
            MemberVO mvo = null;
            Vector<MemberVO> v = new Vector<>();
            while(rs.next()){
                mvo = new MemberVO();
                v.add(mvo);
            }
            System.out.println(v.size());//3출력-> add가 세번 반복됨
            mvos = new MemberVO[v.size()];
            v.copyInto(mvos);
        } catch (Exception e) {
            System.out.println("Exception :" + e.getMessage());
        }
        return mvos;
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
