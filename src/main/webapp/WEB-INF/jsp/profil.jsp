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
			<h2 class="text-capitalize">Bonjour ${sessionScope.utilisateur.pseudo} !</h2>
		</br>

			<div class="row justify-content-center">
				<div class="col-3"></div>
				<div class="col-2">Nom : </div>
				<div class="col-2 text-capitalize">${sessionScope.utilisateur.nom}</div>
				<div class="col-5"></div>
			  </div>
			</br>

			  <div class="row justify-content-center">
				<div class="col-3"></div>
				<div class="col-2">Prénom : </div>
				<div class="col-2 text-capitalize">${sessionScope.utilisateur.prenom}</div>
				<div class="col-5"></div>
			  </div>
			</br>
			  <div class="row justify-content-center">
				<div class="col-3"></div>
				<div class="col-2">Email : </div>
				<div class="col-2">${sessionScope.utilisateur.email}</div>
				<div class="col-5"></div>
			  </div>
			</br>
			  <div class="row justify-content-center">
				<div class="col-3"></div>
				<div class="col-2">Téléphone : </div>
				<div class="col-2">${sessionScope.utilisateur.telephone}</div>
				<div class="col-5"></div>
			  </div>
			</br>
			  <div class="row justify-content-center">
				<div class="col-3"></div>
				<div class="col-2">Rue : </div>
				<div class="col-2">${sessionScope.utilisateur.rue}</div>
				<div class="col-5"></div>
			  </div>
			</br>
			  <div class="row justify-content-center">
				<div class="col-3"></div>
				<div class="col-2">Code postal : </div>
				<div class="col-2">${sessionScope.utilisateur.codePostal}</div>
				<div class="col-5"></div>
			  </div>
			</br>
			  <div class="row justify-content-center">
				<div class="col-3"></div>
				<div class="col-2">Ville : </div>
				<div class="col-2">${sessionScope.utilisateur.ville}</div>
				<div class="col-5"></div>
			  </div>
			</br>
			  <div class="row justify-content-center">
				<div class="col-3"></div>
				<div class="col-2">Crédit : </div>
				<div class="col-2">${sessionScope.utilisateur.credit} points</div>
				<div class="col-5"></div>
			  </div>
			</br>


			<div name="first-btn">
				<div class="row justify-content-center">
					<div class="col-1">
					<form action="<%=request.getContextPath()%>/profil" method="post">
						<button type="submit" class="btn btn-primary">Modifier</button></form>
					</div>
					</div>
					</div>
					
				
			</div>
		
		</main>


	</div>
</body>
</html>