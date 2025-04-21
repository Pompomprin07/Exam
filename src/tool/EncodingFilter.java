package tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// アノテーション : URL指定 → 共通部分のため全て(*)
@WebFilter(urlPatterns={"/*"})

// Filter : インターフェース : 抽象クラスのようなものを継承 → implements
public class EncodingFilter implements Filter{

	public void doFilter(
			ServletRequest request,ServletResponse response,
			FilterChain chain
		) throws IOException,ServletException {

		// 前処理開始
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("フィルタの前処理");
		// 前処理終了

		// ↑ サーブレットやJSPを呼び出す"前"処理
		// ここを境として前処理、後処理に分ける
		// ↓ サーブレットやJSPを呼び出す"後"処理
		chain.doFilter(request, response);
		System.out.println("フィルタの後処理");
	}

	public void init(FilterConfig filterConfig) {}
	public void  destroy(){}
}
