<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Connexion</title>
</head>
<body>
	<header>
		<h1>Connexion</h1>
	</header>

	<main>
		<form action="<%=request.getContextPath()%>/connexion" method="post">
			<div>
				<label for="pseudo">Pseudo :</label> <input type="text" id="pseudo"
					name="pseudo">
			</div>

			<div>

				<label for="motDePasse">Mot de passe</label> <input type="password"
					id="motDePasse" name="motDePasse">

			</div>

			<button type="submit">Se connecter</button>
		</form>
	</main>
</body>
</html>