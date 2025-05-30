<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
    // Invalidate the current user session to logout
    if (session != null) {
        session.invalidate();
    }
    // Redirect to login page (adjust the path as per your app)
    response.sendRedirect("userLogin.jsp");
%>

</body>
</html>