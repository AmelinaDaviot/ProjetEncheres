<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
<header>
<h1>Bonjour</h1>
</header>
<main>
    <div name="connexion">
	<a href="<%=request.getContextPath() %>/sevletconnexion">
		<button>Connexion</button>
	</a>

    </div>
     <div name="inscription">
	<a href="<%=request.getContextPath() %>/inscription ">
		<button>Inscription</button>
	</a>

    </div>
</main>

</body>
</html>
</html>