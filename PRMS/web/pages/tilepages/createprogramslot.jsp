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
        <script src="//code.jquery.com/jquery-1.12.4.js"></script>
        <script src="//code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
        <script src="//senthilraj.github.io/TimePicki/js/timepicki.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="//senthilraj.github.io/TimePicki/css/timepicki.css">
        <fmt:setBundle basename="ApplicationResources" />
        <title><fmt:message key="title.createprogramslot" /></title>
        <script>
            $(function () {
                dateLimit();
            });
            function dateLimit() {
                //refresh the datepicker
                $("#datepicker").datepicker("destroy");
                $("#datepicker").val("");
                //set the datevalue and constraints
                var year = document.getElementById("yearpicker").options[document.getElementById("yearpicker").selectedIndex].text;
                $("#datepicker").datepicker("setDate", new Date(year, 0, 1));
                $("#datepicker").datepicker({
                    minDate: new Date(year, 0, 1),
                    maxDate: new Date(year, 11, 31)
                });
            }
        </script>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/nocturne/enterprogramslot" method=post>
            <center>
                <input type="hidden" name="id" value="${param['id']}" />
                <table cellpadding=4 cellspacing=2 border=0>
                    <tr>
                        <td><fmt:message key="label.createprogramslot.year" /></td>
                        <td>
                            <select name="year" onchange="dateLimit()" id="yearpicker">
                                <c:forEach var="year" items="${yearList}">
                                    <option value="${year.getYear()}">${year.getYear()}</option>
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
                                    <c:forEach items="${programlist}" var="programlist">
                                        <option value="${programlist.name}">${programlist.name}</option>
                                    </c:forEach>
                                </select>
                                <input type="hidden" name="ins" value="false" />
                            </c:if></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.createprogramslot.dateofprogram" /></td>
                        <td><input type="text" name="dateOfProgram" id="datepicker" readonly
                                   value="${param['dateOfProgram']}" size=30 maxlength=20></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.createprogramslot.startTime" /></td>
                        <td><input type="text" name="startTime" id="timepicker" 
                                   value="${param['startTime']}" size=40 maxlength=20></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.createprogramslot.presenter" /></td>
                        <td>
                            <select name="presenter">
                                <c:forEach var="presenter" items="${presenterList}">
                                    <option value="${presenter.getName()}">${presenter.getName()}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.createprogramslot.producer" /></td>
                        <td>
                            <select name="producer">
                                <c:forEach var="producer" items="${producerList}">
                                    <option value="${producer.getName()}">${producer.getName()}</option>
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