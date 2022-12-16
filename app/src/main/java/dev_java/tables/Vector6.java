package dev_java.tables;

import java.util.Vector;

public class Vector6 {
	public static void main(String[] args) {
		String[][] depts = {
			{ "10", "개발부", "서울","02-555-7788" },
			{ "20", "인사부", "인천","032-333-9988" },
			{ "30", "총무부", "부산","051-666-2233" }
		};
		Vector<String[]> vdepts = new Vector<>();
		for(int i =0;i<depts.length;i++){
			vdepts.add(depts[i]);
		}
		for(int i =0;i<vdepts.size();i++){//로우가 3번 반복됨
			String[] oneRow = vdepts.get(i);
			for(int j=0;j<oneRow.length;j++){//컬럼 수만큼 반복됨
				System.out.print(oneRow[j]+" ");
			}//end of inner for
			System.out.println();
		}/////end of outter for
	}////////// end of main
}////////////  end of Vector6
