package dev_java.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dev_java.util.DBConnectionMgr;

/*
 * 변수 이름 앞에 final이 붙으면 상수가 됨.
 * 상수는 다른 값으로 재정의 불가함.
 */
public class JDBCTest2 {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBConnectionMgr dbMgr = new DBConnectionMgr();

	public String currentTime() throws Exception {
		con = dbMgr.getConnection();
		String sql = "select to_char(sysdate,'HH24:MI:SS') as currentTime from dual";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();// 오라클 서버에게 처리를 요청함.
		if (rs.next()) {
			return rs.getString("currentTime");
		}
		return "15:09:49";
	}

	public static void main(String[] args) throws Exception {
		// java.lang패키지에 클래스는 모두 찾지만 그 외 패키지는 찾을 수 없다.
		// Scanner scan = new Scanner(System.in);
		JDBCTest2 jt = new JDBCTest2();
		String ctime = jt.currentTime();
		System.out.printf("현재 시간은 %s 입니다.\n", ctime);
	}
}
