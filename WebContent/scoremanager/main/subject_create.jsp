<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/common/base.jsp">
  <c:param name="title">得点管理システム</c:param>
  <c:param name="scripts"></c:param>
  <c:param name="content">
    <section class="me-4">
      <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">学生情報登録</h2>

      <form action="StudentCreateExecute.action" method="post" class="px-4" style="max-width: 400px;">



        <!-- 科目コード -->
        <div class="mb-3">
          <label for="no" class="form-label">科目コード</label>
          <input type="text" name="no" id="no" class="form-control" placeholder="科目コードを入力してください">
        </div>

        <!-- 科目名 -->
        <div class="mb-3">
          <label for="name" class="form-label">科目名</label>
          <input type="text" name="name" id="name" class="form-control" placeholder="科目名を入力してください">
        </div>

        <!-- ボタン -->
        <div class="mb-3">
          <button type="submit" class="btn btn-primary">登録</button>
        </div>

        <div>
          <a href="StudentList.action">戻る</a>
        </div>
      </form>
    </section>
  </c:param>
</c:import>
