package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class ClassCreateDoneAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 完了画面へフォワード
        request.getRequestDispatcher("subject_create_done.jsp").forward(request, response);
    }
}
