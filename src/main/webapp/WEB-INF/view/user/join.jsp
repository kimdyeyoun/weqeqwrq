<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String errjoin = (String) request.getAttribute("errjoin"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
    <h1>회원가입</h1>
    <% if (errjoin != null){ %>
        <%=errjoin%>
    <% } %>
    <form action="/user/join" method="post">
        <div><input type="text" name="uid" placeholder="아이디"></div>
        <div><input type="password" name="upd" placeholder="비밀번호"></div>
        <div><input type="text" name="nm" placeholder="이름"></div>
        <div>
            gender  <label>여자 <input type="radio" name="gender" value="0"></label>
                    <label>남자 <input type="radio" name="gender" value="1"></label>
        </div>
        <div>
            <input type="submit" value="회원가입">
            <a href="/user/login"><input type="button" value="이전"></a>
        </div>
    </form>
</body>
</html>