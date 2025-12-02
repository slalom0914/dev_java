package ch04;

import java.util.Scanner;

public class Switch02 {
    public static void main(String[] args) {
        String bread = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 빵이름을 입력하세요.");
        bread = sc.nextLine();
        switch (bread){
            case "소보로":
                System.out.println("당신은 소보로를 선택하였습니다.");
                break;
            case "도우넛":
                System.out.println("당신은 도우넛를 선택하였습니다.");
                break;
            default:
                System.out.println("원하는 빵이 없                                습니다.");
                break;
        }//end of switch
    }//end of main
}
