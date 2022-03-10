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
<title>Modifier ou Supprimer Profil</title>
</head>
<body>
	<div class="container">
		<header> </header>

        <nav class="navbar navbar-light bg-light justify-content-between">
            <a href="<%=request.getContextPath()%>/accueillir" class="text-dark text-decoration-none"> <h1>ENI-ENCHERES</h1></a>
            <form class="form-inline">
                <ul class="nav justify-content-end">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Enchères</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="<%=request.getContextPath() %>/vendre-article">Vendre un article</a>
                    </li>
                    <li class="nav-item">
                    	<a class="nav-link active text-dark" >Crédit : ${sessionScope.utilisateur.credit}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="<%=request.getContextPath()%>/profil">Mon profil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/deconnexion ">Déconnexion</a>
                    </li>
                  </ul>
            </form>
          </nav>

		<main>
		
			<h2>Mon Profil</h2>
		</br>
			<%
			if(request.getAttribute("error") != null){
				Exception error = (Exception) request.getAttribute("error");
			%>

			<div class="alert alert-danger" role="alert">
				<%= error.getMessage() %>
			</div>
			<%} %>


			<form action="<%=request.getContextPath()%>/modification-profil"
				method="post">
				<div class="row justify-content-center">
					<div class="col-4">
					<label for="pseudo">Pseudo :</label> <input type="text" class="form-control" id="pseudo"
						name="pseudo">
				</div>
				<div class="col-4">
					<label for="nom">Nom :</label> <input type="text" class="form-control" id="nom"
						name="nom">
				</div>
</div>
</br>

<div class="row justify-content-center">
				<div class="col-4">
					<label for="prenom">Prénom :</label> <input type="text" class="form-control" id="prenom"
						name="prenom">
				</div>
				<div class="col-4">
					<label for="email">Email :</label> <input type="email" class="form-control" id="email"
						name="email">
				</div>
			</div>
		</br>

			<div class="row justify-content-center">
				<div class="col-4">
					<label for="tel">Téléphone :</label> <input type="tel" class="form-control" id="tel"
						name="tel">
				</div>
				<div class="col-4">
					<label for="rue">Rue :</label> <input type="text" class="form-control" id="rue"
						name="rue">
				</div>
			</div>
		</br>

			<div class="row justify-content-center">
				<div class="col-4">
					<label for="cpo">Code Postal :</label> <input type="text" class="form-control" id="cpo"
						name="cpo">
				</div>
				<div class="col-4">
					<label for="ville">Ville :</label> <input type="text" class="form-control" id="ville"
						name="ville">
				</div>
</div>
</br>

				<div class="row justify-content-center">
				<div class="col-4">
					<label for="new-mdp">Nouveau mot de passe :</label> <input
						type="password" class="form-control" id="new-mdp" name="new-mdp">
				</div>
				<div class="col-4">
					<label for="confirmation">Confirmation :</label> <input
						type="password" class="form-control" id="confirmation" name="confirmation">
				</div>
				</div>

			</br>

				<div class="row justify-content-center">
					<div class="col-4">
						<label for="mdp">Mot de passe actuel :</label> <input
							type="password" class="form-control" id="mdp" name="mdp" required="required">
					</div>
					</div>
				</br>
				
				<div class="first-btn">
					<div class="row justify-content-center">
						<div class="col-2">
					<button type="submit" class="btn btn-primary" name="action" value="MODIF">Enregistrer</button>
						</div>
						<div class="col-2">
					<button type="submit" class="btn btn-secondary" name="action" value="SUPP">Supprimer mon compte</button>
						</div>
					</div>
				</div>
			</form>
		</main>
		<footer></footer>
	</div>

</body>
</html>