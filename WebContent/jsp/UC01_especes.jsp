<%@page import="com.javaquarium.action.ListerEspeceAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bean:message key="message.bienvenue" /></title>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">
</head>
<body>
	<h1>
		<bean:message key="message.bienvenue" />
		<bean:write name = "loginForm" property = "user" />
	</h1>

	<table class="pure-table">
		<thead>
			<tr>
				<th><bean:message key="tableau.nom" /></th>
				<th><bean:message key="tableau.description" /></th>
				<th><bean:message key="tableau.couleur" /></th>
				<th><bean:message key="tableau.dimension" /></th>
				<th><bean:message key="tableau.prix" /></th>
				<th><bean:message key="tableau.detail" /></th>
				<th><bean:message key="tableau.monaquarium" /></th>
			</tr>
		</thead>

		<tbody>
			<logic:iterate name="<%= ListerEspeceAction.SESSION_LIST_POISSON %>"
				id="MonPoisson">
				<tr>

					<td><bean:write name="MonPoisson" property="nom" /></td>
					<td><bean:write name="MonPoisson" property="description" /></td>
					<td><bean:write name="MonPoisson" property="couleur" /></td>
					<td><bean:write name="MonPoisson" property="dimension" /></td>
					<td><bean:write name="MonPoisson" property="prix" /></td>
					<td><a href=""> <bean:message key="tableau.lien.details" />
					</a></td>
					<td><a href=""> <bean:message key="tableau.lien.ajouter" />
					</a> <a href=""> <bean:message key="tableau.lien.retirer" />
					</a></td>

				</tr>
			</logic:iterate>
		</tbody>
	</table>
	
	<a href="/Javaquarium/jsp/UC03_ajout.jsp"> <bean:message key="ajouter.lien.poisson" /></a>
	
	
</body>
</html>