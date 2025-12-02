package ch03;

public class ExString06 {
    public static void main(String[] args) {
        String sql = "SELECT emp.empno, emp.ename, dept.dname";
        sql += " FROM emp, dept";
        sql += " WHERE emp.deptno = dept.deptno";
        sql += " AND dept.deptno IN(10,30,40)";
        System.out.println(sql);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT emp.empno, emp.ename, dept.dname");
        sb.append(" FROM emp, dept");
        sb.append(" WHERE emp.deptno = dept.deptno");
        sb.append(" AND dept.deptno IN(10,30,40)");
        System.out.println(sql.toString());
    }
}
