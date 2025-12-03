package ch05.aobject;

public class MemberVOTest2 {
    public static void main(String[] args) {
        //객체배열은 주소번지를 두 번 접근해야 함.
        MemberVO[] mvos1 = new MemberVO[]{new MemberVO(), new MemberVO(), new MemberVO()};
        for(MemberVO mvo: mvos1){
            System.out.println(mvo);
        }
    }
}
