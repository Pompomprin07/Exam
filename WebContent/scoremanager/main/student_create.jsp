<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/common/base.jsp">
<c:param name="scripts"></c:param>
  <c:param name="content">
    <section class="me-4">
      <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">学生情報登録</h2>

      <form action="StudentCreateExecute.action" method="post" class="px-4" style="max-width: 400px;">
        <!-- 入学年度 -->
         <div class="mb-3">
          <label for="entYear" class="form-label">入学年度</label>
          	<div class="col">
				<select name="entYear" class="form-select">
					<c:forEach var="y" items="${years}">
						<option value="${y}" <c:if test="${student.entYear == y}">selected</c:if>>${y}</option>
					</c:forEach>
				</select>
			</div>
        </div>



        <!-- 学生番号 -->
        <div class="mb-3">
          <label for="no" class="form-label">学生番号</label>
          <input type="text" name="no" id="no" class="form-control" placeholder="学生番号を入力してください">
        </div>

        <!-- 氏名 -->
        <div class="mb-3">
          <label for="name" class="form-label">氏名</label>
          <input type="text" name="name" id="name" class="form-control" placeholder="氏名を入力してください">
        </div>

		<!-- クラス -->
		<div class="mb-3">
		  <label for="classNum" class="form-label">クラス</label>
		  <select name="classNum" id="classNum" class="form-select">
		    <option value="101">101</option>
		    <option value="102">102</option>
		    <option value="103">103</option>
		  </select>
		</div>


        <!-- ボタン -->
        <div class="mb-3">
          <button type="submit" class="btn btn-primary">登録して終了</button>
        </div>

        <div>
          <a href="StudentList.action">戻る</a>
        </div>
      </form>
    </section>
  </c:param>
</c:import>
