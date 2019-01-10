<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Esta es la pagina presentacion.jsp</h1>
<h3>Esto es una variable request ${name}</h3>
<h3>Esto es una variable session ${nameSession}</h3>
<h3>Esto es una variable contexto ${nameContext}</h3>
<a href="Presentacion2.jsp">Ir a Presentacion2.jsp</a>
<br>
<%
	int a = 8;
	int b = 5;
	int c = b +a;
	out.print(c);
%>
<br>
<%=request.getAttribute("name") %>
<br>
<%=request.getSession().getAttribute("nameSession") %>
<br>
<%=request.getServletContext().getAttribute("nameSession") %>
</body>
</html>