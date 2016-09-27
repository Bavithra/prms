<%-- 
    Document   : createyear
    Created on : 2016-9-8, 16:20:49
    Author     : linby
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
        <fmt:setBundle basename="ApplicationResources" />
        <title> <fmt:message key="title.createyear"/> </title>
    </head>
<body>
	<form action="${pageContext.request.contextPath}/nocturne/enteryear" method=post>
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<td><fmt:message key="label.createyear.year" /></td>
					<td>
                                            <input type="text" name="year" value="" size=4
						maxlength=20 >
					<input type="hidden" name="ins" value="false" />
					</td>
                                </tr>
			</table>
		</center>
		<input type="submit" value="Submit" />
	</form>

</body>
</html>