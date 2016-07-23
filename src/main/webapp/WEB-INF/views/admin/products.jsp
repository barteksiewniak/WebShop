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

    <form:form role="form" method="post" modelAttribute="product">
        <%-- <form:errors path="*" cssClass="error" /> --%>
        <table>
            <tr>
                <div class="form-group">
                    <td><spring:message code="lbl.name" text="lbl.pname"/></td>
                    <td><form:input class="form-control" path="productName"/></td>
                    <td><form:errors path="productName" cssClass="error"/></td>
                </div>
            </tr>
            <tr>
                <div class="form-group">
                    <td><spring:message code="lbl.price" text="lbl.pprice"/></td>
                    <td><form:input class="form-control" path="unitPrice"/></td>
                    <td><form:errors path="unitPrice" cssClass="error"/></td>
                </div>
            </tr>
            <tr>
                <div class="form-group">
                    <td><spring:message code="lbl.category" text="lbl.pcategory"/></td>
                    <td><form:select path="category" items="${categoryList}" itemValue="id"
                                     class="form-control" itemLabel="categoryName"/></td>
                    <td><form:errors path="category" cssClass="error"/></td>
                </div>
            </tr>
            <tr>
                <td><form:button class="btn btn-success" type="submit" value="Add Product">Add</form:button></td>
            </tr>
        </table>
    </form:form>

    <button class="btn btn-success" href="<c:url value="admin/products/create"/>" type="submit">+</button>
    <c:if test="${!empty listOfProducts}">
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
            <tbody>
            <c:forEach items="${listOfProducts}" var="product">
                <tr>
                    <td class="col-md-1">${product.id}</td>
                    <td class="col-md-4">${product.productName}</td>
                    <td class="col-md-1">${product.unitPrice}</td>
                    <td class="col-md-4">${product.category.categoryName}</td>
                    <td class="col-md-2">
                        <button class="btn btn-default" href="<c:url value="admin/products/${product.id}/edit"/>"
                                type="submit">Edit
                        </button>
                        <a href="<c:url value="/admin/products/${product.id}/remove"/>">
                            <button class="btn btn-danger" type="submit">Delete
                            </button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>

</body>
</html>
