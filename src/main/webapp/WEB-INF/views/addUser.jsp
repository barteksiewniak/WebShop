<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Add User Form</title>
</head>

<body>
<h2><spring:message code="lbl.page" text="Add New User" /></h2>
<br/>
<form:form method="post" modelAttribute="user">
    <table>
        <tr>
            <td><spring:message code="lbl.ssoId" text="Login" /></td>
            <td><form:input path="ssoId" /></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.password" text="Password" /></td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.firstName" text="First Name" /></td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.lastName" text="Last Name" /></td>
            <td><form:input path="lastName" /></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.email" text="Email" /></td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add Employee"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>