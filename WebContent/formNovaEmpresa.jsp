<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<c:url value = "/entrada" var= "LinkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<form action="${LinkEntradaServlet}" method="post">
	
		Nome: <input type="text" name="nome"  />
		Data abertura: <input type="text" name="data"  />
		
		<input type="hidden" name="acao" value="NovaEmpresa">
	
		<input type="submit" />
	</form>

</body>
</html>