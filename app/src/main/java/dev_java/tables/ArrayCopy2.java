package dev_java.tables;

public class ArrayCopy2 {

	public static void main(String[] args) {
		String[][] depts = {
			{ "10", "개발부", "서울" },
			{ "20", "인사부", "인천" },
			{ "30", "총무부", "부산" }
		};
		String[][] copy = new String[depts.length][depts[0].length];
		for(int i=0;i<copy.length;i++){
			System.arraycopy(depts[i], 0, copy[i],0, depts[i].length);
		}
		depts[0][0] = "40";
		for(int i=0;i<depts.length;i++){
			for(int j=0;j<depts[i].length;j++){
				System.out.println(depts[i][j]);
			}
		}
		for(int i=0;i<copy.length;i++){
			for(int j=0;j<copy[i].length;j++){
				System.out.println(copy[i][j]);
			}
		}
	}
}
