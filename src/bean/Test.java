package bean;

import java.io.Serializable;

/**
 * 単一のテスト結果（学生、教科、点数など）を表すクラス
 */
public class Test implements Serializable {

    /**
     * 学生情報: student
     */
    private Student student;

    /**
     * クラス名: classNum
     */
    private String classNum;

    /**
     * 科目情報: subject
     */
    private Subject subject;

    /**
     * 学校情報: school
     */
    private School school;

    /**
     * テスト番号: no
     */
    private int no;

    /**
     * 点数: point
     */
    private int point;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
