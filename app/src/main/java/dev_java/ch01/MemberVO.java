package dev_java.ch01;
//자료구조의 일부로 사용함
public class MemberVO {
  private String mem_id = null;
  private String mem_pw = null;
  private String mem_name = null;
  //setter는 write, save
  public void setMem_id(String mem_id){
    this.mem_id = mem_id;
  }
  //getter는 read,듣기
  public String getMem_id(){
    return mem_id;
  }
}
