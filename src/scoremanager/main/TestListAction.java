package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDao;
import dao.SubjectDao;
import tool.Action;

public class TestListAction extends Action{
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res
			) throws Exception{

	    HttpSession session = req.getSession();
	    Teacher teacher = (Teacher) session.getAttribute("user");

	    // teacher.
		ClassNumDao cDao = new ClassNumDao();
		SubjectDao sDao = new SubjectDao();


        List<Integer> entYearSet = new ArrayList<>();


		LocalDate todeysDate = LocalDate.now();
        int year = todeysDate.getYear();

		// 10年前から1年後まで年をリストに追加
		for (int i = year - 10; i < year + 1; i++){
			entYearSet.add(i);
		}

        // ▼ クラス番号のリスト取得（学校ごとに）
        List<String> classNumList = cDao.filter(teacher.getSchool());
        System.out.println(classNumList + "class");
        // ▼ 科目一覧取得（SbjectDao に findAll() がある前提）
        List<bean.Subject> subjectList = sDao.filter(teacher.getSchool());


        // ▼ JSPに渡す
        req.setAttribute("ent_year_set", entYearSet);
        req.setAttribute("class_num_set", classNumList);
        req.setAttribute("subjectList", subjectList);

		req.getRequestDispatcher("test_list.jsp").forward(req, res);
	}
}
