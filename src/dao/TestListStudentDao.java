package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.TestListStudent;

public class TestListStudentDao extends Dao {

    // 共通SQL（filterメソッド用）
    private String filterSql =
        "SELECT student.no AS student_no, student.name AS student_name, test.subject_cd, test.no, test.point " +
        "FROM test " +
        "JOIN student ON test.student_no = student.no " +
        "WHERE student.ent_year = ? AND student.class_num = ? AND test.subject_cd = ? AND test.school_cd = ? " +
        "ORDER BY test.subject_cd, test.no, student.no";

    // 学生番号で検索（修正済み）
    private String studentSql =
        "SELECT test.student_no, student.name AS student_name, test.subject_cd, test.school_cd, test.no, test.point, " +
        "subject.name AS subject_name " +
        "FROM test " +
        "JOIN subject ON test.subject_cd = subject.cd AND test.school_cd = subject.school_cd " +
        "JOIN student ON test.student_no = student.no " +
        "WHERE test.student_no = ? " +
        "ORDER BY test.subject_cd, test.no";

    // filterメソッド（Subject一覧画面用）
    public List<TestListStudent> filter(int entYear, String classNum, Subject subject, School school) throws Exception {
        List<TestListStudent> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = con.prepareStatement(filterSql);
            st.setInt(1, entYear);
            st.setString(2, classNum);
            st.setString(3, subject.getCd());
            st.setString(4, school.getCd());
            rs = st.executeQuery();

            while (rs.next()) {
                TestListStudent testListStudent = new TestListStudent();
                testListStudent.setSubjectCd(rs.getString("subject_cd"));
                testListStudent.setNum(rs.getInt("no"));
                testListStudent.setPoint(rs.getInt("point"));

                Student student = new Student();
                student.setNo(rs.getString("student_no"));
                student.setName(rs.getString("student_name"));
                testListStudent.setStudent(student);

                list.add(testListStudent);
            }

        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (st != null) try { st.close(); } catch (SQLException e) {}
            if (con != null) try { con.close(); } catch (SQLException e) {}
        }

        return list;
    }

    // 学生番号で検索（詳細表示用）修正済み
    public List<TestListStudent> StudentNo(String studentNo) throws Exception {
        List<TestListStudent> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = con.prepareStatement(studentSql);
            st.setString(1, studentNo);
            rs = st.executeQuery();

            while (rs.next()) {
                TestListStudent testListStudent = new TestListStudent();
                testListStudent.setSubjectCd(rs.getString("subject_cd"));
                testListStudent.setSubjectName(rs.getString("subject_name"));
                testListStudent.setNum(rs.getInt("no"));
                testListStudent.setPoint(rs.getInt("point"));

                Student student = new Student();
                student.setNo(rs.getString("student_no"));
                student.setName(rs.getString("student_name"));  // ← 修正ポイント
                testListStudent.setStudent(student);

                list.add(testListStudent);
            }

        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (st != null) try { st.close(); } catch (SQLException e) {}
            if (con != null) try { con.close(); } catch (SQLException e) {}
        }

        return list;
    }
}
