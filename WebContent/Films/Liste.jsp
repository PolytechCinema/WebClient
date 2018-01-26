<%--
  Created by IntelliJ IDEA.
  User: Adrien
  Date: 25/01/2018
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../include/header.jsp"%>
<body>
<div id="site">
    <%@ include file="../include/menu.jsp"%>
    <div id="conteneur">
        <%@ include file="../include/bandeaudroite.jsp"%>
        <div id="contenu">
            <h1>Listing des Films</h1>
            <table border="1">
                <caption>Tableau des Films</caption>
                <tr>
                    <th>Titre</th>
                    <th>Categorie</th>
                    <th>Réalisateur</th>
                    <th>Durée</th>
                    <th>Date de sortie</th>
                    <th>Budget</th>
                    <th>Recette</th>
                </tr>
                <c:forEach items="${Films}" var="item">
                    <tr>
                        <td>${item.titre}</td>
                        <td>${item.categorie.libelle}</td>
                        <td>${item.realisateur.prenom} ${item.realisateur.nom}</td>
                        <td>${item.duree}</td>
                        <td>${item.dateSortie}</td>
                        <td>${item.budget}</td>
                        <td>${item.montantRecette}</td>
                        <td><a href="Controleur?action=chercherFilms&id=${item.id}">Modifier</a>
                        <td><a href="Controleur?action=supprimerFilms&id=${item.id}">Supprimer</a>
                    </tr>
                </c:forEach>
            </table>
            <a href="Controleur?action=ajouterFilms">Ajouter un film</a>
        </div>
        <%@ include file="../include/footer.jsp"%>
    </div>
</div>
</body>
</html>
