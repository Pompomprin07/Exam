<%-- 科目一覧.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/common/base.jsp">
  <c:param name="title">得点管理システム</c:param>
  <c:param name="scripts"></c:param>
  <c:param name="content">
    <section class="me-4">
      <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4"><strong>科目管理</strong></h2>

      <div class="my-2 text-end px-4">
        <a href="SubjectCreate.action">新規登録</a>
      </div>

      <table class="table table-hover">
        <thead>
          <tr>
            <th style="width: 20%;">科目コード</th>
            <th style="width: 40%;">科目名</th>
            <th class="text-center" style="width: 20%;"></th>
            <th class="text-center" style="width: 20%;"></th>
          </tr>
        </thead>
        <tbody>
          <c:choose>
            <c:when test="${not empty subjects}">
              <c:forEach var="subject" items="${subjects}">
                <tr>
                  <td>${subject.cd}</td>
                  <td>${subject.name}</td>
                  <td class="text-center">
                    <a href="SubjectUpdate.action?cd=${subject.cd}">変更</a>
                  </td>
                  <td class="text-center">
                    <a href="SubjectDelete.action?cd=${subject.cd}">削除</a>
                  </td>
                </tr>
              </c:forEach>
            </c:when>
            <c:otherwise>
              <tr>
                <td colspan="4" class="text-center text-muted">登録された科目はありません</td>
              </tr>
            </c:otherwise>
          </c:choose>
        </tbody>
      </table>
    </section>
  </c:param>
</c:import>
