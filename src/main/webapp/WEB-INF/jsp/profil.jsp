<%@ page import="fr.eni.projetencheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/utilisateur.css">
<title>Mon profil</title>
</head>
<body>
	<%
	Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
	%>
	<div class="container">

		<nav class="navbar navbar-light bg-light justify-content-between">
			<h1>ENI-ENCHERES</h1>
		</nav>

		<main>
			Bonjour ${user.pseudo}

			<div name="first-btn">
				<a href="<%=request.getContextPath()%>/modification-profil ">
					<button type="button" class="btn btn-primary">Modifier</button>
				</a> <a href="/accueilconnecte">
					<button type="button" class="btn btn-secondary">Annuler</button>
				</a>
			</div>

		</main>


	</div>



	<!-- 		<div class="container">
			<p>
				Nom :
			
				 </p>
			<p>
				Prenom :
				<%=request.getAttribute("prenom")%></p>
			<p>
				Email :
				<%=request.getAttribute("email")%></p>
			<p>
				Téléphone :
				<%=request.getAttribute("telephone")%></p>
			<p>
				Rue :
				<%=request.getAttribute("rue")%></p>
			<p>
				Code postal :
				<%=request.getAttribute("codePostal")%></p>
			<p>
				Ville :
				<%=request.getAttribute("ville")%></p>
		</div> -->



</body>
</html>