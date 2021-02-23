<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link href="${pageContext.request.contextPath}/css/styleHome.css" rel="stylesheet" type="text/css">
<!-- BOOTSTRAP -->
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Bienvenu | ENI ENCHERE</title>
</head>
<body>
	<header>
		<nav id="menu" class="navbar fixed-top navbar-expand-lg navbar navbar-light" style="background-color: #e3f2fd; scrolling-navbar">
    		<a class="navbar-brand" href="#"><img alt="logo" height="100px" src="${pageContext.request.contextPath}/img/logoEniEncheres.png"></a>
    		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
		      	aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      	<span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav ml-auto">
		        <li class="nav-item active">
		          <a class="nav-link" href="#">S'inscrire <span class="sr-only">(current)</span></a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">Se connecter</a>
		        </li>
		      </ul>
		    </div>
		  </nav>
	</header>
	
	<section id="titre">
		<div class="container">
			<h1 id="grandTitre">Liste des enchères</h1>
		</div>
	</section>
	<section id="filtreEtRecherhce">
		<div class="container">
			<form>
				<div class="row">
					<div class="col-md-5">
						<div class="form-group">
						    <label for="exampleFormControlInput1">Filtres</label>
						    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="Le nom de l'article contient">
						  </div>
						  <div class="form-group">
						    <label for="exampleFormControlSelect1">Catégorie:</label>
						    <select class="form-control" id="exampleFormControlSelect1">
						      <option>Toutes</option>
						      <option>Informatique</option>
						      <option>Ameublement</option>
						      <option>Vêtements</option>
						      <option>Sport&Loisirs</option>
						    </select>
						  </div>
					</div>
					<div class="col-md-3">
						<button type="button" class="btn btn-secondary btn-lg" id="btn-bg">Recherhce</button>
					</div>
				</div>
			</form>
		</div>
	</section>
	<section id="listeEnchere">
		<div class="container-md">
			<div class="row">
				<div class="col-md-5">
					<div class="card mb-3" style="max-width: 540px;">
					  <div class="row no-gutters">
					    <div class="col-md-4">
					      <img src="${pageContext.request.contextPath}/img/ordinateur.jpg" class="card-img" alt="...">
					    </div>
					    <div class="col-md-8">
					      <div class="card-body">
					        <h5 class="card-title">Nom de l'article</h5>
					        <p class="card-text">Prix : 310 points</p>
					        <p class="card-text">Fin de l'enchère : Date de fin</p>
					        <br>
					        <p class="card-text"><small class="text-muted"><a href="#">Vendeur</a></small></p>
					      </div>
					    </div>
					  </div>
					</div>
				</div>
				<div class="col-md-5">
					<div class="card mb-3" style="max-width: 540px;">
					  <div class="row no-gutters">
					    <div class="col-md-4">
					      <img src="${pageContext.request.contextPath}/img/ordinateur.jpg" class="card-img" alt="...">
					    </div>
					    <div class="col-md-8">
					      <div class="card-body">
					        <h5 class="card-title">Nom de l'article</h5>
					        <p class="card-text">Prix : 310 points</p>
					        <p class="card-text">Fin de l'enchère : Date de fin</p>
					        <br>
					        <p class="card-text"><small class="text-muted"><a href="#">Vendeur</a></small></p>
					      </div>
					    </div>
					  </div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>