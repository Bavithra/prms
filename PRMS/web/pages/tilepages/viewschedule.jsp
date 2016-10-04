<%-- 
    Document   : viewschedule
    Created on : 2016-10-4, 10:21:24
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
        <title> <fmt:message key="title.crudschedule"/> </title>
    </head>
    <body>
        <h1><fmt:message key="label.crudschedule"/></h1>
        <br/><br/>
        <table class="borderAll">
            <tr>
                <th><fmt:message key="label.crudschedule.dateofprogram"/></th>
                <th><fmt:message key="label.crudschedule.startTime"/></th>
                <th><fmt:message key="label.crudschedule.duration"/></th>
                <th><fmt:message key="label.crudschedule.endTime"/></th>
                <th><fmt:message key="label.crudschedule.name"/></th>
                <th><fmt:message key="label.crudschedule.presenter"/></th>
                <th><fmt:message key="label.crudschedule.producer"/></th>
            </tr>
            <c:forEach var="programSlot" items="${scheduleList}" varStatus="status">
                <tr class="${status.index%2==0?'even':'odd'}">
                    <td class="nowrap">${programSlot.getFormattedStartDate()}</td>
                    <td class="nowrap">${programSlot.getFormattedStartTime()}</td>
                    <td class="nowrap">${programSlot.getRadioProgram().getTypicalDuration()}</td>
                    <td class="nowrap">${programSlot.getFormattedEndTime()}</td>
                    <td class="nowrap">${programSlot.getRadioProgram().getName()}</td>
                    <td class="nowrap">${programSlot.getPresenter().getId()}</td>
                    <td class="nowrap">${programSlot.getProducer().getId()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
