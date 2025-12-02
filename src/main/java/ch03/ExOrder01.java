package ch03;
/*
복합 조건 : 주문 가능 여부 체크
조건 : 재고수량이 0보다 크고 사용자가 로그인한 상태이고
VIP 이거나 장바구니 금액이 50,000원 이상이면 주문이 가능하다.

 */
public class ExOrder01 {
    public static void main(String[] args) {
        int stock = 10; //재고수량
        boolean isLogin = true; //로그인 여부
        boolean isVip = false;//VIP회원 여부
        int cartTotal = 60000;
        //insert here
        boolean cartOrder = (stock > 0 && isLogin) && (isVip || cartTotal >= 50000);
        if(cartOrder){
            System.out.println("주문이 가능합니다.");
        }else{
            System.out.println("주문 조건을 충족하지 않았습니다.");
        }//end of if..else문
    }//end of main
}//end of ExOrder01
/*
stock > 0 && isLogin
-> 재고도 있어야 하고 로그인도 해야 주문이 가능함
isVip || cartTotal >= 50000
-> VIP이거나 장바구니 금액이 5만원 이상이면 OK
 */