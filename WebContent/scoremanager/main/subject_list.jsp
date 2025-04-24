<%--学生一覧.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/common/base.jsp">
  <c:param name="title">
    得点管理システム
  </c:param>
  <c:param name="scripts"></c:param>
  <c:param name="content">
    <section class="me-4">
      <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">科目管理</h2>
      <div class="my-2 text-end px-4">
        <a href="SubjectCreate.action">新規登録</a>
      </div>

      <c:choose>
        <c:when test="${students.size()>0}">
          <table class="table table-hover">
            <tr>
              <th>科目コード</th>
              <th>科目名</th>
              <th></th>
              <th></th>
            </tr>
            <c:forEach var="subject" items="${student}">
              <tr>
                <td>${student.entYear}</td>
                <td>${student.no}</td>
                  <c:choose>

                    <c:when test="${student.isAttend()}">
                    </c:when>
                  </c:choose>

                <td><a href="SubjecttUpdate.action?no=${student.no}">変更</a></td>
                <td><a href="Subjectdelete.action?no=${student.no}">削除</a></td>
              </tr>
            </c:forEach>
          </table>
        </c:when>
        <c:otherwise>
          <div>科目情報が存在しませんでした</div>
        </c:otherwise>
      </c:choose>
    </section>
  </c:param>
</c:import>

