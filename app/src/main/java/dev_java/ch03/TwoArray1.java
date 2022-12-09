package dev_java.ch03;
//2차 배열 -> List<Map<>> 제네릭 -> 웹개발, 앱개발(하이브리앱) - JSON
public class TwoArray1 {
	void toWhile(int[][] arr) {
		System.out.println("==============[[ while 문 으로 ]]==============");
		int i = 0;
		while (i < arr.length) {
			int j = 0;
			while (j < arr[i].length) {
				System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
				j++;
			} // end of inner while
			i++;
		} // end of outter while
	}

	public static void main(String[] args) {
		int arr[][] = new int[2][3];
		TwoArray1 ta1 = new TwoArray1();
		ta1.toWhile(arr);
		System.out.println("==============[[ for문 으로 ]]==============");
		for (int i = 0; i < arr.length; i++) {// 로우
			for (int j = 0; j < arr[i].length; j++) {// 컬럼
				System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
			} // end of inner
		} //// end of outter
	}
}
