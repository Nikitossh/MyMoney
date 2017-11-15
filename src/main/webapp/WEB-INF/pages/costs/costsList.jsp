<%--
  Created by IntelliJ IDEA.
  User: nik
  Date: 06.10.17
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>CostsList</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--This page must return list of cost.--%>
<%--<br>And I am ${name}!--%>
<%--</body>--%>
<%--</html>--%>

<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <h2>Costs</h2>

    <table align="left" bgcolor="#a9a9a9" border="3px">
        <tr>
            <th>id</th>
            <th>date</th>
            <th>sum</th>
            <th>cat_id</th>
            <th>comment</th>
        </tr>
        <c:forEach items="${costs.costList}" var="cost">
            <tr>
                <td><c:out value="${cost.id}"/></td>
                <td><c:out value="${cost.date.date}"/></td>
                <td><c:out value="${cost.value}"/></td>
                <td><c:out value="${cost.category.category}"/></td>
                <td><c:out value="${cost.comment}"/></td>
            </tr>
        </c:forEach>
    </table>
