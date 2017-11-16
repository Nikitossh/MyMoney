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
