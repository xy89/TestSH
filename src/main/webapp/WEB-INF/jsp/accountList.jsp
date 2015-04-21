<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
</head>
<body>
	<table>
		<c:forEach var="account" items="${accountList}">
			<tr>
				<td>${account.account}</td>
				<td>${account.password}</td>
				<td>${account.category}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>




