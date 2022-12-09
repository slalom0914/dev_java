package dev_java.ch03;

//2차 배열 -> List<Map<>> 제네릭 -> 웹개발, 앱개발(하이브리앱) - JSON
public class TwoArray3 {
	//다차원 배열도 연습해 보세요.
	public static void main(String[] args) {
		int arr[][] = new int[3][];
		// arr[0] = new int[3];
		arr[0] = new int[] { 1, 2, 3 };
		// arr[1] = new int[3];
		arr[1] = new int[] { 4, 5, 6, 7 };
		// arr[2] = new int[3];
		arr[2] = new int[] { 8, 9, 10, 11, 12 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
			}//end of inner for
		}//end of outter for
	}
}
