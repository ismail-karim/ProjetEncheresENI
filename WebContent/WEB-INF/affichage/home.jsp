<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="fr.eni.projetencherseni.bo.ArticlesVendu" %>
<%@page import="java.util.List" %>
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
    		<a class="navbar-brand" href="Acceuil"><img alt="logo" height="100px" src="${pageContext.request.contextPath}/img/logoEniEncheres.png"></a>
    		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
		      	aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      	<span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav ml-auto">
		        <li class="nav-item active">
		          <a class="nav-link" href="Acceuil">Enchères <span class="sr-only">(current)</span></a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="AddArticle">Vendre un article</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="AfficherUser">Mon profil</a>
		        </li>
		        <li class="nav-item">
		        	<form action="Logout" method="post">
		        		<button type="submit" class="btn btn-primary">Déconnection</button>
		        	</form>
		          
		        </li>
		      </ul>
		      <ul class="navbar-nav nav-flex-icons">
		        <li class="nav-item">
		          <a class="nav-link"><i class="fab fa-facebook-f"></i></a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link"><i class="fab fa-twitter"></i></a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link"><i class="fab fa-instagram"></i></a>
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
			<form method="post" action="RechercherArticle">
				<div class="row">
					<div class="col-md-5">
						<div class="form-group">
						    <label for="exampleFormControlInput1">Filtres</label>
						    <input type="text" class="form-control" id="nomArticle" name="nomArticle" placeholder="Le nom de l'article contient">
						  </div>
						  <div class="form-group">
						    <label for="categorie">Catégorie:</label>
						    <select  class="form-control" id="categorie" name="categories">
						      <option selected="selected" value="-1">--------------------</option>
						      <c:forEach items="${listeCategorie }" var="cat">
							      <option value="${cat.noCategorie}">${cat.libelle}</option>
						      </c:forEach>
						    </select>
						  </div>
						  <div class="row">
						  	<div class="col-md-6">
						  		<input type="radio"> Achats
						  		<div id="ck-box-achat">
						  			<input type="checkbox"> Enchère ouvertes<br>
						  			<input type="checkbox"> mes enchères en cours<br>
						  			<input type="checkbox"> mes enchères remportées<br>
						  		</div>
						  	</div>
						  	<div class="col-md-6">
						  		<input type="radio"> Mes ventes
						  		<div id="ck-box-vente">
						  			<input type="checkbox"> Mes ventes en cours <br>
						  			<input type="checkbox"> ventes non débutées<br>
						  			<input type="checkbox"> ventes terminées<br>
						  		</div>
						  	</div>
						  </div>
					</div>
					<div class="col-md-3">
						<button type="submit" class="btn btn-secondary btn-lg" id="btn-bg" value="recherche">Recherhce</button>
					</div>
					<c:if test="${!empty sessionScope.user.getPseudo() }">
						<aside id="aside-user"> <p> ${sessionScope.user.getPseudo()} est <br> connecté(e)</p>
								<button type="submit" class="btn btn-success" value="showProfil">Mon profil</button>
						</aside>
					</c:if>
				</div>
			</form>
			<div class="col-md-2">
					
					</div>
		</div>
	</section>
	<section id="listeEnchere">
		<div class="container-md">
		
			<div class="row">
			<c:forEach var="article" items="${searchArticle}">
				<div class="col-md-5">
					<div class="card mb-3" style="max-width: 540px;">
					  <div class="row no-gutters">
					    <div class="col-md-4">
					      <img src="${pageContext.request.contextPath}/img/${article.nomImage}" class="card-img" alt="...">
					    </div>
					    
					    	 
					    <div class="col-md-8">
					      <div class="card-body">
					     
					        <h5 class="card-title">${article.nomArticle }</h5>
					        <p class="card-text">Prix : <!-- article.getPrixVente()  --> ${article.prixVente} €</p>
					        <p class="card-text">Fin de l'enchère : <!-- article.getDateFinEncheres() %> --> ${article.dateFinEncheres }</p>
					       
					        <br>
					        <button type="button" class="btn btn-info">Vendeur</button>
					      </div>
					    </div>
					    
					  </div>
					  
					</div>
				</div>
				 </c:forEach>
				
<!-- 				<div class="col-md-5"> -->
<!-- 					<div class="card mb-3" style="max-width: 540px;"> -->
<!-- 					  <div class="row no-gutters"> -->
<!-- 					    <div class="col-md-4"> -->
<%-- 					      <img src="${pageContext.request.contextPath}/img/ordinateur.jpg" class="card-img" alt="..."> --%>
<!-- 					    </div> -->
<!-- 					    <div class="col-md-8"> -->
<!-- 					      <div class="card-body"> -->
<!-- 					        <h5 class="card-title">Nom de l'article</h5> -->
<!-- 					        <p class="card-text">Prix : 310 points</p> -->
<!-- 					        <p class="card-text">Fin de l'enchère : Date de fin</p> -->
<!-- 					        <br> -->
<!-- 					        <button type="button" class="btn btn-info">Vendeur</button> -->
<!-- 					      </div> -->
<!-- 					    </div> -->
<!-- 					  </div> -->
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
			
		</div>
	</section>
</body>
</html>