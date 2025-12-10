package jdbc;

import util.DBConnectionMgr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class XXXCRUD {
    DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
    Connection          conn = null;
    PreparedStatement   pstmt  = null;
    ResultSet           rs   = null;
    /****************************************************************************
     * 입력(등록,주문) 구현하기
     * insert into member(mem_id, mem_pw, mem_nick)
     * values('kiwi','123','키위')
     * @param mem_id, mem_pw, mem_nick
     * @return 1이면 입력 성공, 0이면 입력 실패
     ***************************************************************************/
    public int xxxInsert(String mem_id, String mem_pw, String mem_nick){
        int result = -1;
        try {
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement("insert문");
            result = pstmt.executeUpdate();
        }catch(Exception ex){
        }finally{
            dbMgr.freeConnection(conn,pstmt);
        }
        return result;
    }
    /****************************************************************************
     * select mem_nick from member
     * where mem_id =:userId
     *   and mem_pw =:userPw
     * values('kiwi','123','키위')
     * @param userId, userPw
     * @return mem_nick
     ***************************************************************************/
    public String login(String userId, String userPw){
        String mem_nick = null;
        try{
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement("select문");
            rs = pstmt.executeQuery();
            while(rs.next()){

            }
        }catch(Exception ex){

        }//end of try...
        return mem_nick;
    }
    /****************************************************************************
     * delete from member
     * where mem_id=:userId
     * @param userId
     * @return int 1이면 삭제 성공, 0이면 삭제 실패
     ***************************************************************************/
    public int xxxDelete(String userId){
        int result = -1;
        try {
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement("delete문");
            result = pstmt.executeUpdate();
        }catch(Exception ex){
        }finally{
            dbMgr.freeConnection(conn,pstmt);
        }
        return result;
    }
    /****************************************************************************
     * update member
     * set mem_pw =:userPw,
     *     mem_nick =:userNick
     * where mem_id=:userId
     * @param userId
     * @return int 1이면 수정 성공, 0이면 수정 실패
     ***************************************************************************/
    public int xxxUpdate(String userId, String mem_pw, String mem_nick){
        int result = -1;
        try {
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement("update문");
            result = pstmt.executeUpdate();
        }catch(Exception ex){
        }finally{
            dbMgr.freeConnection(conn,pstmt);
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
