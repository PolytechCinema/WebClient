<%@ include file="../include/header.jsp"%>
<body>
	<div id="site">
		<%@ include file="../include/menu.jsp"%>
		<div id="conteneur">
			<%@ include file="../include/bandeaudroite.jsp"%>
			<div id="contenu">
				<h1>Affichage  d'un film </h1>
				<form method="post" action="Controleur?action=modifierFilms">
					<table>
						<tr>
							<td>ID</td>
							<td><input type="text" name="idFilm" value="${Film.id}" readonly/></td>
						</tr>
						<tr>
							<td>Titre</td>
							<td><input type="text" name="titre" value="${Film.titre}"/></td>
						</tr>
						<tr>
							<td>Catégorie</td>
							<td><input type="text" name="categorie" value="${Film.categorie.libelle}"/></td>
						</tr>
						<tr>
							<td>Réalisateur</td>
							<td><input type="text" name="realisateur" value="${Film.realisateur.prenom} ${Film.realisateur.nom}"/></td>
						</tr>
						<tr>
							<td>Durée</td>
							<td><input type="text" name="duree" value ="${Film.duree}"/></td>
						</tr>
						<tr>
							<td>Date de sortie</td>
							<td><input type="text" name="dateSortie" value ="${Film.dateSortie}"/></td>
						</tr>
						<tr>
							<td>Budget</td>
							<td><input type="text" name="budget" value ="${Film.budget}"/></td>
						</tr>
						<tr>
							<td>Recette</td>
							<td><input type="text" name="recette" value ="${Film.montantRecette}"/></td>
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
