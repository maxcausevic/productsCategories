<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
<h1>Welcome to Products</h1>
<h1>${product.name}</h1>

<ul><c:forEach items="${categories}" var="category">
<li>${category.name}</li>
</c:forEach>
</ul>

<h2>Add a category</h2>
<form method="POST" action="/products/addCategory/${product.id}">

		
  		<select name="categoryId" id="category">
  		<c:forEach items="${allCategories}" var="category">
    	<option value="${category.id}">
    	
    	<c:out value="${category.name}"/>
    	
    	</option>
    	</c:forEach>
   		</select>
 <input type="submit" value="Add Category">
</form>                

</body>
</html>