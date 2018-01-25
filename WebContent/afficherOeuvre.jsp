<%@ include file="include/header.jsp"%>
<body>
	<div id="site">
		<%@ include file="include/menu.jsp"%>
		<div id="conteneur">
			<%@ include file="include/bandeaudroite.jsp"%>
			<div id="contenu">
				<h1>Affichage  d'une oeuvre </h1>
				<form method="post" action="Controleur?action=modifierOeuvre">
					<table>
						<tr>
							<td>ID</td>
							<td><input type="text" name="txtId" value="${uneOeuvre.idOeuvrevente}" readonly/></td>
						</tr>
						<tr>
							<td>Titre</td>
							<td><input type="text" name="txtTitre" value="${uneOeuvre.titreOeuvrevente}"/></td>
						</tr>
						<tr>
							<td>Etat</td>
							<td><input type="text" name="txtEtat" value="${uneOeuvre.etatOeuvrevente}"/></td>
						</tr>
						<tr>
							<td>Prix</td>
							<td><input type="text" name="txtPrix" value ="${uneOeuvre.prixOeuvrevente}"/></td>
						</tr>
						<tr>
							<td>Nom Proriétaire</td>
							<td>${uneOeuvre.proprietaire.nomProprietaire}</td>
						</tr>
					</table>
					<input type="submit" value="Modifier"/>
				</form>
			</div>
			<%@ include file="include/footer.jsp"%>
		</div>
	</div>
</body>
</html>
