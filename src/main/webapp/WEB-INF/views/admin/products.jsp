<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value='/static/css/bootstrap.css'/>"  rel="stylesheet"/>
</head>
<body>
<div class="container">
    <c:if test="${!empty listOfProducts}">
        <table class="table table-hover">
            <thead>
            <tr>
                <th class="col-md-1">Id</th>
                <th class="col-md-4">Product</th>
                <th class="col-md-1">Price</th>
                <th class="col-md-4">Category</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listOfProducts}" var="product">
                <tr>
                    <td class="col-md-1">${product.id}</td>
                    <td class="col-md-4">${product.productName}</td>
                    <td class="col-md-1">${product.unitPrice}</td>
                    <td class="col-md-4">${product.category.categoryName}</td>
                    <td class="col-md-2">
                        <button class="btn btn-default" name="productID" value="${product.id}" type="submit">Edytuj</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>

</body>
</html>
