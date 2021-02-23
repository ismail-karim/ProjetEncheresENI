<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link href="${pageContext.request.contextPath}/css/pageAddArticleStyle.css" rel="stylesheet" type="text/css">
<!-- BOOTSTRAP -->
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Nouvelle vente</title>
</head>

<body>
	<%@include file="hedaerLog.html" %>

	<section id="addArticle">
		<div class="container">
			<div class="row">
				<div class="col-md-3"> 
					<img src="${pageContext.request.contextPath}/img/ordinateur.jpg" class="card-img" alt="...">
				</div>
				<div class="col-md-9">
					<form action="AddArticle" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<div class="form-group row">
								<label for="article" class="col-sm-5 col-form-label">Article</label>
								<div class="col-sm-7">
						      		<input type="text" class="form-control" id="inputEmail3" name="articleName" placeholder="Nom de l'article">
						    	</div>
							</div>
							<div class="form-group row">
								<label for="description" class="col-sm-5 col-form-label">Description</label>
								<div class="col-sm-7">
						      		<textarea rows="5" cols="50" name="description" class="form-control">Description de l'article</textarea>
						    	</div>
							</div>
							<div class="form-group row">
								<label for="categories" class="col-sm-5 col-form-label">Categories</label>
								<div class="col-sm-7">
						      		<select class="form-control" id="categorie" name="categories">
							      		<c:forEach items="${listeCategorie }" var="cat">
							      			<option value="${cat.noCategorie}">${cat.libelle}</option>
						      			</c:forEach>
						      		</select>
						    	</div>
							</div>
							<div class="form-group row">
								<label for="image" class="col-sm-5 col-form-label">Photo</label>
								<div class="col-sm-7">
						      		<input type="file" class="form-control-file" id="imageArticle" name="image">
						    	</div>
							</div>
							<div class="form-group row">
								<label for="image" class="col-sm-5 col-form-label">Mise à prix</label>
								<div class="col-sm-7">
						      		<select class="form-control custom-select" id="selectPrice" name="miseAPrix">
						      			<option selected>Prix</option>
						      			<option value="1"> 100</option>
						      			<option value="2">150</option>
						      			<option value="3">200</option>
						      		</select>
						    	</div>
							</div>
							<div class="form-group row">
								<label for="debutEnchere" class="col-sm-5 col-form-label">Date début Enchère</label>
								<div class="col-sm-7">
						      		<input type="date" class="form-control" id="dateDebutEnchere" name="dateDebut">
						    	</div>
							</div>
							<div class="form-group row">
								<label for="finEnchere" class="col-sm-5 col-form-label">Date fin Enchère</label>
								<div class="col-sm-7">
						      		<input type="date" class="form-control" id="finEnchere" name="dateFin">
						    	</div>
							</div>
							<div id="retrait">
							<h5>Retrait :</h5>
								<div class="form-group row">
								<label for="Rue" class="col-sm-5 col-form-label">Rue</label>
								<div class="col-sm-7">
						      		<input type="text" class="form-control" id="rue" name="rue" value="${user.getRue() }">
						    	</div>
							</div>
							<div class="form-group row">
								<label for="codePostal" class="col-sm-5 col-form-label">Code postal</label>
								<div class="col-sm-7">
						      		<input type="text" class="form-control" id="codePostal" name="codePostal" value="${user.getCodePostal() }">
						    	</div>
							</div>
							<div class="form-group row">
								<label for="ville" class="col-sm-5 col-form-label">ville</label>
								<div class="col-sm-7">
						      		<input type="text" class="form-control" id="ville" name="ville" value="${user.getVille() }">
						    	</div>
							</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-4">
								<button type="submit" class="btn btn-success btn-lg">Enregistrer</button>
							</div>
							<div class="col-sm-4">
								<button type="reset" class="btn btn-warning btn-lg">Annuler</button>
							</div>
							<div class="col-sm-4">
								<button type="reset" class="btn btn-danger btn-lg">Annuler la vente</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

</body>
</html>