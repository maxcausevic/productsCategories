<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
</head>
<body>
<h1>Welcome to Categories</h1>

<h1>${category.name}</h1>
<ul><c:forEach items="${products}" var="product">
<li>${product.name}</li>
</c:forEach>
</ul>
<h2>Add a Product</h2>

<form method="POST" action="/categories/addProduct/${category.id}">

		
  		<select name="productId" id="product">
  		<c:forEach items="${allProducts}" var="product">
    	<option value="${product.id}">
    	
    	<c:out value="${product.name}"/>
    	
    	</option>
    	</c:forEach>
   		</select>
  <input type="submit" value="Add product">
</form>                
</body>
</html>