<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>Edit Book</h1>
	<form:form action="/book/${book.id}" method="post" modelAttribute="book">
		
		<input type="hidden" name="_method" value="put">
		<p>
			<form:label path="title">Title</form:label>
			<form:errors path="title" />
			<form:input path="title" />
		</p>
		<p>
			<form:label path="description"></form:label>
			<form:errors path="description" />
			<form:textarea path="description"/>
		</p>

		<p>
			<form:label path="language"></form:label>
			<form:errors path="language" />
			<form:textarea path="language"/>
		</p>
		
		<p>
			<form:label path="numberOfPages"></form:label>
			<form:errors path="numberOfPages" />
			<form:textarea path="numberOfPages"/>
		</p>
		<input type="submit" value="Submit" />	
		
	</form:form>
</body>
</html>