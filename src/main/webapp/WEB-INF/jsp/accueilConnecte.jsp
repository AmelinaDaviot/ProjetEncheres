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
            <h2>Bonjour PSEUDO</h2> <!-- request.getAttribute("pseudo") => récupérer le pseudo de la personne -->
        </header>
        <nav>
            <form action="" method="post">
                <div class="profit">
                    <a href="<%=request.getContextPath()%>/profil">Mon profil></a>
                </div>
                <div class="deconnexion">
                    <a href="<%=request.getContextPath()%>/accueil">Déconnexion</a>
                </div>
            </form>
        </nav>
        <main></main>
        <footer></footer>
    </div>

</body>
</html>