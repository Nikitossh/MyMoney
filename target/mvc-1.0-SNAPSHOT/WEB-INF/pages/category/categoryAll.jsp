<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Costs</h2>

<table align="left" bgcolor="#a9a9a9" border="3px">
    <tr>
        <th>id</th>
        <th>category</th>
    </tr>
    <c:forEach items="${category.categoriesList}" var="category">
        <tr>
            <td><c:out value="${category.id}"/></td>
            <td><c:out value="${category.category}"/></td>
        </tr>
    </c:forEach>
</table>
