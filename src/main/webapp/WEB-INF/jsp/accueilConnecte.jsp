<%@ page import="fr.eni.projetencheres.bo.Utilisateur" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="css/utilisateur.css">
<title>Accueil - Connecté</title>
</head>
<body>
    <div class="container">
        <header>
                      
        </header>

        <nav class="navbar navbar-light bg-light justify-content-between">
            <h1>ENI-ENCHERES</h1>
            <form class="form-inline">
                <ul class="nav justify-content-end">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Enchères</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Vendre un article</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="<%=request.getContextPath()%>/profil">Mon profil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/accueil ">Déconnexion</a>
                    </li>
                  </ul>
            </form>
          </nav>


        <main> 
            <% Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");%>
         
            <h2>Bonjour ${ user.getPseudo()}</h2>       
        </main>
        <footer></footer>
    </div>

</body>
</html>