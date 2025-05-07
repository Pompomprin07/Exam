package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import bean.Teacher;
import bean.TestListStudent;
import bean.TestListSubject;
import dao.ClassNumDao;
import dao.SubjectDao;
import dao.TestListStudentDao;
import dao.TestListSubjectDao;
import tool.Action;

public class TestListSubjectExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    	TestListStudentDao testDao = new TestListStudentDao();
    	TestListSubjectDao testListSubjectDao = new TestListSubjectDao(); // ← 修正済み
    	SubjectDao subjectDao = new SubjectDao();
    	ClassNumDao cDao = new ClassNumDao();
    	SubjectDao sDao = new SubjectDao();
        School school = ((Teacher) req.getSession().getAttribute("user")).getSchool();
        Teacher teacher = (Teacher) req.getSession().getAttribute("user");

        // リクエストパラメータ取得
        String f1 = req.getParameter("f1");
        String f2 = req.getParameter("f2");
        String f3 = req.getParameter("f3");

        // 入力バリデーション
        if (f1 == null || f1.equals("0") || f2 == null || f2.equals("0") ||
            f3 == null || f3.equals("0")) {
            req.setAttribute("error", "すべての項目を入力してください。");
            req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
            return;
        }

        int entYear = Integer.parseInt(f1);
        String classNum = f2;

        Subject subject = subjectDao.get(f3, school);

        if (subject != null) {
            req.setAttribute("subjectName", subject.getName());
        } else {
            req.setAttribute("subjectName", "不明な科目");
        }


        // ログ
        System.out.println("subjectCd: " + subject.getCd());

        List<TestListStudent> resultList = testDao.filter(entYear, classNum, subject, school);
        List<TestListSubject> resultList2 = testListSubjectDao.filter(entYear, classNum, subject, school);

        // 学生名をマージ
        if (resultList2 != null && resultList != null) {
            for (TestListSubject subjectData : resultList2) {
                for (TestListStudent studentData : resultList) {
                    if (studentData.getStudent() != null &&
                        subjectData.getStudentNo().equals(studentData.getStudent().getNo())) {
                        subjectData.setStudentName(studentData.getStudent().getName());
                        break;
                    }
                }
            }
        }


        // メッセージ処理
        if (resultList == null || resultList.isEmpty()) {
            req.setAttribute("message", "該当する成績情報が見つかりませんでした。");
        } else {
            req.setAttribute("testList", resultList);
            req.setAttribute("testListSubject", resultList2);
        }


        List<Integer> entYearSet = new ArrayList<>();


		LocalDate todeysDate = LocalDate.now();
        int year = todeysDate.getYear();

		// 10年前から1年後まで年をリストに追加
		for (int i = year - 10; i < year + 1; i++){
			entYearSet.add(i);
		}

        // ▼ クラス番号のリスト取得（学校ごとに）
        List<String> classNumList = cDao.filter(teacher.getSchool());
        System.out.println(classNumList + "class");
        // ▼ 科目一覧取得（SbjectDao に findAll() がある前提）
        List<bean.Subject> subjectList = sDao.filter(teacher.getSchool());


        // ▼ JSPに渡す
        req.setAttribute("ent_year_set", entYearSet);
        req.setAttribute("class_num_set", classNumList);
        req.setAttribute("subjectList", subjectList);


        // 表示用
        req.setAttribute("subjectName", subject.getName());
        req.setAttribute("f1", f1);
        req.setAttribute("f2", f2);
        req.setAttribute("f3", f3);


        // JSPへフォワード
        req.getRequestDispatcher("test_list_subject.jsp").forward(req, res);
    }

    // ★ 補助メソッド（subjectListが使えない場合）
    private String getSubjectName(String cd, List<Subject> subjectList) {
        for (Subject s : subjectList) {
            if (s.getCd().equals(cd)) return s.getName();
        }
        return "";
    }
}
