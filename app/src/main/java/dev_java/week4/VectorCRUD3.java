package dev_java.week4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

public class VectorCRUD3 {
	static Vector<DeptVO> vdept = new Vector<>();

	public void getDeptList() {
		for (int i = 0; i < vdept.size(); i++) {
			DeptVO dVO = vdept.get(i);
			System.out.println(dVO.getDeptno() + ", " + dVO.getDname() + ", " + dVO.getLoc());
		} //// end of outter
	}

	public int deptInsert(DeptVO pdVO) {// 지변 - 메소드영역안에서..
		System.out.println("부서 정보 입력 호출");
		int result = 0;// 1이면 성공, 0이면 실패
		boolean isOk = vdept.add(pdVO);
		if (isOk)
			result = 1;
		return result;
	}

	/*********************************************************************
	 * 벡터에 부서정보 수정하기 - 있는 거를 변경함
	 * 
	 * @param deptno     수정하고자 하는 부서번호
	 * @param user_dname 수정하고자 하는 부서명
	 * @param user_loc   수정하고자 하는 지역
	 * @return 1이면 성공 0이면 수정실패
	 ********************************************************************/
	public int deptUpdate(DeptVO pdVO) {
		int result = 0;
		// insert here

		return result;
	}

	public int deptDelete(int deptno) {
		System.out.println("부서 정보 삭제 호출");
		int result = 0;
		return result;
	}//// end of deptDelete

	// 벡터에 부서정보 상세보기 - 있는 거를 하나 꺼내 봄
	public DeptVO deptDetail(int deptno) {// or int deptno
		DeptVO rdVO = null;
		// insert here

		return rdVO;
	}

	public static void main(String[] args) {
		VectorCRUD3 vCrud = new VectorCRUD3();
		// 입력테스트
		DeptVO dvo1 = DeptVO.builder().deptno(10).dname("개발부").loc("인천").build();
		System.out.println(dvo1.toString());
		int result1 = vCrud.deptInsert(dvo1);// 답
		dvo1 = null;// 기존에 참조하는 객체와 연결을 끊는다
		dvo1 = DeptVO.builder().dname("총무부").deptno(20).loc("서울").build();
		System.out.println(dvo1.toString());
		result1 = vCrud.deptInsert(dvo1);
		if (result1 == 1) {
			JOptionPane.showMessageDialog(null, "등록이 되었습니다.");
			vCrud.getDeptList();
			return;//조건문안에 return문 해당 메소드 블록을 빠져나간다.
		}
		Scanner s = new Scanner(System.in);
		System.out.print("수정할 부서번호,부서명, 지역를 입력하세요.(구분은|연산자로 함)");
		String user = s.nextLine();// 10|인사부|포항
		int user_deptno = 0;
		String user_dname = null;
		String user_loc = null;
		StringTokenizer st = new StringTokenizer(user, "|");
		user_deptno = Integer.parseInt(st.nextToken());// 사용자가 입력한 부서번호
		user_dname = st.nextToken();// 사용자가 입력한 부서명
		user_loc = st.nextToken();// 사용자가 입력한 지역
		s.close();
	}// end of main
}
