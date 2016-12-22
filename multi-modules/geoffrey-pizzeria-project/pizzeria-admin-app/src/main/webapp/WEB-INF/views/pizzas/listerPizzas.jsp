<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="fr.pizzeria.model.Pizza" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TITRE_TEST_DT</title>
</head>
<body>

<table>

 

<c:forEach var="pizza" items="${Pizzas}">

	<tr>
		<td> ${pizza.id} </td>
		<td><dd> ${pizza.code} </td>
		<td><dd> ${pizza.nom}</td>
		<td><dd> ${pizza.prix}</td>
		<td><dd> ${pizza.cat} </td>
		<td><dd> <img alt="photo_reine" title="reine" src="#" /> </td>
		
		<td><button type="button" class="btn btn-secondary">Modifier</button></td>
        <td><button type="button" class="btn btn-secondary">Supprimer</button></td>
	</tr>

</c:forEach>


</table>

</body>
</html>