package dev_java.quiz1213;

public class Quiz4 {
	int cnt;// 0->1->2

	int account(int start, int end) {// start=3, end=13
		for (int i = start; i <= end; i++) {
			// for(int i=start;i<=end;i=i+3){//3 6
			if (i % 3 == 0) {
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Quiz4 q4 = new Quiz4();
		q4.account(3, 13);
		System.out.println(q4.cnt);
	}
}
