<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/common/base.jsp">
<c:param name="title">得点管理システム</c:param>
<c:param name="scripts"></c:param>

<c:param name="content">
<section class="no">
<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生情報登録</h2>

	        <div class="alert alert-success" role="alert">
	            ログアウトしました
			</div>
	 		<%-- ログインurl --%>
			<% String url_name = "http://localhost:8080/teamC/scoremanager/Login.action";%>

        	<div>
			<a href="/teamC/scoremanager/Login.action" class="btn btn-primary ms-2">ログイン</a>
			</div>
		</section>
	</c:param>
</c:import>



