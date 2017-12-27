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
	<style>
		.container{margin:auto;width:50%}
		.container table{width:100%; text-align:center;}
		.pure-table thead{text-align:center}
		td form{display: inline-block}
		.button-success,
        .button-error{
            color: white;
            border-radius: 4px;
            text-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
            width: 87px;
        }

        .button-success {
            background: rgb(28, 184, 65);
        }

        .button-error {
            background: rgb(202, 60, 60);
        }
        .pure-button-primary{ margin-top : 20px}

        
        </style>
</head>
<body>
	<div class="container">
		<h1>
			<bean:message key="message.bienvenue" />
			<%= session.getAttribute("user_name") %>
		</h1>
	
		<div class="pure-menu pure-menu-horizontal">
		    <ul class="pure-menu-list">
		        <li class="pure-menu-item"><a href="#" class="pure-menu-link"><bean:message key="menu.monaquarium" /> (<%= session.getAttribute("session_user_nb_poisson") %>)</a></li>
				 <li class='pure-menu-item pure-menu-disabled'>
					 <form action="/Javaquarium/viderAquarium.do" method="post">
					 	<input type="submit" value='<bean:message key="menu.vider" />'/>
					 </form>
				 </li>
				 
		    </ul>
		</div>
		
		<table class="pure-table">
			<thead>
				<tr>
					<th><bean:message key="tableau.nom" /></th>
					<th><bean:message key="tableau.description" /></th>
					<th><bean:message key="tableau.couleur" /></th>
					<th><bean:message key="tableau.dimension" /></th>
					<th><bean:message key="tableau.prix" /></th>
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
							<td>
							<form action="/Javaquarium/ajoutPoissonDansAquarium.do" method="post">
								<input type="hidden" name="nom" value='<bean:write name="MonPoisson" property="nom" />' />
								<input type="hidden" name="description" value='<bean:write name="MonPoisson" property="description" />' />
								<input type="hidden" name="couleur" value='<bean:write name="MonPoisson" property="couleur" />' />
								<input type="hidden" name="dimension" value='<bean:write name="MonPoisson" property="dimension" />' />
								<input type="hidden" name="prix" value='<bean:write name="MonPoisson" property="prix" />' />
								<input type="hidden" name="code" value='<bean:write name="MonPoisson" property="code" />' />
								<input type="submit" class="pure-button button-success" value='<bean:message key="tableau.lien.ajouter" />'/>
							</form>
							<form action="/Javaquarium/retirerPoissonDansAquarium.do" method="post">
								<input type="hidden" name="nom" value='<bean:write name="MonPoisson" property="nom" />' />
								<input type="hidden" name="description" value='<bean:write name="MonPoisson" property="description" />' />
								<input type="hidden" name="couleur" value='<bean:write name="MonPoisson" property="couleur" />' />
								<input type="hidden" name="dimension" value='<bean:write name="MonPoisson" property="dimension" />' />
								<input type="hidden" name="prix" value='<bean:write name="MonPoisson" property="prix" />' />
								<input type="hidden" name="code" value='<bean:write name="MonPoisson" property="code" />' />
								<input type="submit" class="button-error pure-button" value='<bean:message key="tableau.lien.retirer" />'/>
							</form>
							</td>
						
					</tr>
				</logic:iterate>
			</tbody>
		</table>
		
		<a href="/Javaquarium/jsp/UC03_ajout.jsp" class="pure-button pure-button-primary"> <bean:message key="ajouter.lien.poisson" /></a>
	</div>
	
</body>
</html>