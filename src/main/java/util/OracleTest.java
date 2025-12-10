package util;

import java.sql.Connection;

public class OracleTest {
    public static void main(String[] args) {
        DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
        //DBConnectionMgr dbMgr1 = new DBConnectionMgr();
        Connection conn = dbMgr.getConnection();
        System.out.println(conn);
    }
}
