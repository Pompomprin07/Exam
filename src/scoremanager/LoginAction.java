package scoremanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

///// LoginActionで実証すること/////

// ① セッション処理
// ① jspで入力したデータを受け取る(ログイン名・パスワード)
// ② Cosutmer(DAOで使用してIDとPWが一致しているか確認するメソッドを呼び出す)
// ③ 該当するページへフォワード

import tool.Action;


public class LoginAction extends Action{

	@Override
	public void execute
	(HttpServletRequest req,HttpServletResponse res
			) throws Exception{
		req.getRequestDispatcher("login.jsp").forward(req, res);
	}
}
