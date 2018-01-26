<%@ include file="../include/header.jsp"%>
<body>
	<div id="site">
		<%@ include file="../include/menu.jsp"%>
		<div id="conteneur">
			<%@ include file="../include/bandeaudroite.jsp"%>
			<div id="contenu">
				<H1>Ajout d'un acteur</H1>
				<div align="left">
					<form name='identification' method="post" action="Controleur?action=insererActeurs" onsubmit="return teste()">
						<table>
							<tr>
								<td>Nom</td>
								<td><input type="text" name="nom" value="" id="nom"></td>
							</tr>
							<tr>
								<td>Prénom</td>
								<td><input type="text" name="prenom" id="prenom"></td>
							</tr>
							<tr>
								<td>Date de Naissance</td>
								<td><input type="date" name="dateNaiss" id="dateNaiss"></td>
							</tr>
							<tr>
								<td>Date de Décès</td>
								<td><input type="date" name="dateDeces" id="dateDeces"></td>
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
