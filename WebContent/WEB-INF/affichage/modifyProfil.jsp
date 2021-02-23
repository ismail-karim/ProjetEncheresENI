<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="${pageContext.request.contextPath}/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="${pageContext.request.contextPath}/vendor/css/main.css" rel="stylesheet" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Modifier Votre Profil</h2>
                </div>
                <div class="card-body">
                    <form method="POST" action="ModifierProfil" >
                    	<input type="hidden" name="idUser" value="${user.getNoUtilisateur() }">
                    	<div class="form-row">
                            <div class="name">Pseudo</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="pseudoUpdate" value="${user.getPseudo() }">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Nom</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="nomUpdate" value="${user.getNom() }">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Prenom</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="prenomUpdate" value="${user.getPrenom() }">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Email</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="email" name="emailUpdate" value="${user.getEmail() }">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Téléphone</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="tel" name="telephoneUpdate" value="${user.getTelephone() }">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Rue</div>
                            <div class="value">
                                <div class="input-group">
                                	<div class="input-group">
                                    <input class="input--style-5" type="text" name="rueUpdate" value="${user.getRue() }">
                                </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Code Postal</div>
                            <div class="value">
                                <div class="input-group">
                                	<div class="input-group">
                                    <input class="input--style-5" type="text" name="code_postalUpdate" value="${user.getCodePostal() }">
                                </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Ville</div>
                            <div class="value">
                                <div class="input-group">
                                	<div class="input-group">
                                    <input class="input--style-5" type="text" name="villeUpdate" value="${user.getVille() }">
                                </div>
                                </div>
                            </div>
                        </div>
                        <div>
                            <button class="btn btn--radius-2 btn--green" name="UPDATE_BTN" value="UPDATE" type="submit">Enregistre</button>
                            <button class="btn btn--radius-2 btn--red"  name="DELETE_BTN" value="DELETE" type="submit">Supprimer mon compte</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="${pageContext.request.contextPath}/vendor/select2/select2.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/datepicker/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="${pageContext.request.contextPath}/vendor/js/global.js"></script>
</body>
</html>