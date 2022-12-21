package dev_java.week4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

public class VectorCRUD2 {
	static Vector<String[]> vdept = new Vector<>();
	static Vector<DeptVO> vdept2 = new Vector<>();

	public void getDeptList() {
		for (int i = 0; i < vdept.size(); i++) {
			String[] oneRow = vdept.get(i);
			for (int j = 0; j < oneRow.length; j++) {
				System.out.print(oneRow[j] + ", ");
			} // end of inner
			System.out.println();
		} //// end of outter
	}

	public int deptInsert(String[] userDept) {// 지변 - 메소드영역안에서..
		System.out.println("부서 정보 입력 호출");
		int result = 0;// 1이면 성공, 0이면 실패
		boolean isOk = vdept.add(userDept);
		if (isOk)
			result = 1;
		return result;
	}
	/*********************************************************************
	 * 벡터에 부서정보 수정하기 - 있는 거를 변경함
	 * @param deptno 수정하고자 하는 부서번호
	 * @param user_dname 수정하고자 하는 부서명
	 * @param user_loc 수정하고자 하는 지역
	 * @return 1이면 성공 0이면 수정실패
	 ********************************************************************/
	public int deptUpdate(int deptno, String user_dname, String user_loc) {
		System.out.println("부서 정보 수정 호출 : "+user_dname+", "+user_loc);
		String[] oneRow = null;
		String[] comRow = null;
		for(int i=0;i<vdept.size();i++){
			comRow = vdept.get(i);
			if(deptno == Integer.parseInt(comRow[0])){
				//깊은 복사 - 각자 바뀐다
				oneRow = comRow;//얕은 복사-하나를 바꾸면 나도 바뀐다
			}
		}
		int result = 0;// 1이면 성공, 0이면 실패
		here:
		for(int i=0;i<vdept.size();i++){
			String row[] = vdept.get(i);//i는 로우 인덱스이다
			//if() 여기는 벡터에서 꺼낸 배열을 갖는다.
			for(int j=0;j<row.length;j++){//String[]돌림
				//if(){여기는 화면에서 가져온 배열과 벡터에서 꺼낸 배열을 비교한다
				//if(oneRow[0].equals(row[0])){// 10
				int deptno2 = 0;
				deptno2 = Integer.parseInt(row[0]);
				System.out.println(deptno+", "+deptno2);
				if(deptno==deptno2){// 10
					String[] updRow = {oneRow[0], user_dname, user_loc};
					//수정이라 말하고 입력으로 처리함 - 한 셀씩 수정하는것
					vdept.remove(i);//i번째 자리를 삭제하고
					//Vector를 사용하면 배열의 모든 단점을 보완함 - 고정, 타입단점
					//Vector<Object>
					vdept.add(i, updRow);//삭제된 자리에 추가함 - 배열의 장애 - int i[] = new int[3];
					//break문만 사용시 이 중 for문에서 내부 for문만을 탈출하게 되는데 
					//여기서는 외부 for문을 빠져나가야 하므로 라벨문을 붙여서 처리함
					break here;
				}else{
					System.out.println("선택한 부서번호와 벡터에서 가져온 부서번호가 다르다");
				}
			}//end of String[] - inner for
		}//end of Vector - 바깥쪽 for문에 라벨문을 사용할것.
		getDeptList();
		return result;
	}

	public int deptDelete(int deptno) {
		System.out.println("부서 정보 삭제 호출");
		int result = 0;// 1이면 성공, 0이면 실패
		for (int i = 0; i < vdept.size(); i++) {
			String oneRow[] = vdept.get(i);
			int deptno2 = 0;
			if (oneRow[0] != null) {// 널 체크를 하였다 - 이것 까지도 프레임워크에서 떠안으려 하고 있다. 이미 떠안았다.
				deptno2 = Integer.parseInt(oneRow[0]);
			}
			System.out.println("입력받은 값과 벡터에서 가져온 값 비교 하기 => " + deptno + ", " + deptno2);
			if (deptno == deptno2) {
				String[] deleteRow = vdept.remove(i);
				System.out.println("삭제된 배열은 " + Arrays.toString(deleteRow));
				if (deleteRow != null) {
					System.out.println("삭제 처리되었습니다.");
					result = 1;
				}
			}
		} // end of for
		return result;
	}//// end of deptDelete

	// 벡터에 부서정보 상세보기 - 있는 거를 하나 꺼내 봄
	public String[] deptDetail(int index) {// or int deptno
		String[] oneRow = new String[3];
		for (int i = 0; i < vdept.size(); i++) {
			if (1 == 1) {

			}
		}
		return oneRow;
	}

	public static void main(String[] args) {
		VectorCRUD2 vCrud = new VectorCRUD2();
		// 입력테스트
		int deptno = 10;
		String dname = "개발부";
		String loc = "인천";
		String[] oneRow = { "10", "개발부", "인천" };// 제네릭 타입으로 쓸거야
		int result1 = vCrud.deptInsert(oneRow);// 답
		String[] oneRow2 = { "20", "총무부", "서울" };// 제네릭 타입으로 쓸거야
		result1 = vCrud.deptInsert(oneRow2);
		if (result1 == 1) {
			JOptionPane.showMessageDialog(null, "등록이 되었습니다.");
			vCrud.getDeptList();
			// return;//조건문안에 return문 해당 메소드 블록을 빠져나간다.
		}
		Scanner s = new Scanner(System.in);
		System.out.print("수정할 부서번호,부서명, 지역를 입력하세요.(구분은|연산자로 함)");
		String user = s.nextLine();//10|인사부|포항
		int user_deptno = 0;
		String user_dname = null;
		String user_loc = null;
		StringTokenizer st = new StringTokenizer(user, "|");
		user_deptno = Integer.parseInt(st.nextToken());//사용자가 입력한 부서번호
		user_dname = st.nextToken();//사용자가 입력한 부서명
		user_loc = st.nextToken();//사용자가 입력한 지역
		s.close();
		// 수정 테스트
		int result2 = vCrud.deptUpdate(user_deptno, user_dname, user_loc);
		// 상세보기 테스트
		String[] result4 = vCrud.deptDetail(deptno);

	}// end of main
}
