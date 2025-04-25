package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import dao.SubjectDao;
import tool.Action;
public class SubjectListAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        // ここでセッションからschoolを取得！
        School school = (School) session.getAttribute("school");

        // ✅ デバッグ出力をここに書く！
        System.out.println("【DEBUG】school: " + school);
        System.out.println("【DEBUG】school.getCd(): " + (school != null ? school.getCd() : "null"));

        // 以下はそのままでOK
        SubjectDao dao = new SubjectDao();
        List<Subject> subjects = dao.filter(school);

        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("subject_list.jsp").forward(request, response);
    }
}
