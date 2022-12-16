package dev_java.tables;

import java.util.Vector;

public class DeptList {
	Vector<DeptVO> vdepts = new Vector<>();
	//부서등록
	int deptInsert(DeptVO pdVO){
		int result = -1;
		boolean isOk = vdepts.add(pdVO);
		result = isOk ? 1:0;
		return result;
	}
	//부서수정 - 부서명과 지역만 수정할 수  있다.
	int deptUpdate(DeptVO pdVO){
		int result = -1;
		return result;		
	}

	//부서삭제
	int deptDelete(int deptno){
		int result = -1;
		return result;		
	}
	//부서정보상세

	//부서 전체 조회
	void getDeptList(){
		DeptVO dvo = new DeptVO(10,"개발부","서울");
		vdepts.add(dvo);
		dvo = new DeptVO(20,"인사부","인천");
		vdepts.add(dvo);
		dvo = new DeptVO(30,"총무부","부산");
		vdepts.add(dvo);
	}
	public static void main(String[] args) {
		DeptList deptList = new DeptList();
		deptList.getDeptList();
		for(int i=0;i<deptList.vdepts.size();i++){
			DeptVO rdVO = deptList.vdepts.get(i);
			System.out.println(rdVO.getDeptno()+", "+rdVO.getDname()+", "+rdVO.getLoc());
		}
		DeptVO dvo = new DeptVO(40,"자재부","대전");
		int result = deptList.deptInsert(dvo);
		if(result ==1){
			System.out.println("등록 되었습니다.");
			for(int i=0;i<deptList.vdepts.size();i++){
				DeptVO rdVO = deptList.vdepts.get(i);
				System.out.println(rdVO.getDeptno()+", "+rdVO.getDname()+", "+rdVO.getLoc());
			}			
		}
	}
}
