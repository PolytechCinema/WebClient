<%@ include file="include/header.jsp"%>
<body>
	<div id="site">
		<%@ include file="include/menu.jsp"%>
		<div id="conteneur">
			<%@ include file="include/bandeaudroite.jsp"%>
			<div id="contenu">
				<H1>Ajout d'un adhérent</H1>
				<div align="left">
					<form name='identification' method="post" action="Controleur?action=insererAdherent" onsubmit="return teste()">
						<table>
							<tr>
								<td>Nom de l'adherent</td>
								<td><input type="text" name="txtnom" value="" id="nom"></td>
							</tr>
							<tr>
								<td>Prenom de l'adherent</td>
								<td><input type="text" name="txtprenom" id="prenom"></td>
							</tr>
							<tr>
								<td>Ville de l'adherent</td>
								<td><input type="text" name="txtville" id="ville"></td>
							</tr>
						</table>
						<input type="submit" name="bt" value="Ajouter">
					</form>
				</div>
			</div>
			<%@ include file="include/footer.jsp"%>
		</div>
	</div>
</body>
</html>
