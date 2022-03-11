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
		</br>
			<form action="<%=request.getContextPath()%>/vendre-article"
				method="post">

			<!--	<img src="..." alt="..." class="img-thumbnail">-->

				<div class="row justify-content-center">
					<div class="col-4">
						<label for="nom">Article :</label> <input type="text"
							class="form-control" id="nom" name="nom"
							placeholder="Nom de l'article" required>
					</div>
				</div>
			</br>
				<div class="row justify-content-center">
					<div class="col-4">
						<label for="description">Description :</label>
						<textarea class="form-control" id="description" name="description"
							rows="5" cols="10" placeholder="Description de l'article"
							required></textarea>
					</div>
				</div>
			</br>
				<div class="row justify-content-center">
					<div class="col-4">
					<div class="input-group">
						<div class="input-group-prepend">
							<label class="input-group-text" for="categorie">Catégorie :</label>
						</div>
						<select class="custom-select" id="categorie" name="categorie" required>
							<option selected></option>
							<option value="1:informatique">Informatique</option>
							<option value="2:ameublement">Ameublement</option>
							<option value="3:vetement">Vêtement</option>
							<option value="4:sport & loisir">Sport & Loisir</option>
						</select>
					</div>
					</div>
				</div>
			</br>
				<div class="row justify-content-center">
					<div class="col-4">
						<label for="image">Photo de l'article :</label> <input type="file"
							id="image" name="image" multiple>
					</div>
				</div>
			</br>
				<div class="row justify-content-center">
					<div class="col-4">
						<label for="prix">Mise à prix :</label> <input type="number"
							class="form-control" id="prix" name="prix" placeholder="Prix"
							required>
					</div>
				</div>
			</br>
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
			</br>
				<div class="row justify-content-center">
					<div class="col-4">
				<fieldset>
					<legend>Retrait</legend>
					<label for="rue">Rue :</label>
					<input type="text" class="form-control" id="rue" name="rue" value="${sessionScope.utilisateur.rue}" required>
					<label for="rue">Code Postal :</label>
					<input type="text" class="form-control" id="cpo" name="cpo" value="${sessionScope.utilisateur.codePostal}" required>
					<label for="ville">Ville :</label>
					<input type="text" class="form-control" id="ville" name="ville" value="${sessionScope.utilisateur.ville}" required>
				
				  </fieldset>
				</div>
			</div>
		</br>
				<div class="first-btn">
					<div class="row justify-content-center">
						<div class="col-2">
							<button type="submit" class="btn btn-primary">Enregistrer</button> 
						</div>
						<div class="col-2">
							<a href="<%=request.getContextPath()%>/accueillir">
								<button type="button" class="btn btn-secondary">Annuler</button>
							</a>                   
						</div>
					</div>
				</div>

			</form>
	

		</main>
		<footer></footer>
	</div>

</body>
</html>