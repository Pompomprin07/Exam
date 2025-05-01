<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/common/base.jsp">
  <c:param name="title">得点管理システム</c:param>
  <c:param name="scripts"></c:param>
  <c:param name="content">
    <section class="me-4">
      <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">成績管理</h2>

      <!-- 検索フォーム -->
      <form method="get">
        <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
          <div class="col-3">
            <label class="form-label" for="f1">入学年度</label>
            <select class="form-select" id="f1" name="f1">
              <option value="0">--------</option>
              <c:forEach var="year" items="${ent_year_set}">
                <option value="${year}" <c:if test="${year == f1}">selected</c:if>>${year}</option>
              </c:forEach>
            </select>
          </div>

          <div class="col-3">
            <label class="form-label" for="f2">クラス</label>
            <select class="form-select" id="f2" name="f2">
              <option value="0">--------</option>
              <c:forEach var="num" items="${class_num_set}">
                <option value="${num}" <c:if test="${num == f2}">selected</c:if>>${num}</option>
              </c:forEach>
            </select>
          </div>

          <div class="col-3">
            <label class="form-label" for="f3">科目</label>
            <select class="form-select" id="f3" name="f3">
              <option value="0">--------</option>
              <c:forEach var="num" items="${class_num_set}">
                <option value="${num}" <c:if test="${num == f3}">selected</c:if>>${num}</option>
              </c:forEach>
            </select>
          </div>

          <div class="col-2">
            <label class="form-label" for="f4">回数</label>
            <select class="form-select" id="f4" name="f4">
              <option value="0">--------</option>
              <c:forEach var="i" begin="1" end="10">
                <option value="${i}" <c:if test="${i == f4}">selected</c:if>>${i}</option>
              </c:forEach>
            </select>
          </div>

          <div class="col-1 text-center align-self-end">
            <button class="btn btn-secondary" type="submit">検索</button>
          </div>

          <div class="mt-2 text-warning">${errors.get("f1")}</div>
        </div>
      </form>

      <!-- 検索結果 -->
      <c:choose>
        <c:when test="${not empty students}">
          <div class="px-4 mb-2">科目: ${f3}（${f4}回）</div>

          <form method="post" action="TestRegistSave.action">
            <table class="table table-hover">
              <thead>
                <tr>
                  <th>入学年度</th>
                  <th>クラス</th>
                  <th>学生番号</th>
                  <th>氏名</th>
                  <th>点数</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="student" items="${students}">
                  <tr>
                    <td>${student.entYear}</td>
                    <td>${student.classNum}</td>
                    <td>
                      ${student.no}
                      <input type="hidden" name="student" value="${student.no}">
                    </td>
                    <td>${student.name}</td>
                    <td>
                      <input type="text" name="point" value="" class="form-control" style="width: 80px;">
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>

            <div class="text-end">
              <button type="submit" class="btn btn-primary">登録して終了</button>
            </div>
          </form>
        </c:when>

        <c:otherwise>
          <div class="px-4">成績情報が存在しませんでした</div>
        </c:otherwise>
      </c:choose>
    </section>
  </c:param>
</c:import>
