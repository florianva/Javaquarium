<%@page import="com.javaquarium.action.AjoutEspeceAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout d'une nouvelle espèce</title>
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">

</head>
<body>
	<center>
		<form class="pure-form pure-form-aligned" action="/Javaquarium/ajoutEspece.do" method="post">
    <fieldset>
        <div class="pure-control-group">
            <label for="name">Nom</label>
            <input id="nom" type="text" placeholder="Nom" name="nom">
        </div>
        <div class="pure-control-group">
            <label for="name">Description</label>
            <textarea id="description" type="text" placeholder="Description" name="description"></textarea>
        </div>
        <div class="pure-control-group">
            <label for="name">Couleur</label>
            <input id="couleur" type="text" placeholder="Couleur" name="couleur">
        </div>
        <div class="pure-control-group">
            <label for="name">Prix</label>
            <input id="prix" type="text" placeholder="Prix" name="prix">
        </div>

        <div class="pure-control-group">
            <label for="password">Dimension(Lxl)</label>
            <input id="dimension" type="text" placeholder="Dimension" name = "dimension">
        </div>
		<div>
            <button type="submit" class="pure-button pure-button-primary">Submit</button>
            <button type="reset" class="pure-button pure-button-primary">Reset</button>
        </div>
    </fieldset>
</form>
	</center>
	<a href="/Javaquarium/jsp/UC01_especes.jsp"> <bean:message key="retour.lien.poisson" /></a>
</body>
</html>