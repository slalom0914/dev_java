package anet.step2;

import util.DBConnectionMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import static util.CustomLogger.logger;

//DAO(Data Access Object)
public class AppleDao {
    // 선언부
    DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    AppleZipCode azc = null;
    public AppleDao() {}
    public AppleDao(AppleZipCode azc) {
        this.azc = azc;
    }
    //우편번호와 주소 가져오기
    public ZipCodeVO[] getAddress(String zdo, String dong){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT zipcode, address");
        sql.append(" FROM zipcode_t");
        sql.append(" WHERE 1=1");
        if(zdo !=null && zdo.length() > 0){
            sql.append(" AND zdo = ?");
        }
        if(dong !=null && dong.length() > 0){
            sql.append(" AND dong LIKE '%'||?||'%'");
        }
        int i = 1;
        ZipCodeVO[] zvos = null;
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            //위에서 작성한 select문의 ?갯수를 파악하여 매핑되는 값 지정함.
            if (zdo != null && zdo.length() > 0) {
                pstmt.setString(i++, zdo);//콤보박스 선택된 값
            }
            if (dong != null && dong.length() > 0) {
                pstmt.setString(i++, dong);//JTextField에 입력 후 엔터쳤을 때 혹은 찾기버튼 눌렀을 때
            }
            rs = pstmt.executeQuery();
            Vector<ZipCodeVO> v = new Vector<>();

            ZipCodeVO zvo = null;
            while (rs.next()) {
                zvo = new ZipCodeVO(rs.getString("zipcode")
                        , rs.getString("address"));
                v.add(zvo);
            }//end of while
            zvos = new ZipCodeVO[v.size()];
            //벡터에 저장된 정보를 객체 배열에 복사하기
            v.copyInto(zvos);
            //문제제기: 만일 두 번 연속해서 조회할 경우 앞에 조회결과가 남아 있다.
            //기존에 조회된 결과는 삭제하고 새로 출력한다.
            //만일 참이면 조회결과가 있다.이고 만일 거짓이면 조회결과가 없음
            if (v.size() > 0) {
                //조회 결과가 남아 있어요
                while (azc.dtm_zipcode.getRowCount() > 0) {
                    azc.dtm_zipcode.removeRow(0);
                }
            }//end of if
            //조회된 결과를 DefaultTableModel에 매칭하기
            for (int x = 0; x < zvos.length; x++) {
                //벡터 생성하기
                Vector<Object> oneRow = new Vector<>();
                oneRow.add(0, zvos[x].getZipcode());
                oneRow.add(1, zvos[x].getAddress());
                azc.dtm_zipcode.addRow(oneRow);
            }//end of for
        }catch(SQLException se) {
            logger("[[SQLException] : ]]"+sql.toString());
        }catch(Exception ex){
            logger(ex.toString());
        }
        return zvos;
    }
    // 콤보박스에 출력될 시도정보 가져오기
    public String[] getZdoList() {
        String[] zdos = null;
        StringBuilder sql = new StringBuilder();
        //테이블이나 뷰가 존재하지 않습니다
        //부적합한 식별자,,,,,
        sql.append("SELECT '전체' zdo FROM dual");
        sql.append(" UNION ALL ");
        sql.append("SELECT zdo");
        sql.append(" FROM (");
        sql.append("        SELECT distinct(zdo) zdo");
        sql.append("        FROM zipcode_t ORDER BY zdo asc");
        sql.append("       )");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            //조회 결과가 몇 행인지 알 수 없어서 Vector를 활용함
            Vector<String> v = new Vector<String>();
            String imsi = null;
            while (rs.next()) {
                imsi = rs.getString("zdo");
                v.add(imsi);
            }
            zdos = new String[v.size()];
            System.out.println(zdos.length);//0이출력됨
            v.copyInto(zdos);
            System.out.println(zdos.length);//17이 출력됨
        } catch (SQLException se) {
            System.out.println("[[SQLException]]" + se.getMessage());
            logger("[[SQLException]]" + se.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return zdos;
    }// end of getZdoList

    public static void main(String[] args) {
        AppleDao appleDao = new AppleDao();
        appleDao.getZdoList();
    }
}
