<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value='/static/css/bootstrap.css'/>" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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
                        <form:select id="categorySelect" class="form-control" path="category" required="required">
                            <form:option value="placeholder" disabled="true" selected="true" hidden="true"
                                         title="Choose.." label="Choose category"/>
                            <form:options items="${listOfCategories}" itemValue="categoryName"
                                          itemLabel="categoryName"/>
                            <form:option id="addCategory" value="" label="Add category..."/>
                        </form:select>
                        <input id='categoryNameInput' type='text' style="display: none" class='form-control' placeholder='Type new category name..' required/>
                    </td>

                    <td class="col-md-3">
                        <button id="addProductButton" form="add" class="btn btn-success" type="submit">+</button>
                        <a id="addCategoryButton" style="display: none" href="<c:url value="/admin/category/add"/>">
                            <button class="btn btn-success" type="submit">Confirm</button>
                        </a>
                        <button id="cancelCategoryButton" style="display: none" class="btn btn-danger" type="submit">Cancel</button>
                    </td>
                </tr>
            </form:form>
        </c:if>
        </tbody>
    </table>
</div>

<script>
    var categorySelect = $("#categorySelect");
    var addProductButton = $("#addProductButton");
    var cancelCategoryButton = $("#cancelCategoryButton");
    var addCategoryButton = $("#addCategoryButton");
    var categoryNameInput = $("#categoryNameInput");

    categorySelect.change(function () {
        if ($(this).val() == '') {
            $(this).hide();
            $("input").prop("disabled", true);
            categoryNameInput.prop("disabled", false);
            categoryNameInput.show();
            addCategoryButton.show();
            cancelCategoryButton.show();
            addProductButton.hide();
        }
    });

    cancelCategoryButton.click(function () {
        $("input").prop("disabled", false);
        $("#id").prop("disabled", true);
        addCategoryButton.hide();
        cancelCategoryButton.hide();
        categoryNameInput.hide();
        categorySelect.val("placeholder");
        categorySelect.show();
        addProductButton.show();

    });

</script>
</body>
</html>
