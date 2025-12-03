package ch05.aobject;

public class MemberVOTest3 {
    public static void main(String[] args) {
        //객체배열은 주소번지를 두 번 접근해야 함.
        MemberVO[] mvos = new MemberVO[3];
        MemberVO mvo = new MemberVO();
        mvo.setMem_id("kiwi");
        mvo.setMem_name("키위");
        mvos[0] = mvo;
        mvo = new MemberVO();
        mvo.setMem_id("apple");
        mvo.setMem_name("사과");
        mvos[1] = mvo;
        mvo = new MemberVO();
        mvo.setMem_id("tomato");
        mvo.setMem_name("토마토");
        mvos[2] = mvo;
        for(MemberVO mvo2:mvos){
            System.out.println(mvo2.getMem_id()+", "+mvo2.getMem_name());
        }

    }
}
