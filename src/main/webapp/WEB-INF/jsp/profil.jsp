<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>profil</title>
</head>
<body>
	<!-- <header>
		Bonjour
		<%=request.getAttribute("pseudo")%></header>

	<main>
		<div class="container">
			<p>
				Nom :
				<%=request.getAttribute("nom")%></p>
			<p>
				Prenom :
				<%=request.getAttribute("prenom")%></p>
			<p>
				Email :
				<%=request.getAttribute("email")%></p>
			<p>
				Téléphone :
				<%=request.getAttribute("telephone")%></p>
			<p>
				Rue :
				<%=request.getAttribute("rue")%></p>
			<p>
				Code postal :
				<%=request.getAttribute("codePostal")%></p>
			<p>
				Ville :
				<%=request.getAttribute("ville")%></p>
		</div> -->

		<div name="modifier">
			<a href="<%=request.getContextPath()%>/modifier ">
				<button>Modifier</button>
			</a>

		</div>
	</main>

</body>
</html>