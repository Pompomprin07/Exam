<%-- subject_create.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/common/base.jsp">
  <c:param name="title">得点管理システム</c:param>
  <c:param name="scripts"></c:param>
  <c:param name="content">
    <section class="me-4">
      <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4"><strong>科目情報登録</strong></h2>

      <form action="SubjectCreateExecute.action" method="post" class="px-4">
        <%-- ②③ 科目コード入力 --%>
        <div class="mb-3">
          <label class="form-label" for="subject-cd">科目コード</label>
          <input type="text" class="form-control" id="subject-cd" name="cd" placeholder="科目コードを入力してください" value="${param.cd}">
          <div class="text-danger">${errors.cd}</div>
        </div>

        <%-- ④⑤ 科目名入力 --%>
        <div class="mb-3">
          <label class="form-label" for="subject-name">科目名</label>
          <input type="text" class="form-control" id="subject-name" name="name" placeholder="科目名を入力してください" value="${param.name}">
          <div class="text-danger">${errors.name}</div>
        </div>

        <%-- ⑥ 登録ボタン --%>
        <button type="submit" class="btn btn-primary me-3">登録</button>

        <%-- ⑦ 戻るリンク --%>
        <p><a href="SubjectList.action">戻る</a></p>

        <%-- 全体メッセージ --%>
        <div class="mt-3 text-danger">${message}</div>
      </form>
    </section>
  </c:param>
</c:import>
