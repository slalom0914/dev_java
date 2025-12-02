package ch03;

import java.util.Scanner;

// 나이 범위 체크(성인요금, ,)
public class AgeRange01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();
        //성인 기준 : 19세이상이고 65세 미만
        if(age >= 19 && age < 65){
            System.out.println("성인 요금이 적용됩니다.");
        }else{
            System.out.println("성인 요금 대상이 아닙니다.");
        }
        //사용한 자원 반납하기
        sc.close();
    }
}
