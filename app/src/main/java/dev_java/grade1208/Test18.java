package dev_java.grade1208;

public class Test18 {
	public static void main(String[] args) {
		switch (1) {
			case 2:
				System.out.println("2입니다.");
				break;
			default:
				System.out.println("1이 아닙니다.");
				break;
		}// end switch
		String bread = "도우넛";
		switch (bread) {
			case "도우넛":
				System.out.println("손님 도우넛 나왔습니다.");
				//break;
			case "소보로빵":
				System.out.println("손님 소보로빵 나왔습니다.");
				//break;
			default:
				System.out.println("도우넛도 아니고 소보로빵도 아닌 경우 여기로...");
				break;
		}
	}
}
