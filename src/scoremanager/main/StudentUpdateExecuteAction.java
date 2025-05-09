package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateExecuteAction extends Action {
  public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    req.setCharacterEncoding("UTF-8");

    // 入力値取得
    String no = req.getParameter("no");
    String name = req.getParameter("name");
    int entYear = Integer.parseInt(req.getParameter("entYear"));
    String classNum = req.getParameter("classNum");
    boolean attend = req.getParameter("attend") != null;

    // セッションから先生を取得して、所属学校を取得
    Teacher teacher = (Teacher) req.getSession().getAttribute("user");
    School school = teacher.getSchool();

    // 学生情報をセット
    Student student = new Student();
    student.setNo(no);
    student.setName(name);
    student.setEntYear(entYear);
    student.setClassNum(classNum);
    student.setAttend(attend);
    student.setSchool(school);

    // 更新
    StudentDao dao = new StudentDao();
    dao.save(student);

    // 完了画面へ
    req.getRequestDispatcher("student_update_done.jsp").forward(req, res);
  }
}
