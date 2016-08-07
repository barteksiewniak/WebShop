<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value='/static/css/bootstrap.css'/>" rel="stylesheet"/>
    <link rel="stylesheet" href="<c:url value='/static/css/bootstrap-select.min.css'/>">
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
            <c:choose>
                <c:when test="${product.id==IdOfProductToEdit}">

                    <form:form id="edit" role="form" method="post" modelAttribute="product">
                        <tr>
                            <td class="col-md-1"><form:input class="form-control" path="id" value="${product.id}"
                                                             disabled="true"/></td>
                            <td class="col-md-4">
                                <spring:bind path="productName">
                                    <div class="${status.error ? 'has-error' : ''}">
                                        <form:input class="form-control" path="productName"
                                                    value="${product.productName}"
                                                    required="required"/>
                                    </div>
                                </spring:bind>
                            </td>

                            <td class="col-md-1">
                                <spring:bind path="unitPrice">
                                    <div class="${status.error ? 'has-error' : ''}">
                                        <form:input cssClass="form-control" path="unitPrice"
                                                    value="${product.unitPrice}"
                                                    required="required"/>
                                    </div>
                                </spring:bind>
                            </td>
                            <td class="col-md-4">
                                <spring:bind path="category">
                                    <select class="form-control" name="category">
                                        <c:forEach items='${listOfCategories}' var='currentCategory'>
                                            <c:choose>
                                                <c:when test="${currentCategory.id eq product.category.id}">
                                                    <option value="${currentCategory.categoryName}"
                                                            selected="true">${currentCategory.categoryName}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${currentCategory.categoryName}">${currentCategory.categoryName}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </spring:bind>
                            </td>

                            <td class="col-md-2">
                                <button form="edit" class="btn btn-success" type="submit">Update</button>
                                <a href="/admin/products" class="btn btn-warning">Cancel</a>
                            </td>
                        </tr>
                    </form:form>
                </c:when>
                <c:otherwise>

                    <tr>
                        <td class="col-md-1">${product.id}</td>
                        <td class="col-md-4">${product.productName}</td>
                        <td class="col-md-1">${product.unitPrice}</td>
                        <td class="col-md-4">${product.category.categoryName}</td>
                        <td class="col-md-2">
                            <a href="<c:url value="/admin/products/edit/${product.id}"/>">
                                <button class="btn btn-info" type="button">Edit
                                </button>
                            </a>
                            <a href="<c:url value="/admin/products/remove/${product.id}"/>">
                                <button class="btn btn-danger" type="button">Delete
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        </c:if>

        <c:if test="${showAddNewProductModule}">

            <spring:message code="lbl.name" var="productName"/>
            <spring:message code="lbl.price" var="productPrice"/>
            <spring:message code="lbl.id" var="productId"/>

            <form:form id="add" role="form" method="post" modelAttribute="product">
                <tr>
                    <td class="col-md-1"><input id="id" class="form-control" placeholder="${productId}" disabled/></td>
                    <td class="col-md-4">
                        <spring:bind path="productName">
                            <div class="${status.error ? 'has-error' : ''}">
                                <form:input id="productName" class="form-control" path="productName"
                                            placeholder="${productName}"
                                            required="required"/>
                            </div>
                        </spring:bind>
                    </td>

                    <td class="col-md-1">
                        <spring:bind path="unitPrice">
                            <div class="${status.error ? 'has-error' : ''}">
                                <form:input id="unitPrice" cssClass="form-control" path="unitPrice"
                                            placeholder="${productPrice}"
                                            required="required"/>
                            </div>
                        </spring:bind>
                    </td>

                    <td class="col-md-3">
                        <spring:bind path="category">
                            <div class="${status.error ? 'has-error' : ''}">
                                <select class="selectpicker form-control show-tick" name="category"
                                        data-live-search="true" title="Choose category.." form="add">
                                    <option value="divider" data-divider="true"></option>
                                    <c:forEach items="${listOfCategories}" var="category">
                                        <option>${category.categoryName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </spring:bind>
                    </td>

                    <td class="col-md-3">
                        <button id="addProductButton" form="add" class="btn btn-success" type="submit">+</button>
                    </td>
                </tr>
            </form:form>
        </c:if>
        </tbody>
    </table>
</div>

<script src="<c:url value="/static/js/jquery-3.1.0.min.js"/>"></script>
<script src="<c:url value="/static/js/bootstrap-select.min.js"/>"></script>
<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
<script>
    var categorySelect = $(".selectpicker");
    var addProductButton = $("#addProductButton");

    categorySelect.selectpicker();
    $(".bs-searchbox").append('<div id="searchOrAdd"  class = "input-group"><span class = "input-group-btn"><button id="addCategoryButton" class ="btn btn-success" type ="button">+</button></span></div>');
    var newCategoryInput = $(".bs-searchbox input").detach().prependTo("#searchOrAdd");

    $("#addCategoryButton").click(function () {
        var input = newCategoryInput.val();
        $.ajax({
            url: "/admin/category/add",
            type: 'GET',
            data: {"categoryName": input},
            dataType: "json",
            contentType: 'application/json',
            mimeType: 'application/json',
        });
        categorySelect.append("<option>" + input + "</option>")
                .selectpicker("refresh")
                .selectpicker("val", input);
    });
</script>
</body>
</html>
