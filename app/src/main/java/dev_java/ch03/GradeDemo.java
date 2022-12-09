package dev_java.ch03;

public class GradeDemo {
	String[] subject = { "JAVA", "ORACLE", "SPRING" };
	String[][] data = {
			{ "이순신", "80", "75", "70" }, { "강감찬", "90", "85", "95" }, { "김춘추", "65", "60", "60" }
	};

	void namePrint() {
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i][0]);
		}
	}

	// 자바 점수의 합은?
	void javaTot() {
		int javaHap = 0;
		for (int i = 0; i < data.length; i++) {
			javaHap += Integer.parseInt(data[i][1]);
		}
		System.out.println("자바 총점은 ? " + javaHap);
	}

	void allTot() {
		int javaHap = 0;
		for (int i = 0; i < data.length; i++) {
			javaHap += Integer.parseInt(data[i][1]);
		}
		System.out.println("자바 총점은 ? " + javaHap);
		int oracleHap = 0;
		for (int i = 0; i < data.length; i++) {
			oracleHap += Integer.parseInt(data[i][2]);
		}
		System.out.println("오라클 총점은 ? " + oracleHap);
		int springHap = 0;
		for (int i = 0; i < data.length; i++) {
			springHap += Integer.parseInt(data[i][2]);
		}
		System.out.println("스프링 총점은 ? " + springHap);
	}

	public static void main(String[] args) {
		GradeDemo gd = new GradeDemo();
		// gd.namePrint();
		// gd.javaTot();
		gd.allTot();
	}
}
