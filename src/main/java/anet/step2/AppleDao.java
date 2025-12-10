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
