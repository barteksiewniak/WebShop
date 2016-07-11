<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Add User Form</title>
    <style>
        .error {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>

<body>
<h2><spring:message code="lbl.page" text="Add New User"/></h2>
<br/>
<form:form method="post" modelAttribute="user">
    <%-- <form:errors path="*" cssClass="error" /> --%>
    <table>
        <tr>
            <td><spring:message code="lbl.ssoId" text="Login"/></td>
            <td><form:input path="ssoId"/></td>
            <td><form:errors path="ssoId" cssClass="error"/></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.password" text="Password"/></td>
            <td><form:input path="password"/></td>
            <td><form:errors path="password" cssClass="error"/></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.firstName" text="First Name"/></td>
            <td><form:input path="firstName"/></td>
            <td><form:errors path="firstName" cssClass="error"/></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.lastName" text="Last Name"/></td>
            <td><form:input path="lastName"/></td>
            <td><form:errors path="lastName" cssClass="error"/></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.email" text="Email"/></td>
            <td><form:input path="email"/></td>
            <td><form:errors path="email" cssClass="error"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Add User"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>