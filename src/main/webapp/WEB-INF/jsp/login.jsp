<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="css/utilisateur.css">
<title>Connexion</title>
</head>
<body>
	<div class="container">
	<header>
		
	</header>

	<nav class="navbar navbar-light bg-light justify-content-between">
		<a href="<%=request.getContextPath()%>/accueillir" class="text-dark text-decoration-none"> <h1>ENI-ENCHERES</h1></a>
	</nav>

	<main>
	
	<%
	if(request.getAttribute("error") != null){
		Exception error = (Exception) request.getAttribute("error");
	%>
	
	<div class="alert alert-danger" role="alert">
  		<%= error.getMessage() %>
	</div>

		
	<%} %>
	
		<form action="<%=request.getContextPath()%>/connexion" method="post">

			<div class="form-row">
				<div class="form-group col-md-6">
				  <label for="identifiant">Identifiant :</label>
				  <input type="text" class="form-control" id="identifiant" name="identifiant" placeholder="Pseudo ou Email" required>
				</div>
				<div class="form-group col-md-6">
					<label for="motDePasse">Mot de passe :</label>
					<input type="password" class="form-control" id="motDePasse" name="motDePasse" required>
				  </div>
			</div>


			<div class="first-btn">
				<button type="submit" class="btn btn-primary">Se connecter</button>
				<a href="<%=request.getContextPath()%>/inscription ">
					<button type="button" class="btn btn-secondary">Créer un compte</button>
				</a>
			</div>


		</form>
	</main>
</div>
</body>
</html>