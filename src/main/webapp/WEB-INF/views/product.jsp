<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h3>Product details</h3>
    <table class="tg">
        <tr>
            <th width="120">Product Name</th>
            <th width="120">Unit Price</th>
            <th width="60">Category</th>
        </tr>
            <tr>
                <td>${product.productName}</td>
                <td>${product.unitPrice}</td>
                <td>${product.category.categoryName}</td>
            </tr>
    </table>
</body>
</html>
