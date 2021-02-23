<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Bootstrap -->
	<link href="../../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<!-- CSS -->
	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
<title>Se Connecter | ENI Enchere</title>
</head>
<body>
	<section id="login">
		<div class="container">
			<form method="post" action="Login">
				<input type="text" id="username" name="identifiant" placeholder="Identifiant">
				<input type="password" id="password" name="mdp" placeholder="Mot De Passe">
				<div class="row">
					<div class="col-md-6">
						<button type="submit" class="btn btn-primary" id="btn-connexion">Connexion</button>
					</div>
					<div class="col-md-6">
						<input type="checkbox">
						  Se souvenir de moi
						<a href="#">Mot de passe oublier</a>
					</div>
					<p>${ErrorsId}</p>
				</div>
			</form>
			<form method="get" action="Inscription">
				<button type="submit" class="btn btn-primary btn-lg " id="btn-newAccount">Créer un compte</button>
			</form>
		</div>
	</section> 
</body>
</html>