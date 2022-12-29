package dev_java.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
/*
 * 변수 이름 앞에 final이 붙으면 상수가 됨.
 * 상수는 다른 값으로 재정의 불가함.
 */
public class JDBCTest {
	//이 클래스를 읽어야 오라클 제품인것을 확인가능함.-제조업체-물리적으로 떨어져 있는
	//오라클서버에 접속이 가능하다.- ojdbc6.jar, ojdbc8.jar
	public static final String _DRIVER 
						= "oracle.jdbc.driver.OracleDriver";//앞에는 폴더이름 뒤에는 클래스명
	//물리적으로 떨어져 있는 오라클 서버에 URL정보 추가
	//오라클제품에서는 물리적으로 떨어져 있는 서버에 접속하는 방식으로 thin방식과 oci방식지원
	//멀티티어, 환경에서는 thin 방식이다.서버의  DNS , 포트번호-1521, SID이름-물리적인저장소참조
	public static final String _URL 
						= "jdbc:oracle:thin:@192.168.10.47:1521:orcl11";
	public static String _USER = "scott";
	public static String _PW = "tiger";
	//물리적으로 떨어져 있는 오라클 서버와 연결통로를 만들 때 사용
	Connection con = null;
	java.sql.PreparedStatement pstmt = null;
	//오라클에 살고 있는 커서를 조작하는 클래스를 제공함.
	//커서 위치에 로우가 존재하면 true,  조회된 결과가 없으면 false리턴
	//java.lang폴더를 제외하고는 모두 다 import해주어야 JVM이 그 클래스를 찾음.
	java.sql.ResultSet rs = null;
	public String currentTime() throws Exception{
		Class.forName(_DRIVER);//오라클 제조사 정보를 가지고 있어요.
		String sql = "select to_char(sysdate,'HH24:MI:SS') from dual";
		//아래 메소드가 호출되면 오라클 서버와 연결통로를 갖게됨.
		//이 연결통로를 통해서 select문을 전령 클래스가 가지고 들어가야 함.
		con = DriverManager.getConnection(_URL, _USER, _PW);
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();//오라클 서버에게 처리를 요청함.
		if(rs.next()) {
			return rs.getString(1);
		}
		return "15:09:49";
	}
	public static void main(String[] args) throws Exception{
		//java.lang패키지에 클래스는 모두 찾지만 그 외 패키지는 찾을 수 없다.
		//Scanner scan = new Scanner(System.in);
		JDBCTest jt = new JDBCTest();
		String ctime = jt.currentTime();
		System.out.printf("현재 시간은 %s 입니다.\n",ctime);
	}
}
