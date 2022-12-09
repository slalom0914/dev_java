package dev_java.ch03;

public class AvgDemo {
	String[] subject = { "JAVA", "ORACLE", "SPRING" };
	String[][] data = {
			{ "이순신", "80", "75", "70" }, { "강감찬", "90", "85", "95" }, { "김춘추", "65", "60", "60" }
	};
	int haps[] = new int[3];
	double avgs[] = new double[3];

	void allTot() {
		int javaHap = 0;
		for (int i = 0; i < data.length; i++) {
			javaHap += Integer.parseInt(data[i][1]);
		}
		haps[0] = javaHap;
		System.out.println("자바 총점은 ? " + javaHap);
		int oracleHap = 0;
		for (int i = 0; i < data.length; i++) {
			oracleHap += Integer.parseInt(data[i][2]);
		}
		haps[1] = oracleHap;
		System.out.println("오라클 총점은 ? " + oracleHap);
		int springHap = 0;
		for (int i = 0; i < data.length; i++) {
			springHap += Integer.parseInt(data[i][2]);
		}
		haps[2] = springHap;
		System.out.println("스프링 총점은 ? " + springHap);
	}
	void allAvg(){
		for(int i=0;i<haps.length;i++){
			avgs[i] = haps[i] / (double)3;
		}
	}
	public static void main(String[] args) {
		AvgDemo ad = new AvgDemo();
		ad.allTot();
		ad.allAvg();
		for(int i=0;i<ad.haps.length;i++){
			System.out.println("총점은 "+ad.haps[i] +", 평균은 "+ad.avgs[i]);
		}
	}
}
