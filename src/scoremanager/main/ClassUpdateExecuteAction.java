package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class ClassUpdateExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        School school = (School) session.getAttribute("school");

        String cd = request.getParameter("cd");
        String name = request.getParameter("name");

        Subject subject = new Subject();
        subject.setCd(cd);
        subject.setName(name);
        subject.setSchool(school);

        SubjectDao dao = new SubjectDao();
        boolean result = dao.save(subject); // saveで更新もできる！

        if (result) {
            request.getRequestDispatcher("class_update_done.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "更新に失敗しました");
            request.getRequestDispatcher("class_update.jsp").forward(request, response);
        }
    }
}
