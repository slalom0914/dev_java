package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//하나로 공유한다. - 싱글턴 패턴 적용한다.
public class DBConnectionMgr {
    private static DBConnectionMgr dbMgr =null;
    private static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String _URL    = "jdbc:oracle:thin:@localhost:1521:orcl11";
    private static final String _USER   = "scott";
    private static final String _PW     = "tiger";
    public Connection conn = null;
    private DBConnectionMgr() {

    }
    //static이 있는 메서드나 변수는 프로세스에서 하나로 공유됨
    //인스턴스화를 여러 번 하더라도(즉 복제본이 생겨도) 하나이다.
    //싱글턴 패턴 적용하는 코드
    public static DBConnectionMgr getInstance(){
        //dbMgr변수가 참조하는 객체가 없을 때만 생성해줘
        if(dbMgr==null){
            dbMgr = new DBConnectionMgr();
        }
        return dbMgr;
    }
    //연결 객체 생성
    //리턴타입이나 파라미터 자리에 원시형 타입 보다는
    //객체 타입으로 연습하기
    public Connection getConnection() {
        try{
            Class.forName(_DRIVER);
            conn = DriverManager.getConnection(_URL, _USER, _PW);
        }catch(ClassNotFoundException ce){
            System.out.println("드라이버 클래스를 찾을 수 없습니다.");
        }catch (Exception ex){
            System.out.println("연결 실패!!!"+ex.getMessage());
        }
        return conn;
    }//end of getConnection
    //DB연동에 사용된 자원은 반드시 명시적으로 반납할 것.-GC(가비지 컬렉터-데몬스레드)
    public void freeConnection(Connection conn, PreparedStatement pstmt){
        if(pstmt!=null){
            try {
                pstmt.close();
            }catch(Exception ex){}
        }
        if(conn!=null){
            try {
                conn.close();
            }catch(Exception ex){}
        }
    }//end of freeConnection
    public void freeConnection(Connection conn, PreparedStatement pstmt, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            }catch(Exception ex){}
        }
        if(pstmt!=null){
            try {
                pstmt.close();
            }catch(Exception ex){}
        }
        if(conn!=null){
            try {
                conn.close();
            }catch(Exception ex){}
        }
    }//end of freeConnection
}
