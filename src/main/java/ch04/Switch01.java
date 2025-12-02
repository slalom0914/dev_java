package ch04;

public class Switch01 {
    public static void main(String[] args) {
        String bread = "도우넛";
        switch (bread){
            case "소보로":
                System.out.println("당신은 소보로를 선택하였습니다.");
                break;
            case "도우넛":
                System.out.println("당신은 도우넛를 선택하였습니다.");
                break;
            default:
                System.out.println("원하는 빵이 없습니다.");
                break;
        }//end of switch
    }//end of main
}//end of Switch01
