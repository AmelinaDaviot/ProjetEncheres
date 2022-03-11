<%@page import="java.util.List"%>
<%@page import="fr.eni.projetencheres.bo.Article"%>
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
<title>Accueil</title>
</head>
<body>
	<div class="container">
		<header> </header>

		<nav class="navbar navbar-light bg-light justify-content-between">
			<a href="<%=request.getContextPath()%>/accueillir"
				class="text-dark text-decoration-none">
				<h1>ENI-ENCHERES</h1>
			</a>
			<form class="form-inline">
				<ul class="nav justify-content-end">
					<li class="nav-item"><a class="nav-link active"
						href="<%=request.getContextPath()%>/connexion">Connexion</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/inscription ">Inscription</a>
					</li>
				</ul>
			</form>
		</nav>

		<main>
			<h2>Liste des enchères</h2>
		</br>
			<h3>Filtres :</h3>
		</br>
			<div class="input-group">
				<input type="search" class="form-control rounded"
					placeholder="Search" aria-label="Search"
					aria-describedby="search-addon" />
				<button type="button" class="btn btn-outline-primary">search</button>
			</div>
		</br>
			<div class="input-group">
				<div class="input-group-prepend">
					<label class="input-group-text" for="categorie">Catégories
						:</label>
				</div>
				<select class="custom-select" id="categorie" name="categorie"
					required>
					<option selected>Toutes</option>
					<option value="1:informatique">Informatique</option>
					<option value="2:ameublement">Ameublement</option>
					<option value="3:vetement">Vêtement</option>
					<option value="4:sport & loisir">Sport & Loisir</option>
				</select>
			</div>
		</br>
			<%
			List<Article> listeArticles = (List<Article>) request.getAttribute("listeArticles");
			for (Article article : listeArticles) {
			%>

			<div class="card" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title text-capitalize"><%=article.getNom()%></h5>
					<p class="card-text">
						<%
						if (Integer.valueOf(article.getPrixVente()) != null) {
						%>
						Prix :
						<%=article.getPrixInitial()%>
						points
						<%
						} else {
						%>
						Prix :
						<%=article.getPrixVente()%>
						points
						<%
						}
						%>
						</br>
						Fin de l'enchère :
						<%=article.getDateFinEnchere()%>
						</br>
						Vendeur :
						<%=article.getVendeur().getPseudo()%>
						</br>
						Catégorie :
						<%=article.getCategorie().getLibelle()%>
					</p>
				</div>
			</div>
			<%
			}
			%>
		</br>
		</main>
	</div>
</body>
</html>
</html>