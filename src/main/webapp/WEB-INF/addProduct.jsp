<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
  <p><form:errors path="product.*"/></p>
    
    <form:form method="POST" action="/addProduct/new" modelAttribute="product">
        <p>
            <form:label path="name">Name:</form:label>
            <form:input type="name" path="name"/>
        </p>
        <p>
            <form:label path="description">Description:</form:label>
            <form:textarea path="description"/>
        </p>
        <p>
            <form:label path="price">Price:</form:label>
            <form:input path="price"/>
        </p>
        <input type="submit" value="Add Product!"/>
    </form:form>
</body>
</html>