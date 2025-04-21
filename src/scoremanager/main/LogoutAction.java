package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action {
  public void execute(HttpServletRequest request, HttpServletResponse response
  ) throws Exception {

		HttpSession session = request.getSession();
		session.invalidate();

	  	request.getRequestDispatcher("/scoremanager/main/logout.jsp").forward(request, response);
  }
}