<%@ include file="../include/header.jsp"%>
<body>
	<div id="site">
		<%@ include file="../include/menu.jsp"%>
		<div id="conteneur">
			<%@ include file="../include/bandeaudroite.jsp"%>
			<div id="contenu">
				<H1>Ajout d'un film</H1>
				<div align="left">
					<form name='identification' method="post" action="Controleur?action=insererFilms" onsubmit="return teste()">
						<table>
							<tr>
								<td>Titre</td>
								<td><input type="text" name="titre" value="" id="titre"></td>
							</tr>
							<tr>
								<td>Catégorie</td>
								<td><input type="text" name="categorie" id="cat"></td>
							</tr>
							<tr>
								<td>Réalisateur</td>
								<td><input type="text" name="realisateur" id="real"></td>
							</tr>
							<tr>
								<td>Durée</td>
								<td><input type="text" name="duree" id="duree"></td>
							</tr>
							<tr>
								<td>Date de sortie</td>
								<td><input type="text" name="dateSortie" id="dateSortie"></td>
							</tr>
							<tr>
								<td>Budget</td>
								<td><input type="text" name="budget" id="budget"></td>
							</tr>
							<tr>
								<td>Recette</td>
								<td><input type="text" name="recette" id="recette"></td>
							</tr>
						</table>
						<input type="submit" name="bt" value="Ajouter">
					</form>
				</div>
			</div>
			<%@ include file="../include/footer.jsp"%>
		</div>
	</div>
</body>
</html>
