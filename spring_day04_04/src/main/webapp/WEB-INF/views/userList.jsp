<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
	<table cellpadding=0 cellspacing=0 border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>UserName</th>
				<th>Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
		<%--
		jstl标签
		通过EI表达式获取servlet封装到request域中的users   ${key}
		--%>
		<%--获取users  使用${users}--%>
		<c:forEach items="${users}" var="user">
			<tr>
				<%--获取user对象中的属性 ${user.id}--%>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
			</tr>
		</c:forEach>


		</tbody>
	</table>
	
</body>
</html>