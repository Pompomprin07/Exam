package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import tool.Action;

public class TestRegistAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        // パラメータ取得
        String entYearStr = req.getParameter("f1");
        String classNum = req.getParameter("f2");
        String subject = req.getParameter("f3");
        String countStr = req.getParameter("f4");

        Map<String, String> errors = new HashMap<>();

        // 入学年度リストの作成（10年前〜今年）
        int currentYear = LocalDate.now().getYear();
        List<Integer> entYearSet = new ArrayList<>();
        for (int i = currentYear - 10; i <= currentYear; i++) {
            entYearSet.add(i);
        }

        // クラス一覧取得
        ClassNumDao classNumDao = new ClassNumDao();
        List<String> classNumList = classNumDao.filter(teacher.getSchool());

        // 科目・回数（固定値で仮作成）
        List<String> subjectList = Arrays.asList("Java", "Python", "HTML");
        List<Integer> countList = Arrays.asList(1, 2, 3);

        // 入学年度を数値変換
        int entYear = 0;
        if (entYearStr != null && !entYearStr.equals("0") && !entYearStr.isEmpty()) {
            try {
                entYear = Integer.parseInt(entYearStr);
            } catch (NumberFormatException e) {
                errors.put("f1", "入学年度の形式が正しくありません。");
            }
        }

        // 学生取得
        StudentDao studentDao = new StudentDao();
        List<Student> students = new ArrayList<>();

        if (entYear != 0 && classNum != null && !classNum.equals("0")) {
            students = studentDao.filter(teacher.getSchool(), entYear, classNum, true);
        } else if (entYear != 0) {
            students = studentDao.filter(teacher.getSchool(), entYear, true);
        } else if (entYear == 0 && (classNum == null || classNum.equals("0"))) {
            students = studentDao.filter(teacher.getSchool(), true);
        } else {
            errors.put("f1", "クラスを指定する場合は入学年度も指定してください");
            students = studentDao.filter(teacher.getSchool(), true);
        }

        // JSPに渡すデータのセット
        req.setAttribute("f1", entYear);
        req.setAttribute("f2", classNum);
        req.setAttribute("f3", subject);
        req.setAttribute("f4", countStr);
        req.setAttribute("ent_year_set", entYearSet);
        req.setAttribute("class_num_set", classNumList);
        req.setAttribute("subject_set", subjectList);
        req.setAttribute("count_set", countList);
        req.setAttribute("students", students);
        req.setAttribute("errors", errors);

        // JSPへフォワード
        req.getRequestDispatcher("test_regist_list.jsp").forward(req, res);
    }
}
