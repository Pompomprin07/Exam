package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import bean.Teacher;
import bean.TestListStudent;
import dao.ClassNumDao;
import dao.SubjectDao;
import dao.TestListStudentDao;
import tool.Action;

public class TestListStudentExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Object userObj = req.getSession().getAttribute("user");
        if (userObj == null || !(userObj instanceof Teacher)) {
            req.setAttribute("message", "ログイン情報が無効です。再度ログインしてください。");
            req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
            return;
        }

        String studentNo = req.getParameter("subjectf1");  // 学生番号の入力欄名が subjectf1 のままなら
        String studentName = null;

        Teacher teacher = (Teacher) req.getSession().getAttribute("user");
        School school = teacher.getSchool();




        if (studentNo == null || studentNo.isEmpty()) {
            req.setAttribute("message", "学生番号を入力してください。");
            req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
            return;
        }

        TestListStudentDao testDao = new TestListStudentDao();
        List<TestListStudent> resultList;

        try {
            resultList = testDao.StudentNo(studentNo);

            if (!resultList.isEmpty() && resultList.get(0).getStudent() != null) {
                studentName = resultList.get(0).getStudent().getName();
            }

            if (resultList.isEmpty()) {
                req.setAttribute("message", "該当する成績情報が見つかりませんでした。");
            } else {
                req.setAttribute("testList", resultList);
            }

        } catch (Exception e) {
            req.setAttribute("message", "検索中にエラーが発生しました。");
            req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
            return;
        }


	     // 年度リスト
        List<Integer> entYearSet = new ArrayList<>();
        int year = java.time.LocalDate.now().getYear();
        for (int i = year - 10; i <= year; i++) {
            entYearSet.add(i);
        }

        // クラス番号リスト
        ClassNumDao classDao = new ClassNumDao();
        List<String> classNumList = classDao.filter(school);

        // 科目リスト
        SubjectDao subjectDao = new SubjectDao();
        List<Subject> subjectList = subjectDao.filter(school);

        // JSPに渡す
        req.setAttribute("ent_year_set", entYearSet);
        req.setAttribute("class_num_set", classNumList);
        req.setAttribute("subjectList", subjectList);

        // 検索結果関連
        req.setAttribute("subjectf1", studentNo);
        req.setAttribute("studentName", studentName);

        System.out.println("studentName: " + studentName);
        // JSPへフォワード
        req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
    }
}
