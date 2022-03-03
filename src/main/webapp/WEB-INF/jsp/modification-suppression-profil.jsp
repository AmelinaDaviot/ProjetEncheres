<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
        <header>
            <h1>ENI-ENCHERES</h1>
        </header>
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
                    <input type="password" id="new-mdp" name="new-mdp" required="required">
                </div>
                <div class="forms-control">
                    <label for="confirmation">Confirmation :</label>
                    <input type="password" id="confirmation" name="confirmation" required="required">
                </div>   
                <div class="forms-control">
                    <label for="prenom">Crédit :</label>
                    <!-- get crédit-->
                    <%=request.getAttribute("credit") %>
                </div>
                <div class="first-btn">
                    <button type="submit">Enregistrer</button>
                </div>
            </form>
            <div class="first-btn">
                    <button type="submit">Supprimer mon compte</button>
                </div>
        </main>
        <footer></footer>
    </div>

</body>
</html>