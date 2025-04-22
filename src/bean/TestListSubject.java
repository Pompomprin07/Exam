package bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TestListSubject implements Serializable {

    /**
     * 入学年度: entYear
     */
    private int entYear;

    /**
     * 学籍番号: studentNo
     */
    private String studentNo;

    /**
     * 学生名: studentName
     */
    private String studentName;

    /**
     * クラス: classNum
     */
    private String classNum;

    /**
     * 点数（科目番号→得点のマッピング）: points
     */
    private Map<Integer, Integer> points = new HashMap<>();

    public int getEntYear() {
        return entYear;
    }

    public void setEntYear(int entYear) {
        this.entYear = entYear;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public Map<Integer, Integer> getPoints() {
        return points;
    }

    public void setPoints(Map<Integer, Integer> points) {
        this.points = points;
    }

    public Integer getPoint(int key) {
        return points.get(key);
    }

    public void putPoint(int key, int value) {
        points.put(key, value);
    }
}
