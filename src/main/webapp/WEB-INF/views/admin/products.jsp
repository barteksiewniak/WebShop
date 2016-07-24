<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        .error {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
    <link href="<c:url value='/static/css/bootstrap.css'/>" rel="stylesheet"/>
</head>
<body>
<div class="container">


    <table class="table table-hover">
        <thead>
        <tr>
            <th class="col-md-1">Id</th>
            <th class="col-md-4">Product</th>
            <th class="col-md-1">Price</th>
            <th class="col-md-4">Category</th>
            <th class="col-md-2"></th>
        </tr>
        </thead>
        <c:if test="${!empty listOfProducts}">
        <tbody>
        <c:forEach items="${listOfProducts}" var="product">
            <tr>
                <td class="col-md-1">${product.id}</td>
                <td class="col-md-4">${product.productName}</td>
                <td class="col-md-1">${product.unitPrice}</td>
                <td class="col-md-4">${product.category.categoryName}</td>
                <td class="col-md-2">
                    <a href="<c:url value="/admin/products/${product.id}/edit"/>">
                        <button class="btn btn-info" type="submit">Edit
                        </button>
                    </a>
                    <a href="<c:url value="/admin/products/${product.id}/remove"/>">
                        <button class="btn btn-danger" type="submit">Delete
                        </button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </c:if>
        <spring:message code="lbl.name" var="productName"/>
        <spring:message code="lbl.price" var="productPrice"/>
        <spring:message code="lbl.id" var="productId"/>
        <form:form role="form" method="post" modelAttribute="product">
            <tr>
                <td class="col-md-1"><form:input class="form-control" path="id" value="${productId}"
                                                 placeholder="${productId}" disabled="true"/></td>
                <td class="col-md-4"><form:input class="form-control" path="productName"
                                                 placeholder="${productName}"
                                                 required="required"/></td>
                <td class="col-md-1"><form:input class="form-control" path="unitPrice"
                                                 placeholder="${productPrice}"
                                                 required="required"/></td>
                <td class="col-md-4"><form:select class="form-control" path="category"
                                                  items="${categoryList}"
                                                  itemValue="categoryName"
                                                  itemLabel="categoryName"/></td>
                <td class="col-md-2">
                    <a href="<c:url value="/admin/products/create"/>">
                        <button class="btn btn-success" type="submit">+</button>
                    </a>
                </td>
            </tr>
        </form:form>
        </tbody>
    </table>

</div>
</body>
</html>
