package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class ClassDeleteExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        School school = (School) session.getAttribute("school");

        String cd = request.getParameter("cd");

        Subject subject = new Subject();
        subject.setCd(cd);
        subject.setSchool(school);

        SubjectDao dao = new SubjectDao();
        boolean result = dao.delete(subject);

        if (result) {
            request.getRequestDispatcher("class_delete_done.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "削除に失敗しました");
            request.getRequestDispatcher("class_delete.jsp").forward(request, response);
        }
    }
}
