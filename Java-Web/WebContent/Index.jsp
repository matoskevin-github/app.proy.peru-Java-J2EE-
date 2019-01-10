<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hola Mundo</h1>
<a href="MyServlet?var1=2&var2=6">Creamos una peticion tipo GET</a>
<form action="MyServlet" method="POST">
	<label>Nombre:</label>
	<input type="text" name="txtNombre">
	<button type="submit">Enviar</button>
</form>
</body>
</html>