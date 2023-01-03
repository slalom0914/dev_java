package dev_java.tables;

public class DeptVO {
	private int deptno;
	private String dname;
	private String loc;
	//디폴트 생성자는 필요없지만 파라미터가 있는 생성자가 하나라도 선언되면
	//제공하는 것을 원칙으로 한다
	public DeptVO() {
		//0, null, null
	}
	public DeptVO(int deptno, String dname, String loc) {
		this.deptno = deptno;//10, 20, 30
		this.dname = dname;//ACCOUNTING, SALES, RESEARCH, OPERATION
		this.loc = loc;//CHICAGO, DALLAS,...
	}

	public int getDeptno() {
		return this.deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return this.loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
