<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Collection" %>
<%@ page import="jwp.model.User" %>


<!doctype html>
<html lang="ko">
<%@ include file="/include/head.jspf" %>

<body>
<%@ include file="/include/navigation.jspf" %>
<div class="navbar-default">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
            <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
        </a>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="/index.html" class="nav-link px-2 link-secondary">Q&A</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">FAQs</a></li>
            <li><a href="/user/userList" class="nav-link px-2 link-dark">User List</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">About</a></li>
        </ul>

            <%
            HttpSession session1 = request.getSession();
            Object sessionValue = session1.getAttribute("user"); // 세션에서 사용자 정보 가져오기
            Collection<User> users = (Collection<User>) request.getAttribute("users"); // request 속성에서 사용자 목록 가져오기

            if (sessionValue != null) {
                User sessionUser = (User) sessionValue; // 세션에서 가져온 사용자 정보
                for (User user : users) {
            %>
            <div class="col-md-3 text-end">
                        <a href="/user/logout" type="button" class="btn btn-outline-primary me-2">Logout</a>
                    </div>
                </header>
                    <div class="container" id="main">
                        <table class="table table-striped">
                            <thead class="col-md-12">
                                <tr>
                                    <th class="col-md-3">아이디</th>
                                    <th class="col-md-3">이름</th>
                                    <th class="col-md-3">이메일</th>
                                    <th class="col-md-3">#</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th class="col-md-3"><%= user.getUserId() %></th>
                                    <th class="col-md-3"><%= user.getName() %></th>
                                    <th class="col-md-3"><%= user.getEmail() %></th>
                                    <th class="col-md-3"><a href="/user/updateForm.jsp?userId=<%= user.getUserId() %>" class="btn btn-success" role="button">수정</a></th>
                                </tr>
                            </tbody>
                        </table>
                    </div>

            <%
                }
            }else {
            %>
            <div class="col-md-3 text-end">
                        <a href="/user/login.jsp" type="button" class="btn btn-outline-primary me-2">Login</a>
                    </div>
                </header>
                <p> 로그인한 User만 List를 열람할 수 있습니다.<br> . </p>
            <%
            }
            %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/scripts.js"></script>
</body>
</html>