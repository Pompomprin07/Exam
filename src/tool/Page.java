package tool;


import java.io.PrintWriter;
// 出力に使用するクラスをインポート
public class Page {

	// HTMLの前半を出力するメソッド
	public static void header(PrintWriter out){
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<meta charset='UTF-8'>");
	out.println("<title>Servlet/JSP Sample Programs</title>");
	out.println("</head>");
	out.println("<body>");
	}
	// HTMLの後半を出力するメソッド
	public static void footer(PrintWriter out){
		out.println("</body>");
		out.println("</html>");
	}
}
