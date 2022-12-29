package dev_java.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dev_java.util.DBConnectionMgr;
import dev_java.week4.DeptVO;

public class DeptList {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	public List<DeptVO> getDeptList(){
		con = dbMgr.getConnection();
		String sql = "SELECT deptno, dname, loc FROM dept";
		List<DeptVO> deptList = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 오라클 서버에게 처리를 요청함.
			DeptVO dVO = null;
			while (rs.next()) {
				dVO = DeptVO.builder().deptno(rs.getInt("deptno"))
				.dname(rs.getString("dname")).loc(rs.getString("loc")).build();
				deptList.add(dVO);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return deptList;
	}

	public static void main(String[] args) {
		DeptList deptList = new DeptList();
		List<DeptVO> list = null;
		list = deptList.getDeptList();
		for (int i = 0; i < list.size(); i++) {
			DeptVO rdVO = list.get(i);
			System.out.println(rdVO.getDeptno() + ", " + rdVO.getDname() + ", " + rdVO.getLoc());
		}		
	}
}
