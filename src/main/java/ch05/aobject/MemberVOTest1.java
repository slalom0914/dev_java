package ch05.aobject;

public class MemberVOTest1 {
    public static void main(String[] args) {
        //객체배열은 주소번지를 두 번 접근해야 함.
        MemberVO[] mvos = new MemberVO[3];
        MemberVO[] mvos1 = new MemberVO[]{null, null, null};
        for (MemberVO mvo: mvos){
            System.out.println(mvo);
        }
        for (MemberVO mvo: mvos1){
            System.out.println(mvo);
        }
        MemberVO mvo = new MemberVO();
        mvo.setMem_id("kiwi");
        mvo.setMem_id("apple");
        mvo.setMem_id("tomato");
        mvos[0] = mvo;
        //this.mem_id = mem_id
        System.out.println(mvos[0].getMem_id());//tomato

    }
}
