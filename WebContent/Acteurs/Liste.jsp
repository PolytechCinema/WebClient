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
            <h1>Listing des Acteurs</h1>
            <table border="1">
                <caption>Tableau des Acteurs</caption>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Date de naissance</th>
                    <th>Date de décès</th>
                </tr>
                <c:forEach items="${Acteurs}" var="item">
                    <tr>
                        <td>${item.nom}</td>
                        <td>${item.prenom}</td>
                        <td>${item.dateNaiss}</td>
                        <td>${item.dateDeces}</td>
                        <td><a href="Controleur?action=chercherActeurs&id=${item.id}">Modifier</a>
                        <td><a href="Controleur?action=supprimerActeurs&id=${item.id}">Supprimer</a>
                    </tr>
                </c:forEach>
            </table>
            <a href="Controleur?action=ajouterActeurs">Ajouter un acteur</a>
        </div>
        <%@ include file="../include/footer.jsp"%>
    </div>
</div>
</body>
</html>
