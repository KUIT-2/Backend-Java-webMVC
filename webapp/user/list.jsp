<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/include/navigation.jspf" %>
<%@ page import="java.util.Collection" %>
<%@ page import="jwp.model.User" %>


<!doctype html>
<html lang="ko">
<body>
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
            <%
                User my = (User) request.getAttribute("my");
                Collection<User> users = (Collection<User>) request.getAttribute("users");
                for (User user : users) {
                boolean isMe = my.isSameUser(user);
            %>
            <tr>
                <th class="col-md-3"><%= user.getUserId() %>
                </th>
                <th class="col-md-3"><%= user.getName() %>
                </th>
                <th class="col-md-3"><%= user.getEmail() %>
                </th>
                <th class="col-md-3">
                    <c:choose>
                    <c:when test="${isMe} eq true">
                        <a href="/user/updateForm?userId=<%=user.getUserId()%>" class="btn btn-success" role="button">수정</a>
                    </c:when>
                    <c:otherwise>
                        <%= isMe %>
                    </c:otherwise>
                    </c:choose>
                </th>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

</body>
</html>