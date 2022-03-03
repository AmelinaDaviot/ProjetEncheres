<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--<link rel="stylesheet" href="css/style.css">-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="css/utilisateur.css">
<title>Inscription</title>
</head>
<body>
    <div class="container">
        <header>
            <h1>ENI-ENCHERES</h1>
        </header>
        <main>
            <h2>Mon profil</h2>
            <form action="<%=request.getContextPath() %>/inscription" method="post">
                
                <div class="form-row">
                    <div class="form-group col-md-6">
                      <label for="pseudo">Pseudo :</label>
                      <input type="text" class="form-control" id="pseudo" placeholder="Votre Pseudo" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="nom">Nom :</label>
                        <input type="text" class="form-control" id="nom" placeholder="Votre Nom" required>
                      </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="prenom">Prénom :</label>
                        <input type="text" class="form-control" id="prenom" placeholder="Votre Prénom" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="email">Email :</label>
                        <input type="email" class="form-control" id="email" placeholder="exemple@gmail.com" required>
                      </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="tel">Téléphone :</label>
                        <input type="tel" class="form-control" id="tel" placeholder="N° de téléphone">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="rue">Rue :</label>
                        <input type="text" class="form-control" id="rue" placeholder="ex : 12 impasse Ampère" required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="cpo">Code Postal :</label>
                        <input type="text" class="form-control" id="cpo" placeholder="ex : 85000" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="ville">Ville :</label>
                        <input type="email" class="form-control" id="ville" placeholder="ex : La Roche-sur-Yon" required>
                      </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="mdp">Mot de passe :</label>
                        <input type="password" class="form-control" id="mdp" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="confirmation">Confirmation :</label>
                        <input type="password" class="form-control" id="confirmation" required>
                    </div>
                </div>
                
                <div class="first-btn">
                    <button type="submit" class="btn btn-primary">Créer</button> 
                
                    <a href="<%=request.getContextPath()%>/accueil"><button type="button" class="btn btn-secondary">Annuler</button></a>
                </div>

            </form>
            
        </main>
        <footer></footer>
    </div>

</body>
</html>