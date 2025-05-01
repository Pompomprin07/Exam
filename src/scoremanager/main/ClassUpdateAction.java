package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class ClassUpdateAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        School school = (School) session.getAttribute("school");

        // パラメータから科目コード取得
        String cd = request.getParameter("cd");

        // 科目情報を取得
        SubjectDao dao = new SubjectDao();
        Subject subject = dao.get(cd, school);

        // JSPに渡す
        request.setAttribute("subject", subject);

        // 編集画面にフォワード
        request.getRequestDispatcher("class_update.jsp").forward(request, response);
    }
}
