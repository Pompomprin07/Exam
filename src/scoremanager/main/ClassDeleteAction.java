package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class ClassDeleteAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        School school = (School) session.getAttribute("school");

        String cd = request.getParameter("cd");

        SubjectDao dao = new SubjectDao();
        Subject subject = dao.get(cd, school);

        request.setAttribute("subject", subject);
        request.getRequestDispatcher("class_delete.jsp").forward(request, response);
    }
}
