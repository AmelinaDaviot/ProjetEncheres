<%@ page import="fr.eni.projetencheres.bo.Utilisateur" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil - Connecté</title>
</head>
<body>
    <div class="container">
        <header>
            <h1>ACCUEIL</h1>
            <% Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");%>
         
            <h2>Bonjour <%= utilisateur.getPseudo()%></h2>
        </header>
        <nav>
            <form action="" method="post">
                <div class="profil">
                    <a href="<%=request.getContextPath()%>/profil">Mon profil</a>
                </div>
                <div class="deconnexion">
                    <a href="<%=request.getContextPath()%>/accueil">Déconnexion</a>
                </div>
            </form>
        </nav>
        <main> 
        <body>
        
        </body>       
        </main>
        <footer></footer>
    </div>

</body>
</html>