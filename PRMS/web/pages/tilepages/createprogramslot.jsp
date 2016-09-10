<%-- 
    Document   : createprogramslot
    Created on : 2016-9-8, 16:47:49
    Author     : linby
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <fmt:setBundle basename="ApplicationResources" />

        <title><fmt:message key="title.createprogramslot" /></title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/nocturne/enprogterramslot" method=post>
            <center>
                <table cellpadding=4 cellspacing=2 border=0>
                    <tr>
                        <td><fmt:message key="label.createprogramslot.year" /></td>
                        <td>
                            <select name="year">
                                <c:forEach items="${years}" var="years">
                                    <option value="${years.year}">${years.year}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.createprogramslot.name" /></td>
                        <td><c:if test="${param['insert'] == 'true'}">
                                <select name="program">
                                <c:forEach items="${programlist}" var="programlist">
                                    <option value="${programlist.name}">${programlist.name}</option>
                                </c:forEach>
                                </select>
                                <input type="hidden" name="ins" value="true" />
                            </c:if> 
                            <c:if test="${param['insert']=='false'}">
                                <select name="program">
                                <c:forEach items="${programlist}" var="id">
                                    <option value="${name}">${name}</option>
                                </c:forEach>
                                </select>
                                <input type="hidden" name="ins" value="false" />
                            </c:if></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.createprogramslot.description" /></td>
                        <td><input type="text" name="description"
                                   value="${param['description']}" size=45 maxlength=20></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.createprogramslot.startTime" /></td>
                        <td><input type="text" name="startTime"
                                   value="${param['startTime']}" size=45 maxlength=20></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.createprogramslot.presenter" /></td>
                        <td>
                            <select name="presenter">
                                <c:forEach items="${presenters}" var="id">
                                    <option value="${name}">${name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.createprogramslot.producer" /></td>
                        <td>
                            <select name="producer">
                                <c:forEach items="${producers}" var="id">
                                    <option value="${name}">${name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.createprogramslot.duration" /></td>
                        <td><input type="text" name="duration"
                                   value="${param['duration']}" size=15 maxlength=20></td>
                    </tr>
                </table>
            </center>
            <input type="submit" value="Submit"> <input type="reset"
                                                        value="Reset">
        </form>

    </body>
</html>