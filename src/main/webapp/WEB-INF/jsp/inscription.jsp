<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
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
                <div class="forms-control">
                    <label for="pseudo">Pseudo :</label>
                    <input type="text" id="pseudo" name="pseudo" required="required">
                </div>
                <div class="forms-control">
                    <label for="nom">Nom :</label>
                    <input type="text" id="nom" name="nom" required="required">
                </div>
                <div class="forms-control">
                    <label for="prenom">Prénom :</label>
                    <input type="text" id="prenom" name="prenom" required="required">
                </div>
                <div class="forms-control">
                    <label for="email">Email :</label>
                    <input type="email" id="email" name="email" required="required">
                </div>
                <div class="forms-control">
                    <label for="tel">Téléphone :</label>
                    <input type="tel" id="tel" name="tel">
                </div>
                <div class="forms-control">
                    <label for="rue">Rue :</label>
                    <input type="text" id="rue" name="rue" required="required">
                </div>
                <div class="forms-control">
                    <label for="cpo">Code Postal :</label>
                    <input type="text" id="cpo" name="cpo" required="required">
                </div>
                <div class="forms-control">
                    <label for="ville">Ville :</label>
                    <input type="text" id="ville" name="ville" required="required">
                </div>
                <div class="forms-control">
                    <label for="mdp">Mot de passe :</label>
                    <input type="password" id="mdp" name="mdp" required="required">
                </div>
                <div class="forms-control">
                    <label for="confirmation">Confirmation :</label>
                    <input type="password" id="confirmation" name="confirmation" required="required">
                </div>   
                
                <div class="first-btn">
                    <button type="submit">Créer</button>
                    
                </div>
            </form>
            <div class="first-btn">
                <a href="<%=request.getContextPath()%>/accueil"><button>Annuler</button></a>
            </div>
        </main>
        <footer></footer>
    </div>

</body>
</html>