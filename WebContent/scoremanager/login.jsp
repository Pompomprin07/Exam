<%-- メニューJSP--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/common/base.jsp">
    <c:param name="title">
        ログイン画面
    </c:param>

    <c:param name="scripts"></c:param>

    <c:param name="content">
        <section class="me-4">
            <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">ログイン</h2>


		            <form action="LoginExecute.action" method="post">
		            	<p><input type="text" id="id" name="id" class="form-control mx-auto w-50" placeholder="ID" ></p>
	                    <p><input type="password" id="password" name="password" class="form-control mx-auto w-50" placeholder="パスワード"></p>

	                    <div class="form-check mt-2 d-flex justify-content-center align-items-center">
						    <input type="checkbox" class="form-check-input me-2" id="showPassword" onclick="togglePassword()">
						    <label class="form-check-label" for="showPassword">パスワードを表示</label>
						</div>
	                    <button type="submit" class="btn btn-primary mt-3 w-25 d-block mx-auto">ログイン</button>
	                </form>
        </section>
    </c:param>
</c:import>

<script>
    function togglePassword() {
        const passwordField = document.getElementById('password');
        passwordField.type = passwordField.type === 'password' ? 'text' : 'password';
    }
</script>