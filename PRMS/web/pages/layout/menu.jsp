<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<fmt:setBundle basename="ApplicationResources" />

<h3 align="center">
    <fmt:message key="caption.menu" />
</h3>
<table class="framed">
    <tr>
        <td><a href="<c:url value="/pages/login.jsp"/>"> <fmt:message
                    key="caption.menu.login" />
            </a></td>
    </tr>
    <c:set var="showmyschedule" value="false" scope="session"/>
    <c:set var="showmanageschedule" value="false" scope="session"/>
    <c:set var="showmanageuser" value="false" scope="session"/>
    <c:set var="showmanageprogram" value="false" scope="session"/>
    <c:forEach var="item" items="${sessionScope.user.roles}">
        <c:if test="${item.role=='admin'}">
            <c:set var="showmanageuser" value="true" />
        </c:if>
        <c:if test="${item.role eq 'manager'}">
            <c:set var="showmanageprogram" value="true" />
            <c:set var="showmanageschedule" value="true" />
        </c:if>
        <c:if test="${item.role eq 'presenter'||item.role eq 'producer'}">
            <c:set var="showmyschedule" value="true" />
        </c:if>
    </c:forEach>
    
    <c:if test="${showmanageprogram eq true}">
        <!--  search is not implemented , remove it from menu selection
        * <tr>
                <td>
                                <a href="<c:url value="/nocturne/searchrp"/>"> <fmt:message
            key="caption.menu.searchrp" />
</a>
</td>
</tr> -->
        <tr>
            <td>
                <a href="<c:url value="/nocturne/managerp"/>"> <fmt:message
                        key="caption.menu.managerp" />
                </a>
            </td>
        </tr>
    </c:if>
    <c:if test="${showmanageuser eq true}">
        <tr>
            <td>
                <a href="<c:url value="/nocturne/manageUser"/>"> <fmt:message
                        key="caption.menu.manageUser" />
                </a>
            </td>
        </tr>
    </c:if>
    <c:if test="${showmanageschedule eq true}">
        <tr>
            <td>
                <a href="<c:url value="/nocturne/manageschedule"/>"> <fmt:message
                        key="caption.menu.manageschedule" />
                </a>
            </td>
        </tr>
    </c:if>
    <c:if test="${showmyschedule eq true}">
        <tr>
            <td>
                <a href="<c:url value="/nocturne/viewmyschedule"/>"> <fmt:message
                        key="caption.menu.viewmyschedule" />
                </a>
            </td>
        </tr>
    </c:if>
    <c:set var="showmyschedule" value="false" scope="session"/>
    <c:set var="showmanageschedule" value="false" scope="session"/>
    <c:set var="showmanageuser" value="false" scope="session"/>
    <c:set var="showmanageprogram" value="false" scope="session"/>
    <tr>
        <td><a href="<c:url value="/nocturne/logout"/>"> <fmt:message
                    key="caption.menu.logout" />
            </a></td>
    </tr>
</table>


