package dev_java.quiz1215;

public class Quiz2 {
	int users[] = null;
	int mhap = 0, phap = 0;

	void setArray() {
		users = new int[10];
		for (int i = 0; i < users.length; i++) {
			users[i] = (int) (Math.random() * 21) - 10;
		}
	}

	void setArray(int size) {
		users = new int[size];
		for (int i = 0; i < size; i++) {
			// 0.0~1.0 -실수형*21-> 0.0~20.0
			users[i] = (int) (Math.random() * 21) - 10;
		}
	}

	void total() {
		for (int i = 0; i < users.length; i++) {
			if (users[i] > 0) {
				phap += users[i];
			} else {
				mhap += users[i];
			}
		}
	}

	// 난수 수집 체크
	void nansuPrint() {
		// insert here
		for (int i = 0; i < users.length; i++) {
			System.out.println(users[i]);
		}
	}

	public static void main(String[] args) {
		Quiz2 q2 = new Quiz2();
		q2.setArray();
		//q2.setArray(100);
		q2.nansuPrint();
		q2.total();
		System.out.println("양수의 합은 " + q2.phap);
		System.out.println("음수의 합은 " + q2.mhap);
	}
}

/*
 * -10에서 10사이의 정수 10개를 랜덤하게 채번하여 음수와 양수의 합계를 구하는 프로그램을 작성하시오.
 * 변수는 몇개 필요할까요? 2개 mhap=0, phap=0
 * 
 * 전변으로 해야하는 변수는 무엇일까요?
 * 배열 int nansus[] = new int[10];
 * 
 * 메소드 선언하기
 * void setArray()
 * void setArray(int size)
 * 
 * void total(){
 * 
 * }
 * 
 * 난수 수집 체크
 * void nansuPrint(){
 * 
 * }
 * 
 * 출력)
 * 배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0
 * 음수합 : -24
 * 양수합 : 17
 * 
 */