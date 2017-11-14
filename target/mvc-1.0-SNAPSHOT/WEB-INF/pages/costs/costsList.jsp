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
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="mymoney" tagdir="/WEB-INF/tags" %>--%>
<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>


<petclinic:layout pageName="costs">
    <h2>Costs</h2>

    <table id="costsTable" class="table table-striped">
        <thead>
        <tr>
            <th>id</th>
            <th>sum</th>
            <th>cat_id</th>
            <th>comment</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${costs.costList}" var="cost">
            <c:out value="${cost.comment}"/>
        <br>
                    </tbody>
        </c:forEach>
    </table>
</petclinic:layout>

