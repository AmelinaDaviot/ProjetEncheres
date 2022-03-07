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
            <a href="<%=request.getContextPath()%>/accueillir" class="text-dark text-decoration-none"> <h1>ENI-ENCHERES</h1></a>
            <form class="form-inline">
                <ul class="nav justify-content-end">
                    <li class="nav-item">
                        <a class="nav-link active text-dark text-center">Nouvelle Vente</a>
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

			<form action="<%=request.getContextPath() %>/vendre-article" method="post">
            
                <label for="nom">Article :</label>
                    <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom de l'article" required>
				
				<label for="description">Description :</label>
                    <input type="textarea" class="form-control" id="description" name="description" placeholder="Décrivez l'article" required>

            </form>


		</main>
		<footer></footer>
	</div>

</body>
</html>