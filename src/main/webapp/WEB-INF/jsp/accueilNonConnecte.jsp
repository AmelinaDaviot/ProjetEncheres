<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--<link rel="stylesheet" href="css/style.css">-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="css/utilisateur.css">
<title>Accueil</title>
</head>
<body>
	<div class="container">
	<header>
	</header>

	  <nav class="navbar navbar-light bg-light justify-content-between">
		<a href="<%=request.getContextPath()%>/accueillir" class="text-dark text-decoration-none"> <h1>ENI-ENCHERES</h1></a>
		<form class="form-inline">
			<ul class="nav justify-content-end">
				<li class="nav-item">
					<a class="nav-link active" href="<%=request.getContextPath()%>/connexion">Connexion</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<%=request.getContextPath()%>/inscription ">Inscription</a>
				</li>
			  </ul>
		</form>
	  </nav>

	<main>
		<h2>Liste des enchères</h2>
		
	</main>
</div>
</body>
</html>
</html>