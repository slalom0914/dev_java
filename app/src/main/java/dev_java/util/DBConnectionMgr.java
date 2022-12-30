package dev_java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnectionMgr {
	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String _URL = "jdbc:oracle:thin:@192.168.10.47:1521:orcl11";
	public static String _USER = "scott";
	public static String _PW = "tiger";

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, _USER, _PW);
		} catch (ClassNotFoundException ce) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
		} catch (Exception e) {// 멀티 블럭 작성시 더 넓은 클래스가 뒤에 와야함
			System.out.println("오라클 서버와 커넥션 실패!!!");
		}
		return con;
	}
	// 사용한 자원을 반납하는 코드는 명시적으로 하는 것을 원칙으로 하고 있음
	//반납하는 순서는 생성된 역순으로 진행할 것. - 자바튜닝팀 지적사항
	// 사용한 자원 반납하기 - INSERT, UPDATE, DELETE
	public void freeConnection(Connection con, Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}// end of freeConnection
	public void freeConnection(Connection con, PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}// end of freeConnection




	// 사용한 자원 반납하기 - SELECT - 커서 조작이 필요함
	public void freeConnection(Connection con, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}// end of freeConnection
	public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}// end of freeConnection



	public static void main(String[] args) {
		DBConnectionMgr dbMgr = new DBConnectionMgr();
		Connection con = dbMgr.getConnection();
		System.out.println("con ===> " + con);
	}
}

/*
 * JDBC API를 이용하여 DB연동하기
 * 1. 각 제조사가 제공하는 드라이버 클래스를 로딩한다.(ojdbc6.jar)
 * Class.forName(드라이버 클래스적음-풀네임);
 * 2. 물리적으로 떨어져 있는 오라클 서버와 연결 통로를 확보 한다.
 * Connection은 인터페이스이다. - 오른쪽에 구현체클래스가 와야 한다.
 * 
 * Connection con = DriverManager.getConnection(URL,"scott","tiger");
 * 3. DML문을 자바에서 오라클 서버로 전달해 줄 인터페이스를 생성한다.(Statement:정적쿼리문,
 * PreparedStatement:동적쿼리문지원)
 * 
 * 4. SELECT문의 경우 오라클 서버에서 제공하는 커서를 지원 하는 ResultSet 인터페이스를 활용하여
 * 테이블에 제공되는 커서를 조작하여 해당 로우에 데이터가 존재하면 Cursor....open...fetch과정을 통해서
 * 오라클 서버로 부터 데이터를 꺼내서 List<DeptVO>에 담을 수 있다.
 * 
 * 주의 : INSERT, UPDATE, DELETE 에서는 커서가 필요없음 - commit, rollback
 * 리턴값은 int 임
 * 이것들을 요청할 때는 executeUpdate(INSERT문 or UPDATE or DELETE문)
 * SELECT일때는
 * ResultSet rs = executeQuery("SELECT * FROM dept");
 * 오라클에서 제공되는 커서를 조작하는 인터페이스를 리턴 타입으로 제공받아서
 * 조회 결과를 Collection에 담을 수 있다.
 * List<DeptVO> deptList = new ArrayList<>();
 * DeptVO dVO = null;
 * while(rs.next()){
 * dVO = new DeptVO();
 * 
 * deptList.add(dVO);
 * }
 * 
 * 사용한 자원을 반납할 때는 사용한 역순으로 닫아주면 됨
 * SELECT인 경우
 * ResultSet먼저 닫고
 * Statement 혹은 PreparedStatement 두 번째로 닫고
 * Connection을 맨 나중에 닫아주면 됨
 * 닫지 않으면 자동으로 언젠가 닫아주기는 하지만 명시적으로 닫아주면
 * 닫는 시간을 앞당길 수 있어 플젝에서는 명시적으로 닫는 코드 작성을 가이드로 정함
 * 
 * INSERT, UPDATE, DELETE는 두번째와 세번째만 닫으면 됨
 * 왜냐하면 리턴타입이 커서가 필요없으니까.....
 */