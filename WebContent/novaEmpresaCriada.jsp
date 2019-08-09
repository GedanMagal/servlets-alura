<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Primeira Pagina JSP</title>
</head>
<body>
		<c:if test="${not empty empresa}">
				Empresa ${empresa} cadastrada com sucesso!
		</c:if>

	<c:if test="${empty empresa}">
			Nenhum empresa cadastrada!
		</c:if>

</body>

</html>

