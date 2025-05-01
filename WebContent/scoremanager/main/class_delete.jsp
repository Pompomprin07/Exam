<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/common/base.jsp">
  <c:param name="title">得点管理システム</c:param>
  <c:param name="scripts"></c:param>
  <c:param name="content">
    <section class="me-4">
      <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">クラス情報削除</h2>

      <div class="px-4">

        <form action="SubjectDeleteExecute.action" method="post" class="mt-4">
          <input type="hidden" name="cd" value="${subject.cd}">

          <div class="mb-3">
            <p>「${subject.name}」を削除してもよろしいですか</p>
            <button type="submit" class="btn btn-danger">削除</button>
          </div>


          <div class="mt-4">
			  <a href="ClassList.action">戻る</a>
		  </div>

        </form>

      </div>
    </section>
  </c:param>
</c:import>
