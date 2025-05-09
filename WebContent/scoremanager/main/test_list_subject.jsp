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
      <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">成績参照(科目)</h2>

    <div class="container">
        <!-- 科目情報 -->
        <%-- action追加(下にも1つ追加) --%>
        <form method="get" action="TestListSubjectExecute.action">
        <div class="title">科目情報</div>
        <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
          <div class="col-3">
            <label class="form-label" for="student-f1-select">入学年度</label>
            <select class="form-select" id="student-f1-select" name="f1">
              <option value="0">--------</option>
              <c:forEach var="year" items="${ent_year_set}">
                <%-- 現在のyearと選択されていたf1が一致していた場合selectedを追記 --%>
               <option value="${year}" <c:if test="${year eq f1}">selected</c:if>>${year}</option>
              </c:forEach>
            </select>
          </div>
          <div class="col-3">
            <label class="form-label" for="student-f2-select">クラス</label>
            <select class="form-select" id="student-f2-select" name="f2">
              <option value="0">--------</option>
              <c:forEach var="num" items="${class_num_set}">
                <%-- 現在のnumと選択されていたf2が一致していた場合selectedを追記 --%>
                <option value="${num}" <c:if test="${num eq f2}">selected</c:if>>${num}</option>
              </c:forEach>
            </select>
          </div>
          <div class="col-3">
            <label class="form-label" for="student-f3-select">科目</label>
            <select class="form-select" id="student-f3-select" name="f3">
              <option value="0">--------</option>
              <c:forEach var="subject" items="${subjectList}">
                <%-- 現在のyearと選択されていたf1が一致していた場合selectedを追記 --%>
                <option value="${subject.cd}" <c:if test="${subject.cd eq f3}">selected</c:if>>${subject.name}</option>
              </c:forEach>
            </select>
          </div>


          <div class="col-2 text-center">
            <button class="btn btn-secondary" id="filter-button">検索</button>
          </div>
          <div class="mt-2 text-warning">${errors.get("f1")}</div>
        </div>
      </form>

		<!-- 学生情報 -->
		<form method="get" action="TestListStudentExecute.action">
		    <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
			<div class="col-2 text-center">学生情報</div>
			<div class="col-4">
			<label class="form-label" for="student-f1-input">学生番号</label>
			<input type="text" class="form-control" id="student-f1-input" name="subjectf1"
       			placeholder="学生番号を入力してください" value="${subjectf1}">
			</div>
				<div class="col-2 text-center">
				<button class="btn btn-secondary" id="filter-button">検索</button>
			</div>
				<div class="mt-2 text-warning">${errors.get("f1")}</div>
			</div>
		</form>

        <!-- ヒントメッセージ -->
       <p style="color: blue;"><p style="color: blue;">科目:${subjectName}</p>

    	<c:if test="${not empty testListSubject}">
		  <table class="table table-striped mt-3">
		    <thead>
		      <tr>
		        <th>入学年度</th>
		        <th>クラス</th>
		        <th>学生番号</th>
		        <th>氏名</th>
		        <th>1回</th>
		        <th>2回</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="sub" items="${testListSubject}">
				  <tr>
				    <td>${sub.entYear}</td>
				    <td>${sub.classNum}</td>
				    <td>${sub.studentNo}</td>
				    <td>${sub.studentName}</td>

					<td>
					  <%
					    Integer point1 = ((bean.TestListSubject)pageContext.getAttribute("sub")).getPoint(1);
					    out.print(point1 != null ? point1 : "-");
					  %>
					</td>

					<td>
					  <%
					    Integer point2 = ((bean.TestListSubject)pageContext.getAttribute("sub")).getPoint(2);
					    out.print(point2 != null ? point2 : "-");
					  %>
					</td>

				  </tr>
			  </c:forEach>
		    </tbody>
		  </table>
		</c:if>

		<c:if test="${not empty message}">
		  <div class="alert alert-info mt-3">${message}</div>
		</c:if>
    </div>
</section>
</c:param>
</c:import>
</html>