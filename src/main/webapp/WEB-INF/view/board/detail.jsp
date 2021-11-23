<%@ page import="com.koreait.board.model.BoardVO" %>
<%@ page import="com.koreait.board.model.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BoardVO vo = (BoardVO) request.getAttribute("data");
    UserVO loginUser = (UserVO)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <h1>NO.${requestScope.data.iboard}</h1>
    <div>제목 ${requestScope.data.title}</div>
    <div>작성자 ${requestScope.data.writerNm}</div>
    <div>내용 ${requestScope.data.ctnt}</div>
    <div>작성일시 ${requestScope.data.rdt}</div>

    <div>${requestScope.err}</div>
    <% if (loginUser != null && vo.getWriter() == loginUser.getIuser()){ %>
        <a href="/board/mod?iboard=<%=vo.getIboard()%>"><input type="button" value="수정"></a>
        <a href="/board/del?iboard=<%=vo.getIboard()%>"><input type="button" value="삭제"></a>
    <% } %>
</body>
</html>