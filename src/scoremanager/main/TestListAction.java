package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class TestListAction extends Action{
	@Override
	public void execute
	(HttpServletRequest req,HttpServletResponse res
			) throws Exception{
		req.getRequestDispatcher("test_list.jsp").forward(req, res);
	}
}
