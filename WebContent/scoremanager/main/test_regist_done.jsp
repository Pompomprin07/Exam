<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/common/base.jsp">
<c:param name="title">得点管理システム</c:param>
<c:param name="scripts"></c:param>

<c:param name="content">
<section class="no">
<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">成績管理</h2>

			<div class="alert alert-success py-2 px-3 text-center" role="alert" style="font-size: 14px;">
			    登録が完了しました
			</div>

			<div class="">
				<a href="TestRegistExecute.action" class="me-4">戻る</a>

				<a href="TestList.action">成績参照</a>
			</div>
		</section>
	</c:param>
</c:import>



