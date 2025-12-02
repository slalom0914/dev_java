package ch04;

public class For01 {
    int cnt;//0->1->2
    int account(int start, int end){
        int i =0;
        for(i = start;i<=end;i++){
            System.out.println(i);
            if(i % 2 == 0){
                cnt++;
            }
        }//end of for
        System.out.println(i);
        return cnt;
    }//end of account
    public static void main(String[] args) {
        For01 f1 = new For01();
        int count = f1.account(1,3);
        System.out.println(count);
    }//end of main
}//end of For01
