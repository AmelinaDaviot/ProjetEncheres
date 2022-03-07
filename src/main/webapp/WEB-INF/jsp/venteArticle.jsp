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
<title>Nouvelle Vente</title>
</head>
<body>
	<div class="container">
		<header></header>

		<nav class="navbar navbar-light bg-light justify-content-between">
			<a href="<%=request.getContextPath()%>/accueillir"
				class="text-dark text-decoration-none">
				<h1>ENI-ENCHERES</h1>
			</a>
			<form class="form-inline">
				<ul class="nav justify-content-end">
					<li class="nav-item"><a class="nav-link active text-dark">Crédit
							: ${sessionScope.utilisateur.credit}</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="<%=request.getContextPath()%>/profil">Mon profil</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/deconnexion ">Déconnexion</a>
					</li>
				</ul>
			</form>
		</nav>

		<main>

			<h2>Nouvelle Vente</h2>

			<form action="<%=request.getContextPath()%>/vendre-article"
				method="post">

				<div class="row justify-content-center">
					<div class="col-4">
						<label for="nom">Article :</label> <input type="text"
							class="form-control" id="nom" name="nom"
							placeholder="Nom de l'article" required>
					</div>
				</div>

				<div class="row justify-content-center">
					<div class="col-4">
						<label for="description">Description :</label>
						<textarea class="form-control" id="description" name="description"
							rows="5" cols="10" placeholder="Description de l'article"
							required></textarea>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-4">
						<label for="etatVente">Etat :</label>
						<select class="form-control" id="etatVente" name="etatVente" required>
							<option selected></option>
							<option value="1">CR</option>
							<option value="2">EC</option>
							<option value="3">VD</option>
							<option value="4">RT</option>
						</select>
					</div>
				</div>

				<div class="row justify-content-center">
					<div class="col-4">
						<label for="categorie">Catégorie :</label>
						<select class="form-control" id="categorie" name="categorie" required>
							<option selected></option>
							<option value="1">Informatique</option>
							<option value="2">Ameublement</option>
							<option value="3">Vêtement</option>
							<option value="4">Sport & Loisir</option>
						</select>
					</div>
				</div>

				<div class="row justify-content-center">
					<div class="col-4">
						<label for="image">Photo de l'article :</label> <input type="file"
							id="image" name="image" multiple>
					</div>
				</div>

				<div class="row justify-content-center">
					<div class="col-4">
						<label for="prix">Mise à prix :</label> <input type="number"
							class="form-control" id="prix" name="prix" placeholder="Prix"
							required>
					</div>
				</div>

				<div class="row justify-content-center">
					<div class="col-4">
						<label for="debutEnchere">Début de l'enchère :</label> <input
							type="date" class="form-control" id="debutEnchere"
							name="debutEnchere" required>
					</div>
				</div>

				<div class="row justify-content-center">
					<div class="col-4">
						<label for="finEnchere">Fin de l'enchère :</label> <input
							type="date" class="form-control" id="finEnchere"
							name="finEnchere" required>
					</div>
				</div>

				<div class="first-btn">
					<div class="row justify-content-center">
						<div class="col-1">
							<button type="submit" class="btn btn-primary">Enregistrer</button>
						</div>
						
					</div>
				</div>


			</form>
			<div class="first-btn">
				<div class="row justify-content-center">
			<div class="col-1">
				<a href="<%=request.getContextPath()%>/accueillir">
					<button type="submit" class="btn btn-secondary">Annuler</button>
				</a>
			</div>
		</div>
	</div>

		</main>
		<footer></footer>
	</div>

</body>
</html>