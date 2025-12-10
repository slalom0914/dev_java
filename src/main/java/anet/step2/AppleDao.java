package anet.step2;

import util.DBConnectionMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AppleDao {
    //선언부
    DBConnectionMgr     dbMgr = DBConnectionMgr.getInstance();
    Connection          con = null;
    PreparedStatement   pstmt = null;
    ResultSet           rs = null;
}
