<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>clientsview</title>
</head>
<body>

	<h1><spring:message code="Welcome"></spring:message></h1>
	
	<span style="float:right">
	<a href="?language=fr">fr</a>
	<a href="?language=en">en</a>
	</span>

	<!-- édition du client -->
	
	<h1><spring:message code="ClientEdition"></spring:message> </h1>

	<form:form method="post" action="/BankonetSpringMVC/saveClient" modelAttribute="client">
 
    	<table>
    	
    	
    		<tr>
				<td>ID client:<form:hidden path="id" /></td>
				<td>${client.getId()}</td>
			</tr>
    		
		    <tr>
		        <td><form:label path="nom"><spring:message code="Name"></spring:message></form:label></td>
		        <td><form:input path="nom" /></td>
		        <%-- Show errors for nom field --%>
		        <td><form:errors path="nom"  /></td>
		    </tr>
		    <tr>
		        <td><form:label path="prenom"><spring:message code="FirstName"></spring:message></form:label></td>
		        <td><form:input path="prenom" /></td>
		        <%-- Show errors for prenom field --%>
		        <td><form:errors path="prenom"  /></td>
		    </tr>
		    <tr>
		        <td><form:label path="login"><spring:message code="Login"></spring:message></form:label></td>
		        <td><form:input path="login" /></td>
		        <%-- Show errors for login field --%>
		        <td><form:errors path="login"  /></td>
		    </tr>
		    <tr>
		        <td><form:label path="motDePasse"><spring:message code="Password"></spring:message></form:label></td>
		        <td><form:input type="password" path="motDePasse" /></td>
		        <%-- Show errors for motDePasse field --%>
		        <td><form:errors path="motDePasse"  /></td>
		    </tr>
		    <tr>
		        <td><form:button name="submit"><spring:message code="Save"></spring:message></form:button></td>
		        
		    </tr>
		    
	    </table>
    </form:form>
	

	<br>
		${info}
	<br>

	<!-- listes des clients -->

	<table border="1">
		<tr>
			<td>ID</td>
			<td><spring:message code="Name"></spring:message></td>
			<td><spring:message code="FirstName"></spring:message></td>
			<td><spring:message code="Login"></spring:message></td>
			<td><spring:message code="Login"></spring:message></td>
		</tr>

		
		<c:forEach begin="1" end="${clients.size()}" var="i">
			<tr>
				<td>${clients.get(i-1).getId()}</td>
				<td>${clients.get(i-1).getNom()}</td>
				<td>${clients.get(i-1).getPrenom()}</td>
				<td>${clients.get(i-1).getLogin()}</td>
				<td>(confidentiel)</td>
				<td><a href="/BankonetSpringMVC/deleteClient?id=${clients.get(i-1).getId()}">delete</a></td>
				<td><a href="/BankonetSpringMVC/editClient/${clients.get(i-1).getId()}">edit</a></td>
				<td></td>	
			</tr>
		</c:forEach>
	</table>
	
	
	

</body>
</html>