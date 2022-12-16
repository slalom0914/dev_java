package dev_java.tables;

import java.util.Scanner;
import java.util.Vector;

public class Vector61 {
	Vector<String[]> vdepts = new Vector<>();
	String[][] depts = {
			{ "10", "개발부", "서울", "02-555-7788" },
			{ "20", "인사부", "인천", "032-333-9988" },
			{ "30", "총무부", "부산", "051-666-2233" }
	};

	void initVector() {
		for (int i = 0; i < depts.length; i++) {
			vdepts.add(depts[i]);// 벡터에 담기는 것은 1차배열임 -컬럼의수는 바뀔 수 있음 - 4
		}
	}

	void initVectorPrint() {
		for (int i = 0; i < vdepts.size(); i++) {
			String[] oneRow = vdepts.get(i);
			System.out.println(oneRow.toString());
			for (int j = 0; j < oneRow.length; j++) {
				System.out.print(oneRow[j] + " ");
			}
			System.out.print("\n");
		}
	}// end of initVectorPrint

	public static void main(String[] args) {
		Vector61 v61 = new Vector61();
		// initVector 메소드를 경유하지 않았으므로 size는 0이다.
		v61.initVector();
		// vdepts.get(0) -> {"10","개발부","서울","02-555-7788"}
		// vdepts.get(1) -> {"10","개발부","서울","02-555-7788"}
		// vdepts.get(2) -> {"10","개발부","서울","02-555-7788"}
		System.out.println(v61.vdepts.size());// 0->3
		v61.initVectorPrint();
		System.out.print("삭제하고자 하는 부서번호를 입력하세요");
		Scanner s = new Scanner(System.in);
		int deptno = s.nextInt();
		for (int i = 0; i < v61.vdepts.size(); i++) {
			String[] oneRow = v61.vdepts.get(i);
			if (deptno == Integer.parseInt(oneRow[0])) {
				v61.vdepts.remove(i);
			}
		}
		v61.initVectorPrint();
		// 삭제 한 뒤 남은 정보 출력해 보기
		//System.out.println(v61.vdepts);
		s.close();
	}
}
