package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class StudentCreateAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 入学年度プルダウン用データの作成（例：2020～2025）
        int[] years = new int[6];
        for (int i = 0; i < years.length; i++) {
            years[i] = 2020 + i;
        }

        // JSPに渡す
        request.setAttribute("years", years);

        // 登録画面にフォワード
        request.getRequestDispatcher("student_create.jsp").forward(request, response);
    }
}
