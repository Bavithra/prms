<%-- 
    Document   : cryear
    Created on : 2016-9-10, 17:17:13
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
        <title> <fmt:message key="title.cryear"/> </title>
    </head>
    <body>
        <h1><fmt:message key="label.cryear"/></h1>
        <c:url var="url" scope="page" value="/nocturne/openyear">
            <c:param name="year" value=""/>
            <c:param name="assignBy" value=""/>
        </c:url>
        <a href="${url}"><fmt:message key="label.cryear.open"/></a>
        <br/><br/>
        <table class="borderAll">
            <tr>
                <th><fmt:message key="label.cryear.year"/></th>
                <th><fmt:message key="label.cryear.assignBy"/></th>
            </tr>
            <c:forEach var="years" items="${years}" varStatus="status">
                <tr class="${status.index%2==0?'even':'odd'}">
                    <td class="nowrap">${years.year}</td>
                    <td class="nowrap">${years.assignedBy}</td>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
