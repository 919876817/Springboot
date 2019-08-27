<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>人员信息</title></head>
<body>
<table border="1" align="center" width="50%">
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Department</th>
    </tr>
    <c:forEach items="${client}" var="user">
        <tr align="center">
            <td>${user.usercode }</td>
            <td>${user.username }</td>
            <td>${user.department }</td>
        </tr>
    </c:forEach></table>
</body>
</html>
