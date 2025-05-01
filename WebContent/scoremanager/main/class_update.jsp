<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/common/base.jsp">
  <c:param name="title">得点管理システム</c:param>
  <c:param name="scripts"></c:param>
  <c:param name="content">
    <section class="me-4">
      <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">クラス情報変更</h2>

      <form action="SubjectUpdateExecute.action" method="post" class="px-4">
       <%-- 科目コード（固定：readonly） --%>
		<div class="mb-3">
		  <label class="form-label">クラスコード</label>
		  <p class="form-control-plaintext ps-3">${subject.cd}</p>
		  <input type="hidden" name="cd" value="${subject.cd}">
		</div>


		<%-- 科目名（変更可能） --%>
		<div class="mb-3">
		  <label class="form-label">クラス名</label>
		  <input type="text" class="form-control" name="name" value="${subject.name}">
		</div>


        <button type="submit" class="btn btn-primary me-3">登録</button><br>
        <p><a href="ClassList.action">戻る</a></p>

        <div class="mt-3 text-danger">${message}</div>
      </form>
    </section>
  </c:param>
</c:import>
