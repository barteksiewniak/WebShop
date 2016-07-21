<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of products</title>
</head>
<body>
<h3>List of products</h3>
<c:if test="${!empty listOfProducts}">
    <table class="tg">
        <tr>
            <th width="120">Product Name</th>
            <th width="120">Unit Price</th>
            <th width="60">Category</th>
        </tr>
        <c:forEach items="${listOfProducts}" var="product">
            <tr>
                <td>${product.productName}</td>
                <td>${product.unitPrice}</td>
                <td>${product.category}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
