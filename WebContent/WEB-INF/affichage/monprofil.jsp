<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/MEPaccueil.css" > 
<!-- BOOTSTRAP -->
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Page créer profil</title>
</head>
<body>

	 <%@include file="header.html" %> 
	
	<br><br><br>
	<h1 class="center" id="titre"> Inscription</h1>
		<form action="Inscription" method="post">
			<div class="centerprofil">
				<div>
					<label for="pseudo">Pseudo : </label>
					<input type="text" name="pseudo" id="pseudo">
				</div>
				<div>
					<label for="nom">Nom : </label>
					<input type="text" name="nom" id="nom">
				</div>
			</div>
			<br><br>
			<div class="centerprofil">
				<div>
					<label for="prenom">Prénom : </label>
					<input type="text" name="prenom" id="prenom">
				</div>
				<div>
					<label for="email">Email : </label>
					<input type="email" name="email" id="email">
				</div>
			</div>
			<br><br>
			<div class="centerprofil">
				<div>
					<label for="telephone">Téléphone : </label>
					<input type="tel" name="telephone" id="telephone">
				</div>
				<div>
					<label for="rue">Rue : </label>
					<input type="text" name="rue" id="rue">
				</div>
			</div>
			<br><br>
			<div class="centerprofil">
				<div>
					<label for="codepostal">Code Postal : </label>
					<input type="text" name="codepostal" id="codepostal">
				</div>
				<div>
					<label for="ville">Ville : </label>
					<input type="text" name="ville" id="ville">
				</div>
			</div>
			<br><br>
			<div class="centerprofil">
				<div>
					<label for="motdepasse">Mot de passe : </label>
					<input type="password" name="motdepasse" id="motdepasse">
				</div>
				<div>
					<label for="confirmation">Confirmation : </label>
					<input type="password" name="confirmation" id="confirmation">
				</div>
			</div>
			<br><br>
				<label for="erreursWithEL">${requestScope.Errors} </label>
			<div class="centerprofil">
				<button type="submit" class="btn btn-success">Créer</button>
				<button type="reset" class="btn btn-danger">Annuler</button>
			</div>
		</form>
</body>
</html>