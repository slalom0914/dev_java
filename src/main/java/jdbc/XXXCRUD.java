package jdbc;

public class XXXCRUD {
    /****************************************************************************
     * insert into member(mem_id, mem_pw, mem_nick)
     * values('kiwi','123','키위')
     * @param args
     ***************************************************************************/
    /****************************************************************************
     * select mem_nick from member
     * where mem_id =:userId
     *   and mem_pw =:userPw
     * values('kiwi','123','키위')
     * @param String userId, String userPw
     * @return String nickName
     ***************************************************************************/
    /****************************************************************************
     * delete from member
     * where mem_id=:userId
     * @param userId
     * @return int 1이면 삭제 성공, 0이면 삭제 실패
     ***************************************************************************/
    /****************************************************************************
     * update member
     * set mem_pw =:userPw,
     *     mem_nick =:userNick
     * where mem_id=:userId
     * @param userId
     * @return int 1이면 수정 성공, 0이면 수정 실패
     ***************************************************************************/
    public static void main(String[] args) {

    }
}
