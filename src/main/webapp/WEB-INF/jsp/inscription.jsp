<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="css/utilisateur.css">
<title>Inscription</title>
</head>
<body>
    <div class="container">
        <header>
           
        </header>

        <nav class="navbar navbar-light bg-light justify-content-between">
            <a href="<%=request.getContextPath()%>/accueillir" class="text-dark text-decoration-none"> <h1>ENI-ENCHERES</h1></a>
          </nav>

        <main>
            <h2>Mon profil</h2>
        </br>

			<%
			if(request.getAttribute("error") != null){
				Exception error = (Exception) request.getAttribute("error");
			%>

			<div class="alert alert-danger" role="alert">
				<%= error.getMessage() %>
			</div>
			<%} %>

			<form action="<%=request.getContextPath() %>/inscription" method="post">
            
                <div class="row justify-content-center">
                    <div class="col-4">
                        <label for="pseudo">Pseudo :</label>
                        <input type="text" class="form-control" id="pseudo" name="pseudo" placeholder="Votre Pseudo" required>
                    </div>
                    <div class="col-4">
                        <label for="nom">Nom :</label>
                        <input type="text" class="form-control" id="nom" name="nom" placeholder="Votre Nom" required>
                    </div>
                </div>
            </br>
                <div class="row justify-content-center">
                    <div class="col-4">
                        <label for="prenom">Prénom :</label>
                        <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Votre Prénom" required>
                    </div>
                    <div class="col-4">
                        <label for="email">Email :</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="exemple@gmail.com" required>
                      </div>
                </div>
            </br>
                <div class="row justify-content-center">
                    <div class="col-4">
                        <label for="tel">Téléphone :</label>
                        <input type="tel" class="form-control" id="tel" name="tel" placeholder="N° de téléphone">
                      </div>
                      <div class="col-4">
                        <label for="rue">Rue :</label>
                        <input type="text" class="form-control" id="rue" name="rue" placeholder="ex : 12 impasse Ampère" required>
                    </div>
                </div>
            </br>
                <div class="row justify-content-center">
                    <div class="col-4">
                        <label for="cpo">Code Postal :</label>
                        <input type="text" class="form-control" id="cpo" name="cpo" placeholder="ex : 85000" required>
                    </div>
                    <div class="col-4">
                        <label for="ville">Ville :</label>
                        <input type="text" class="form-control" id="ville" name="ville" placeholder="ex : La Roche-sur-Yon" required>
                      </div>
                </div>
            </br>
                <div class="row justify-content-center">
                    <div class="col-4">
                        <label for="mdp">Mot de passe :</label>
                        <input type="password" class="form-control" id="mdp" name="mdp" required>
                    </div>
                    <div class="col-4">
                        <label for="confirmation">Confirmation :</label>
                        <input type="password" class="form-control" id="confirmation" name="confirmation" required>
                    </div>
                </div>
            </br>
                <div class="first-btn">
                    <div class="row justify-content-center">
                        <div class="col-1">
                            <button type="submit" class="btn btn-primary">Créer</button> 
                        </div>
                        <div class="col-1">
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