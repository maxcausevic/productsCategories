<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Category</title>
</head>
<body>
<p><form:errors path="category.*"/></p>
    
    <form:form method="POST" action="/addCategory/new" modelAttribute="category">
        <p>
            <form:label path="name">Name:</form:label>
            <form:input type="name" path="name"/>
        </p>
       
        <input type="submit" value="Add Category!"/>
    </form:form> 
</body>
</html>