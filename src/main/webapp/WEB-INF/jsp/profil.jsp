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

	<div class="container">

		<nav class="navbar navbar-light bg-light justify-content-between">
            <a href="<%=request.getContextPath()%>/accueillir" class="text-dark text-decoration-none"> <h1>ENI-ENCHERES</h1></a>
		</nav>

		<main>
			Bonjour : ${sessionScope.utilisateur.pseudo}

			
				<div class="row justify-content-center">
					<div class="col-6">
						Nom :
						<p class="text-center" >${sessionScope.utilisateur.nom}</p>

					</div>
					
				</div>
				<div class="row justify-content-center">
					<div class="col-6">

						<p class = "info">Prenom :${sessionScope.utilisateur.prenom}</p>
					</div>
				</div>

				<p>Email :${sessionScope.utilisateur.email}</p>
				<p>Telephone :${sessionScope.utilisateur.telephone}</p>
				<p>Rue :${sessionScope.utilisateur.rue}</p>
				<p>Code postal :${sessionScope.utilisateur.codePostal}</p>
				<p>Ville :${sessionScope.utilisateur.ville}</p>
				<p>Credit :${sessionScope.utilisateur.credit}</p>


	
	<!--"<%=request.getContextPath()%>/modification-profil"-->
			<div name="first-btn">
				
					<form action="<%=request.getContextPath()%>/modification-profil" method="post">
						<button type="submit" class="btn btn-primary">Modifier</button></form>
				
			</div>
		
		</main>


	</div>
</body>
</html>