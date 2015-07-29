<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>

<html>
<head>
	<title>
		<spring:message code="label.title"></spring:message>
	</title>
</head>
<body>
<h1>
	<spring:message code="label.hello"></spring:message>  
</h1>

<span style="float:right">
	<a href="?language=fr">fr</a>
	<a href="?language=en">en</a>
</span>

<P>
	<spring:message code="label.timeOnServer"></spring:message>
	${serverTime}. 
</P>

</body>
</html>
