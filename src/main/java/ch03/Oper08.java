package ch03;

public class Oper08 {
    public static void main(String[] args) {
        //String타입은 문자열을 담는 타입임.
        String db_id = "admin";
        String db_pw = "123";
        String user_id = "admin";
        String user_pw = "123";
        //문자열을 비교할 때는 equals라는 메서드를 사용한다.
        System.out.println(1==1);//true
        //System.out.println(1=1);//=하나이면 오른쪽 값을 왼쪽에 대입하세요.
        System.out.println(1!=1);//false
        //db_id의 주소번지와 user_id의 주소번지가 같니?
        System.out.println(db_id == user_id);// false
        //db_id의 주소번지가 가리키는 값과 user_id의 주소번지가 가리키는 값이  같은지를 비교함.
        System.out.println(db_id.equals(user_id));//true
    }
}
