package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import dao.StudentDao;
import tool.Action;

public class StudentCreateExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 入力データ取得
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String entYearStr = request.getParameter("entYear");
        String classNum = request.getParameter("classNum");

        // セッションから学校情報取得
        School school = (School) request.getSession().getAttribute("school");

        try {
            // 入力チェック（シンプル例）
            if (no == null || no.isEmpty() || name == null || name.isEmpty()) {
                throw new Exception("学生番号と氏名は必須です。");
            }

            int entYear = Integer.parseInt(entYearStr);

            // Studentオブジェクト生成
            Student student = new Student();
            student.setNo(no);
            student.setName(name);
            student.setEntYear(entYear);
            student.setClassNum(classNum);
            student.setAttend(true);
            student.setSchool(school);

            // 登録実行
            StudentDao dao = new StudentDao();
            boolean result = dao.save(student);

            if (result) {
                // 完了画面へ
                request.getRequestDispatcher("student_create_done.jsp").forward(request, response);
            } else {
                // 登録失敗 → 入力画面に戻す
                request.setAttribute("error", "登録に失敗しました。");
                request.getRequestDispatcher("student_create.jsp").forward(request, response);
            }

        } catch (Exception e) {
            // エラー時：エラーメッセージを設定して入力画面に戻す
            request.setAttribute("error", "エラー: " + e.getMessage());
            request.getRequestDispatcher("student_create.jsp").forward(request, response);
        }
    }
}
