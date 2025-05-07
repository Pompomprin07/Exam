package bean;

import java.io.Serializable;

/**
 * 科目ごとの点数リスト（学生視点）を保持するクラス
 */
public class TestListStudent implements Serializable {

    /**
     * 科目名: subjectName
     */
    private String subjectName;

    /**
     * 科目コード: subjectCd
     */
    private String subjectCd;

    /**
     * テスト番号: num
     */
    private int num;

    /**
     * 得点: point
     */
    private int point;

    private Student student;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCd() {
        return subjectCd;
    }

    public void setSubjectCd(String subjectCd) {
        this.subjectCd = subjectCd;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
