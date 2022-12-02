package dev_java.ch01;

import javax.swing.JOptionPane;

public class MemberAction {
  // 회원가입을 처리하는 메소드 선언하기
  public int memberInsert(String mem_id, String mem_pw, String mem_name) {
    System.out.println("memberInsert 호출 - 파라미터 3개");
    System.out.println(mem_id + ", " + mem_pw + ", " + mem_name);
    int result = -1;
    // 회원가입에 성공했니?
    if (1 == 1) {
      result = 1;
    } else {
      result = 0;
    }
    return result;
  }

  public int memberInsert(MemberVO memberVO) {
    System.out.println("memberInsert 호출 - 파라미터 1개");
    System.out.println(memberVO.getMem_id() +
        ", " + memberVO.getMem_pw() +
        ", " + memberVO.getMem_name());
    int result = -1;// End of file
    result = 0;
    return result;
  }

  public static void main(String[] args) {
    // insert here - memberInsert 메소드 호출하시오.
    MemberAction memberAction = new MemberAction();
    int result = memberAction.memberInsert("apple", "123", "사과");
    if (result == 1) {
      System.out.println("회원가입 성공하였습니다.");
    } else {
      System.out.println("회원가입 실패하였습니다.");
    }
    MemberVO memberVO = new MemberVO();
    memberVO.setMem_id("tomato");
    memberVO.setMem_pw("456");
    memberVO.setMem_name("토마토");
    int result2 = memberAction.memberInsert(memberVO);
    if (result2 == 1) {
      System.out.println("회원가입 성공하였습니다.");
    } else {
      System.out.println("회원가입 실패하였습니다.");
    }
  }
}
