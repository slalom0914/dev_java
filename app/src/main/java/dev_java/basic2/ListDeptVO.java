package dev_java.basic2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dev_java.tables.DeptVO;
import dev_java.util.DBConnectionMgr;

public class ListDeptVO {
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	Connection con = null;// 오라클 서버와 연결통로 확보
	PreparedStatement pstmt = null;// 자바에서 오라클 서버로 DML전달
	ResultSet rs = null;// 오라클 테이블에 제공되는 커서를 조작하는 함수제공

	public List<DeptVO> getEmpList() {
		List<DeptVO> list = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT                                              ");
		sql.append("				empno, ename, dname     ");
		sql.append("  FROM emp, dept                             ");
		sql.append("WHERE emp.deptno = dept.deptno ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			list = new ArrayList<>();// list.size()= 0이다.
			DeptVO dVO = null;
			while (rs.next()) {
				dVO = new DeptVO(0, null, rs.getString("dname"));// 디폴트 생성자 0 null, null
				/*
				 * System.out.println(rs.getInt("empno")
				 * + ", " + rs.getString("ename")
				 * + ", " + rs.getString("dname"));
				 */

				list.add(dVO);// 0부터 차례대로 들어감
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}//end of getEmpList

	public static void main(String[] args) {
		ListDeptVO listDeptVO = new ListDeptVO();
		List<DeptVO> list = null;
		list = listDeptVO.getEmpList();
		System.out.println("list : " + list);
		for (DeptVO rdVO : list) {
			// System.out.println(rdVO);//while문을 타지 않으면 null인 상태
			System.out.println(rdVO.getDeptno() + ", " + rdVO.getDname() + ", " + rdVO.getLoc());
		}
	}//end of main
}
