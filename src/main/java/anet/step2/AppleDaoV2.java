package anet.step2;

import util.DBConnectionMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import static util.CustomLogger.logger;

//DAO(Data Access Object)
public class AppleDaoV2 {
    // 선언부
    DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    public AppleDaoV2() {}
    /*************************************************************
     * 제목 : 대화명 변경하기
     * @param mem_id, mem_nickname
     * @return int
     *************************************************************/
    public int nickNameChange(String mem_id, String mem_nickname) {
        int result = -1;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE member         ");
        sql.append(" set  mem_nickname = ?");
        sql.append(" WHERE mem_nickname = ?");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, mem_nickname);
            pstmt.setString(2, mem_id);
            result = pstmt.executeUpdate();
            logger("result 1이면 성공,0이면 실패: "+result);
        }catch(Exception e) {
            logger(e);
        }finally {
            dbMgr.freeConnection(con, pstmt);
        }

        return result;
    }
    /*************************************************************
     * 제목 : 로그인 구현하기
     * @param userId 사용자가 입력한 아이디
     * @param userPw 사용자가 입력한 비번
     * @return 로그인 성공 후 조회된 닉네임
     *************************************************************/
    public String login(String userId, String userPw){
        String nickName = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT mem_nickname  ");
        sql.append(" FROM member          ");
        sql.append(" WHERE mem_id =?");
        sql.append(" AND mem_pw =?");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, userId);
            pstmt.setString(2, userPw);
            rs = pstmt.executeQuery();
            if(rs.next()){
                nickName = rs.getString("mem_nickname");
            }
            System.out.println("nickName : "+nickName);
        }catch(Exception e){
            System.out.println(e.toString());
        }finally {
            dbMgr.freeConnection(con,pstmt,rs);
        }
        //return "대화명";
        return nickName;
    }
    /*************************************************************
     * 제목 : 회원가입 구현하기
     * INSERT INTO member(mem_id, mem_pw, mem_nickname, mem_name
     *                  , gender, zipcode, address)
     * VALUES(:id, :pw, :nick, :name, :gender, :zipcode, :address);
     * @param mVO
     * @return result : 1이면 등록 성공, 0이면 등록 실패
     *************************************************************/
    public int memberInsert(MemberVO mVO){
        System.out.println("memberInsert");
        System.out.println(mVO.getMem_id());
        System.out.println(mVO.getMem_pw());
        System.out.println(mVO.getMem_nickname());
        System.out.println(mVO.getMem_name());
        System.out.println(mVO.getGender());
        System.out.println(mVO.getZipcode());
        System.out.println(mVO.getAddress());
        int result = -1;//1이면 회원가입 성공, 0이면 회원가입 실패
        StringBuilder sql = new StringBuilder();
        int i = 1;
        try {
            sql.append("INSERT INTO member(mem_id, mem_pw, mem_nickname, mem_name ");
            sql.append("                 , gender, zipcode, address)              ");
            sql.append("VALUES(?, ?, ?, ?, ?, ?, ?)");
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());//?갯수 파악됨       \
            //i는 후위 연산자 이므로 1부터 1씩 증가 하면서 채워짐
            pstmt.setString(i++, mVO.getMem_id());//1
            pstmt.setString(i++, mVO.getMem_pw());//2
            pstmt.setString(i++, mVO.getMem_nickname());//3
            pstmt.setString(i++, mVO.getMem_name());//4
            pstmt.setString(i++,mVO.getGender());//5
            pstmt.setString(i++,mVO.getZipcode());//6
            pstmt.setString(i++,mVO.getAddress());//7
            result = pstmt.executeUpdate();//1이면 성공, 0이면 실패
            System.out.println("result : "+result);
        }catch(SQLException se){
            System.out.println("[SQLException]: "+sql);
            logger(se.getMessage());
        }catch(Exception e){
            System.out.println("[Exception]: "+e.getMessage());
        }finally {
            dbMgr.freeConnection(con, pstmt);
        }
        return result;
    }
    /*************************************************************
     * 제목 : 편번호와 주소 가져오기
     * @param zdo //사용자가 선택한 시도 정보
     * @param dong //사용자가 입력한 동이름
     * @return ZipCodeVO[]
     ************************************************************/
    public ZipCodeVO[] getAddress(String zdo, String dong){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT zipcode, address");//부적합한 식별자- Toad
        sql.append(" FROM zipcode_t");//테이블 또는 뷰가 존재하지 않습니다. -Toad
        sql.append(" WHERE 1=1");
        if(zdo !=null && zdo.length() > 0){
            sql.append(" AND zdo = ?");
        }
        if(dong !=null && dong.length() > 0){
            sql.append(" AND dong LIKE '%'||?||'%'");
        }
        int i = 1;
        //꼭 배열이어야 하나요?
        //왜 객체 배열을 리턴타입으로 했나요?
        ZipCodeVO[] zvos = null;
        try {
            //반복되는 코드를 피하기 위해서 DBConnectionMgr추가함.
            //그랬더니 비번과 계정이름, 드라이버 클래스, URL 등을 보지 않아도 됨
            //한 달에 한 번씩 계정에 대한 비번을 변경하더라도 한 곳만 고치면
            //모든 소스에 적용된다.
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            //위에서 작성한 select문의 ?갯수를 파악하여 매핑되는 값 지정함.
            if (zdo != null && zdo.length() > 0) {
                pstmt.setString(i++, zdo);//콤보박스 선택된 값
            }
            if (dong != null && dong.length() > 0) {
                pstmt.setString(i++, dong);//JTextField에 입력 후 엔터쳤을 때 혹은 찾기버튼 눌렀을 때
            }
            //조회나 상세조회 일때는 executeQuery를 사용한다.
            //executeQuery는 리턴타입이 ResultSet이고,
            //입력,수정,삭제 일때는 executeUpdate를 사용한다.
            //executeUpdate는 리턴타입이 int이다.
            rs = pstmt.executeQuery();
            //조회 결과를 내가 예측할 수  없어서 Vector클래스를 사용하기로 했다.
            //조회 결과 n건을 담으려고 ZipCodeVO[]선언함.
            //String[] names = new String[3];
            Vector<ZipCodeVO> v = new Vector<>();

            ZipCodeVO zvo = null;
            while (rs.next()) {
                zvo = new ZipCodeVO(rs.getString("zipcode")
                        , rs.getString("address"));
                v.add(zvo);
            }//end of while
            logger(v);
            zvos = new ZipCodeVO[v.size()];
            //벡터에 저장된 정보를 객체 배열에 복사하기
            v.copyInto(zvos);
            //문제제기: 만일 두 번 연속해서 조회할 경우 앞에 조회결과가 남아 있다.
            //기존에 조회된 결과는 삭제하고 새로 출력한다.
            //만일 참이면 조회결과가 있다.이고 만일 거짓이면 조회결과가 없음


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
        AppleDaoV2 appleDao = new AppleDaoV2();
        //appleDao.getZdoList();
//        MemberVO mVO = new MemberVO();
//        mVO.setMem_id("nice");
//        mVO.setMem_pw("123");
//        mVO.setMem_nickname("나신입");
//        mVO.setMem_name("강감찬");
//        mVO.setGender("남자");
//        mVO.setZipcode("12356");
//        mVO.setAddress("서울시 영등포구 당산동");
//        int result = appleDao.memberInsert(mVO);
//        if(result == 1) System.out.println("입력 성공");
//        else if(result == 0) System.out.println("등록 실패");
//        appleDao.login("apple","123");
        appleDao.nickNameChange("나신입","하늘공원");
    }
}
