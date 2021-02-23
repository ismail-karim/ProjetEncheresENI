<!DOCTYPE html>
<%@page import="fr.eni.projetencherseni.bll.UtilisateurManager"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- BOOTSTRAP -->
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Profil ${user.getPrenom() }</title>
</head>
<body>
	<%@include file="hedaerLog.html" %>
		
	<section id="showProfil">
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<div class="row">
					<div class="col-md-5">
						<h6>Pseudo</h6>
					</div>
					<div class="col-md-5">
						${user.getPseudo()}
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<h6>Nom</h6>
					</div>
					<div class="col-md-5">
					${user.getNom() }
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<h6>Prénom</h6>
					</div>
					<div class="col-md-5">
						${user.getPrenom() }
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<h6>Email</h6>
					</div>
					<div class="col-md-5">
						${user.getEmail()}
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<h6>Téléphone</h6>
					</div>
					<div class="col-md-5">
						${user.getTelephone() }
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<h6>Rue</h6>
					</div>
					<div class="col-md-5">
						${user.getRue() }
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<h6>Code Postal</h6>
					</div>
					<div class="col-md-5">
						${user.getCodePostal() }
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<h6>Ville</h6>
					</div>
					<div class="col-md-5">
						${user.getVille() }
					</div>
				</div>
				<form method="get" action="ModifierProfil">
					<button type="submit" class="btn btn-success btn-lg">Modifier</button>
				</form>
				
			</div>
		</div>
	</section>
</body>
</html>