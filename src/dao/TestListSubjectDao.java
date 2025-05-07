package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;
import bean.TestListSubject;

public class TestListSubjectDao extends Dao {
	// 入学年度と学校コードのみから生徒の成績情報を取得するためのsql
	private String baseSql = "SELECT student_no, subject_cd, test.school_cd, test.no, point, test.class_num, name, ent_year, is_attend "
            + "FROM test JOIN student "
            + "ON test.student_no = student.no "
            + "WHERE ent_year = ? AND test.school_cd = ? AND test.class_num = ? AND subject_cd = ?";


	private List<TestListSubject> postFilter(ResultSet rs) throws Exception{
		List<TestListSubject> list = new ArrayList<>();

		while(rs.next()){
			TestListSubject testListSubject= new TestListSubject();
			testListSubject.setEntYear(rs.getInt("ent_year"));
			testListSubject.setStudentNo(rs.getString("student_no"));
			testListSubject.setStudentName(rs.getString("name"));
			testListSubject.setClassNum(rs.getString("class_num"));
			testListSubject.setPoint(rs.getInt("no"), rs.getInt("point"));
			list.add(testListSubject);
		}

		return list;
	}

	public List<TestListSubject> filter(int entYear, String classNum, Subject subject, School school) throws Exception{
		List<TestListSubject> list = new ArrayList<>();

		Connection con = getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try{
			st = con.prepareStatement(baseSql);
			st.setInt(1, entYear);
			st.setString(2, school.getCd());
			st.setString(3, classNum);
			st.setString(4, subject.getCd());

			   System.out.println("★★ SQL実行：entYear=" + entYear + ", classNum=" + classNum + ", subjectCd=" + subject.getCd() + ", school=" + school.getCd());

	            rs = st.executeQuery();
	            list = this.postFilter(rs);
		}catch(Exception e){
			throw e;
		}finally{
	        if (st != null) st.close();
	        if (con != null) con.close();
	    }

		return list;

	}
}
