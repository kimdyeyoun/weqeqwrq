<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String err = (String) request.getAttribute("loginerr"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
</head>
<body>
    <h1>로그인</h1>
    <% if (err != null){ %>
        <%=err%>
    <% } %>
    <form action="/user/login" method="post">
        <div><input type="text" name="uid" placeholder="아이디"></div>
        <div><input type="password" name="upd" placeholder="비밀번호"></div>
        <div>
            <input type="submit" value="로그인">
            <a href="/user/join"><input type="button" value="회원가입"></a>
        </div>
    </form>
</body>
</html>