<%@ include file="include/header.jsp"%>
<body>
	<div id="site">
		<%@ include file="include/menu.jsp"%>
		<div id="conteneur">
			<%@ include file="include/bandeaudroite.jsp"%>
			<div id="contenu">
				<h1>Recherche d'une oeuvre</h1>
				<h2>A l'aide d'une liste</h2>
				<form method="post" action="Controleur?action=rechercherOeuvre">
				<div>
					<select name="id">
						<c:forEach var="uneOeuvre" items="${mesOeuvres}">
							<option value="${uneOeuvre.idOeuvrevente}">${uneOeuvre.titreOeuvrevente}</option>
						</c:forEach>
					</select>
					<input type="submit" value="Rechercher l'oeuvre"/>
				</div>
				</form>
			</div>
			<%@ include file="include/footer.jsp"%>
		</div>
	</div>
</body>
</html>
