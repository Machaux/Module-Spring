<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1><spring:message code="Welcome"></spring:message></h1>
	
	<span style="float:right">
	<a href="?language=fr">fr</a>
	<a href="?language=en">en</a>
	</span>
	
	<!-- compte.getOwner()  ID -->
			<div>Id Client : ${client.getId()}</div>
			<div><spring:message code="Name"/> : ${client.getNom()}</div>
			<div><spring:message code="FirstName"/> : ${client.getPrenom()}</div>
	
	<!-- virement form -->
	
	<form:form method="post" action="/BankonetSpringMVC/${client.getId()}/effectuerVirement/" modelAttribute="virement">
 
    	<table>
     				    
		    <tr>
		        <td><form:label path="compteSource">Compte Source:</form:label></td>
		        <td><form:input path="compteSource" /></td>
		        <!-- Show errors for compteSource field -->
		        <td><form:errors path="compteSource"  /></td>
		    </tr>
		    <tr>
		        <td><form:label path="montant">Montant:</form:label></td>
		        <td><form:input path="montant" /></td>
		        <!-- Show errors for montant field -->
		        <td><form:errors path="montant"  /></td>
		    </tr>
		    <tr>
		        <td><form:label path="compteDestination">Compte Destinataire:</form:label></td>
		        <td><form:input path="compteDestination" /></td>
		        <!-- Show errors for compteDestination field -->
		        <td><form:errors path="compteDestination"  /></td>
		    </tr>
		    
		     <tr>
		        <td><form:button name="submit"><spring:message code="Save"></spring:message></form:button></td>
		    </tr>
	    </table>
    </form:form>
	
	
	
	<!-- Liste des comptes (courant & épargne) -->
	
	<table border="1">
		<tr>
		
		</tr>
		
		<tr>
			<td>ID</td>
			<td>libelle</td>
			<td>solde</td>
			<td>type</td>
			<td>découvert autorisé</td>
			<td>taux d'intérêt</td>
			<td>plafond</td>
		</tr>
	
		<c:forEach items="${comptescourant}" var="compte">
			<tr>
				<td>${compte.getIdentifiant()}</td>
				<td>${compte.getLibelle()}</td>
				<td>${compte.getSolde()}</td>
				<td>Compte Courant</td>
				<td>${compte.getDecouvertAutorise()}</td>
				<td>N/A</td>
				<td>N/A</td>
				<td><a href="/BankonetSpringMVC/${client.getId()}/deleteCompte/${compte.getIdentifiant()}">delete</a></td>
				<td><a href="/BankonetSpringMVC/${client.getId()}/editerCompte/${compte.getIdentifiant()}">edit</a></td>

			</tr>
		</c:forEach>
		
		<c:forEach items="${comptesepargne}" var="compte">
			<tr>
				<td>${compte.getIdentifiant()}</td>
				<td>${compte.getLibelle()}</td>
				<td>${compte.getSolde()}</td>
				<td>Compte Epargne</td>
				<td>N/A</td>
			 	<td>${compte.getPlafond()}</td>
				<td>${compte.getTauxInteret()}</td>
				<td><a href="">delete</a></td>
				<td><a href="">edit</a></td>

			</tr>
		
		</c:forEach>
		
	</table>

</body>
</html>