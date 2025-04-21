package scoremanager;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;

///// LoginActionで実証すること/////

import bean.Teacher;
import dao.TeacherDao;
import tool.Action;


public class LoginExecuteAction extends Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    HttpSession session = request.getSession();

	    String id = request.getParameter("id");
	    String password = request.getParameter("password");

	    TeacherDao dao = new TeacherDao();
	    Teacher teacher = dao.login(id, password);

	    if (teacher != null) {
	        System.out.println(teacher.getSchool());
	        teacher.setAuthenticated(true);

	        // ✨ School を取得
	        School school = teacher.getSchool();

	        // ✨ Teacher を School にセット（JSP表示用）
	        school.setTeacher(teacher);

	        // ✨ セッションに School をセット（JSPや完了画面用）
	        session.setAttribute("school", school);

	        // ログイン中の教員としても一応セット（必要あれば）
	        session.setAttribute("user", teacher);


	        response.sendRedirect("main/Main.action");
	        return;
// ←★★★ これを忘れずに追加！★★★
	    } else {
	        // ログイン失敗時
	        request.getRequestDispatcher("/error.jsp").forward(request, response);
	    }
	}


}
