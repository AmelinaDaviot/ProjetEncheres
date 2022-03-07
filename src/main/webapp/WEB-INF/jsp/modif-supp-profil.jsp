<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="css/utilisateur.css">
<title>Modifier ou Supprimer Profil</title>
</head>
<body>
    <div class="container">
        <header>
        </header>

        <nav class="navbar navbar-light bg-light justify-content-between">
            <a href="<%=request.getContextPath()%>/accueillir" class="text-dark text-decoration-none"> <h1>ENI-ENCHERES</h1></a>
          </nav>

        <main>
            <h2>Mon Profil</h2>
            <form action="<%=request.getContextPath() %>/modification-profil" method="post">
                <div class="forms-control">
                    <label for="pseudo">Pseudo :</label>
                    <input type="text" id="pseudo" name="pseudo">
                </div>
                <div class="forms-control">
                    <label for="nom">Nom :</label>
                    <input type="text" id="nom" name="nom">
                </div>
                <div class="forms-control">
                    <label for="prenom">Prénom :</label>
                    <input type="text" id="prenom" name="prenom">
                </div>
                <div class="forms-control">
                    <label for="email">Email :</label>
                    <input type="email" id="email" name="email">
                </div>
                <div class="forms-control">
                    <label for="tel">Téléphone :</label>
                    <input type="tel" id="tel" name="tel">
                </div>
                <div class="forms-control">
                    <label for="rue">Rue :</label>
                    <input type="text" id="rue" name="rue">
                </div>
                <div class="forms-control">
                    <label for="cpo">Code Postal :</label>
                    <input type="text" id="cpo" name="cpo">
                </div>
                <div class="forms-control">
                    <label for="ville">Ville :</label>
                    <input type="text" id="ville" name="ville">
                </div>
                <div class="forms-control">
                    <label for="mdp">Mot de passe actuel :</label>
                    <input type="password" id="mdp" name="mdp" required="required">
                </div>
                <div class="forms-control">
                    <label for="new-mdp">Nouveau mot de passe :</label>
                    <input type="password" id="new-mdp" name="new-mdp">
                </div>
                <div class="forms-control">
                    <label for="confirmation">Confirmation :</label>
                    <input type="password" id="confirmation" name="confirmation">
                </div>   
                <div class="forms-control">
                    <label for="prenom">Crédit :</label>
                    ${sessionScope.utilisateur.credit}
                </div>
                <div class="first-btn">
                    <button type="submit">Enregistrer</button>
                </div>
              
            </form>
            <form action="<%=request.getContextPath() %>/modification-profil" method="get">
            	<div class="first-btn">
                    <button type="submit">Supprimer mon compte</button>
                </div>
               </form>
        </main>
        <footer></footer>
    </div>

</body>
</html>