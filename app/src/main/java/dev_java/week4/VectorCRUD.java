package dev_java.week4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
//List - 순서, 느리다, 정렬(2차가공-속도-3초 조회), 추가하면 맨 뒤에 채운다. 
//index가 다르면 중복값 저장가능
import javax.swing.JOptionPane;

public class VectorCRUD {
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

	// 벡터에 부서정보 추가하기- 없는 거를 새로 추가함
	// pass by value로 호출하는 경우 주소번지를 받아옴. - 원본을 받는것 main.ival, sub.ival
	public int deptInsert(String[] userDept) {// 지변 - 메소드영역안에서..
		System.out.println("부서 정보 입력 호출");
		int result = 0;// 1이면 성공, 0이면 실패
		boolean isOk = vdept.add(userDept);
		if (isOk)
			result = 1;
		return result;
	}

	// 벡터에 부서정보 수정하기 - 있는 거를 변경함
	public int deptUpdate() {
		System.out.println("부서 정보 수정 호출");
		int result = 0;// 1이면 성공, 0이면 실패

		return result;

	}

	// 벡터에 부서정보 삭제하기 - 있는 거를 삭제함
	// 벡터에 있는 부서 정보 중에서 어떤 로우를 삭제할 건지 부서번호를 받아와야 함
	// 이것은 사용자로 부터 받아와야 하는 값임
	// - 그런데 int형 그런데 String[]에서 부서번호는 String타입
	// 그러니까 형전환 필요함. - 그런데 null이 오면 NumberFormatException발생할 가능성 있음
	// 방어코드 작성 필요함. - null에 대한 이슈는 현재 프로그래밍에 있어 심각한 장애로 인식 - 중요한 문제임
	public int deptDelete(int deptno) {
		System.out.println("부서 정보 삭제 호출");
		int result = 0;// 1이면 성공, 0이면 실패
		for (int i = 0; i < vdept.size(); i++) {
			String oneRow[] = vdept.get(i);
			int deptno2 = 0;
			// 예외 발생에 대한 우려 방어코드 작성 함.
			if (oneRow[0] != null) {// 널 체크를 하였다 - 이것 까지도 프레임워크에서 떠안으려 하고 있다. 이미 떠안았다.
				deptno2 = Integer.parseInt(oneRow[0]);
			}
			// 사용자가 입력한 부서번호 와 벡터에서 가져온 부서번호 비교하기
			System.out.println("입력받은 값과 벡터에서 가져온 값 비교 하기 => " + deptno + ", " + deptno2);
			// 사용자가 선택한 부서번호와 벡터에 있는 부서번호를 비교하여 같은 것 찾기함
			if (deptno == deptno2) {
				// 삭제할 벡터의 로우값이 필요함 - 이것은 벡터의 size를 통해 찾아냄
				// 여기서는 변수 i가 인덱스 값에 해당함
				// remove메소드의 파라미터가 int인 경우에 대해서만 삭제된 벡터의 제네릭
				// 반환해줌. 그것을 받아서 처리 여부 확인 가능함.
				String[] deleteRow = vdept.remove(i);
				System.out.println("삭제된 배열은 "+Arrays.toString(deleteRow));
				// boolean isOk = vdept.remove(oneRow);// 메소드 오버로딩이라고 함
				// 삭제 한 객체가 존재하니? 네:삭제 되었음 아니:삭제 안됨.
				if (deleteRow != null) {
					System.out.println("삭제 처리되었습니다.");
					// JOptionPane.showMessageDialog(null, "삭제 처리 되었습니다.");
					// 삭제 처리가 성공한 경우 이므로 반환값 1 리턴해줌. 끝
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
		VectorCRUD vCrud = new VectorCRUD();
		// 입력테스트
		int deptno = 10;
		String dname = "개발부";
		String loc = "인천";
		String[] oneRow = { "10", "개발부", "인천" };// 제네릭 타입으로 쓸거야
		// int result1 = vCrud.deptInsert(deptno, dname, loc);//컬럼수50내외
		// 둘 중에 무엇으로 할까? - 메소드 오버로딩
		int result1 = vCrud.deptInsert(oneRow);// 답
		String[] oneRow2 = { "20", "총무부", "서울" };// 제네릭 타입으로 쓸거야
		result1 = vCrud.deptInsert(oneRow2);
		if (result1 == 1) {
			JOptionPane.showMessageDialog(null, "등록이 되었습니다.");
			vCrud.getDeptList();
			// return;//조건문안에 return문 해당 메소드 블록을 빠져나간다.
		}
		// 삭제할 부서번호를 입력 받기 위한 코드 추가함
		Scanner s = new Scanner(System.in);
		// 사용자(업무담당자)에게 요청할 정보 출력하기
		System.out.print("삭제할 부서번호를 입력하세요.");
		// 입력 받는 값이 숫자 타입이므로 nextInt로 받음 - nextLine을 사용하면 String으로 받아옴
		int user = s.nextInt();
		// 삭제테스트
		int result3 = vCrud.deptDelete(user);
		if (result3 == 1) {
			JOptionPane.showMessageDialog(null, "삭제가 되었습니다.");
			vCrud.getDeptList();
			// return;
		}
		s.close();
		// 수정 테스트
		// int result2 = vCrud.deptUpdate(deptno);
		// 상세보기 테스트
		String[] result4 = vCrud.deptDetail(deptno);

	}// end of main
}
