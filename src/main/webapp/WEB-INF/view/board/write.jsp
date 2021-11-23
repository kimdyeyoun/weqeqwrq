<%@ page import="com.koreait.board.model.UserVO" %>
<%@ page import="com.koreait.board.model.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String err = (String) request.getAttribute("errwrite");
    BoardVO data = (BoardVO) request.getAttribute("data");

%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글쓰기</title>
</head>
<body>
    <h1>글쓰기</h1>
    <% if (err != null){ %>
    <%=err%>
    <% } %>
    <form action="/board/write" method="post">
        <div><input type="text" name="title" placeholder="제목" value="${requestScope.data.title}"></div>
        <div><textarea name="ctnt" rows="5" placeholder="내용">${requestScope.data.ctnt}</textarea></div>
        <div>
            <input type="submit" value="등록">
            <input type="reset" value="초기화">
        </div>
    </form>
</body>
</html>