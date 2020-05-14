<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Crud</title>
</head>
<%
HttpSession seccionp = (HttpSession) request.getSession();
String usuarioseccion = (String) seccionp.getAttribute("usuario");
if(usuarioseccion==null){
	response.sendRedirect("index.jsp");
}
%>

<body>
<a href="index.jsp" class="btn btn-info"></a>


</body>
</html>