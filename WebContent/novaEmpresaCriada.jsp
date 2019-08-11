<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
	
		<c:if test="${not empty empresa}">
			Empresa ${ empresa } cadastrada com sucesso!
		</c:if>
		
		<c:if test="${empty empresa}">
			Nenhuma empresa cadastrada!
		</c:if>

	</body>
</html>
