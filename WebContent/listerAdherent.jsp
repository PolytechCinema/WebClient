<%@ include file="include/header.jsp"%>
<body>
	<div id="site">
		<%@ include file="include/menu.jsp"%>
		<div id="conteneur">
			<%@ include file="include/bandeaudroite.jsp"%>
			<div id="contenu">
				<h1>Listing des Adhérents</h1>
				<table border="1">
					<caption>Tableau des Adhérents</caption>
					<tr>
						<th>Numero</th>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Ville</th>
					</tr>
					<c:forEach items="${mesAdherents}" var="item">
						<tr>
							<td>${item.idAdherent}</td>
							<td>${item.nomAdherent}</td>
							<td>${item.prenomAdherent}</td>
							<td>${item.villeAdherent}</td>
							<td><a href="Controleur?action=supprimerAdherent&id=${item.idAdherent}">Supprimer</a>
						</tr>
					</c:forEach>
				</table>
			</div>
			<%@ include file="include/footer.jsp"%>
		</div>
	</div>
</body>
</html>
