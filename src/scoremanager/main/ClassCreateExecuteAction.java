package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class ClassCreateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    request.setCharacterEncoding("UTF-8");

	    HttpSession session = request.getSession();
	    School school = (School) session.getAttribute("school");

	    // パラメータ取得
	    String cd = request.getParameter("cd");
	    String name = request.getParameter("name");

	    // ★ ここにログを追加！
	    System.out.println("【DEBUG】cd = " + cd);
	    System.out.println("【DEBUG】name = " + name);
	    System.out.println("【DEBUG】school = " + school);

	    // schoolがnullのときのチェック（任意）
	    if (school == null) {
	        System.out.println("【ERROR】schoolがnullです。ログイン情報が取得できていません！");
	        throw new Exception("セッションから学校情報が取得できませんでした。ログインし直してください。");
	    }

	    // Beanにセット
	    Subject subject = new Subject();
	    subject.setCd(cd);
	    subject.setName(name);
	    subject.setSchool(school);

	    // 登録
	    SubjectDao dao = new SubjectDao();
	    boolean result = dao.save(subject);

	    if (result) {
	        // 登録成功 → 完了画面にフォワード！
	        request.getRequestDispatcher("ClassCreateDone.action").forward(request, response);
	    } else {
	        request.setAttribute("message", "登録に失敗しました");
	        request.getRequestDispatcher("class_create.jsp").forward(request, response);
	    }

	}
}
