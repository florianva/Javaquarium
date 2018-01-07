<%@page import="com.javaquarium.action.AjoutUserAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="register.title" /></title>
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">

</head>
<body>

	<center>
		<div style="color:red">
			<html:errors/>
		</div>
		<form class="pure-form pure-form-aligned" action="/Javaquarium/ajoutUser.do" method="post">
    <fieldset>
        <div class="pure-control-group">
            <label for="name"><bean:message key="login.username" /></label>
            <input id="name" type="text" placeholder="Username" name="user" required>
        </div>

        <div class="pure-control-group">
            <label for="password"><bean:message key="login.password" /></label>
            <input id="password" type="password" placeholder="Password" name = "password" required>
        </div>
        
		<div>
            <button type="submit" class="pure-button pure-button-primary"><bean:message key="login.submit" /></button>
            <button type="reset" class="pure-button pure-button-primary"><bean:message key="login.reset" /></button> 
        </div>
    </fieldset>
</form>
	</center>
	<a href="/Javaquarium/jsp/UC00_login.jsp"> <bean:message key="retour.lien.login" /></a>
</body>
</html>