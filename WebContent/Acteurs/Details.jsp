<%@ include file="../include/header.jsp"%>
<body>
	<div id="site">
		<%@ include file="../include/menu.jsp"%>
		<div id="conteneur">
			<%@ include file="../include/bandeaudroite.jsp"%>
			<div id="contenu">
				<h1>Affichage  d'un acteur </h1>
				<form method="post" action="Controleur?action=modifierActeurs">
					<table>
						<tr>
							<td>ID</td>
							<td><input type="text" name="idActeur" value="${Acteur.id}" readonly/></td>
						</tr>
						<tr>
							<td>Nom</td>
							<td><input type="text" name="nom" value="${Acteur.nom}"/></td>
						</tr>
						<tr>
							<td>Prénom</td>
							<td><input type="text" name="prenom" value="${Acteur.prenom}"/></td>
						</tr>
						<tr>
							<td>Date de naissance</td>
							<td><input type="text" name="dateNaiss" value="${Acteur.dateNaiss}"/></td>
						</tr>
						<tr>
							<td>Date de décès</td>
							<td><input type="text" name="dateDeces" value ="${Acteur.dateDeces}"/></td>
						</tr>
					</table>
					<input type="submit" value="Modifier"/>
				</form>
			</div>
			<%@ include file="../include/footer.jsp"%>
		</div>
	</div>
</body>
</html>
