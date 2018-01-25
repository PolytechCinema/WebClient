package controle;

import com.google.gson.Gson;
import consommation.*;
import metier.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ACTION_TYPE = "action";
	private static final String ERROR_KEY = "messageErreur";
	private static final String ERROR_PAGE = "/erreur.jsp";

	private static final String LISTER_FILMS = "listerFilms";
	private static final String AJOUTER_FILMS = "ajouterFilms";
	private static final String INSERER_FILMS = "insererFilms";
	private static final String SUPPRIMER_FILMS = "supprimerFilms";
	private static final String CHERCHER_FILMS = "chercherFilms";
	private static final String MODIFIER_FILMS = "modifierFilms";

	private static final String LISTER_ACTEURS = "listerActeurs";
	private static final String AJOUTER_ACTEURS = "ajouterActeurs";
	private static final String INSERER_ACTEURS = "insererActeurs";
	private static final String SUPPRIMER_ACTEURS = "supprimerActeurs";
	private static final String CHERCHER_ACTEURS = "chercherActeurs";
	private static final String MODIFIER_ACTEURS = "modifierActeurs";


	private static final String LISTER_ADHERENT = "listerAdherent";
	private static final String AJOUTER_ADHERENT = "ajouterAdherent";
	private static final String INSERER_ADHERENT = "insererAdherent";
	private static final String SUPPRIMER_ADHERENT = "supprimerAdherent";
	private static final String RECHERCHER_LISTE_OEUVRE = "chercherListeOeuvre";
	private static final String RECHERCHER_OEUVRE = "rechercherOeuvre";
	private static final String MODIFIER_OEUVRE = "modifierOeuvre";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processusTraiteRequete(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processusTraiteRequete(request, response);
	}

	protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinationPage = ERROR_PAGE;
		Appel call = new Appel();
		switch(request.getParameter(ACTION_TYPE)){
			case LISTER_FILMS:
				request.setAttribute("Films", listFilm());
				destinationPage = "/Films/Liste.jsp";
				break;
			case AJOUTER_FILMS:
				request.setAttribute("Categories", listCat());
				request.setAttribute("Reals", listReal());
				destinationPage = "/Films/Ajout.jsp";
				break;
			case INSERER_FILMS:
				Film f = new Film();
				f.setBudget(Integer.parseInt(request.getParameter("budget")));
				//f.setCategorie(request.getParameter("categorie"));
				f.setDateSortie(Date.valueOf(request.getParameter("dateSortie")));
				f.setDuree(Integer.parseInt(request.getParameter("duree")));
				f.setMontantRecette(Integer.parseInt(request.getParameter("recette")));
				//f.setRealisateur(request.getParameter("realisateur"));
				f.setTitre(request.getParameter("titre"));
				call.postJson("/film/", f);
				request.setAttribute("Films", listFilm());
				destinationPage = "/Films/Liste.jsp";
				break;
			case SUPPRIMER_FILMS:
				String id = request.getParameter("id");
				if (id != null) {
					call.deleteJson("/film/"+id);
				}
				request.setAttribute("Films", listFilm());
				destinationPage = "/Films/Liste.jsp";
				break;
			case CHERCHER_FILMS:
				id = request.getParameter("id");
				if (id != null) {
					request.setAttribute("Film", getFilm(Integer.parseInt(id)));
					destinationPage = "/Film/Details.jsp";
				}
				else{
					request.setAttribute(ERROR_KEY, "Error during searching of a movie");
					destinationPage = ERROR_PAGE;
				}
				break;
			case MODIFIER_FILMS:
				f = new Film();
				f.setId(Integer.parseInt(request.getParameter("idFilm")));
				f.setBudget(Integer.parseInt(request.getParameter("budget")));
				f.setCategorie(getCategorie(Integer.parseInt(request.getParameter("categorie"))));
				f.setDateSortie(Date.valueOf(request.getParameter("dateSortie")));
				f.setDuree(Integer.parseInt(request.getParameter("duree")));
				f.setMontantRecette(Integer.parseInt(request.getParameter("recette")));
				f.setRealisateur(getReal(Integer.parseInt(request.getParameter("realisateur"))));
				f.setTitre(request.getParameter("titre"));
				call.putJson("/film/"+f.getId(), f);
				request.setAttribute("Films", listFilm());
				destinationPage = "/Films/Liste.jsp";
				break;
			case LISTER_ACTEURS:
				request.setAttribute("Acteurs", listActeur());
				destinationPage = "/Acteurs/Liste.jsp";
				break;
			case AJOUTER_ACTEURS:
				destinationPage = "/Acteurs/Ajout.jsp";
				break;
			case INSERER_ACTEURS:
				Acteur a = new Acteur();
				a.setNom(request.getParameter("nom"));
				a.setPrenom(request.getParameter("prenom"));
				a.setDateNaiss(Date.valueOf(request.getParameter("dateNaissance")));
				a.setDateDeces(Date.valueOf(request.getParameter("dateDeces")));
				call.postJson("/acteur/", a);
				request.setAttribute("Acteurs", listFilm());
				destinationPage = "/Acteurs/Liste.jsp";
				break;
			case SUPPRIMER_ACTEURS:
				id = request.getParameter("id");
				if (id != null) {
					call.deleteJson("/acteur/"+id);
				}
				request.setAttribute("Acteurs", listFilm());
				destinationPage = "/Acteurs/Liste.jsp";
				break;
			case CHERCHER_ACTEURS:
				id = request.getParameter("id");
				if (id != null) {
					request.setAttribute("Acteurs", getActeur(Integer.parseInt(id)));
					destinationPage = "/Acteurs/Details.jsp";
				}
				else{
					request.setAttribute(ERROR_KEY, "Error during searching of an actor");
					destinationPage = ERROR_PAGE;
				}
				break;
			case MODIFIER_ACTEURS:
				a = new Acteur();
				a.setId(Integer.parseInt(request.getParameter("idActeur")));
				a.setNom(request.getParameter("nom"));
				a.setPrenom(request.getParameter("prenom"));
				a.setDateNaiss(Date.valueOf(request.getParameter("dateNaissance")));
				a.setDateDeces(Date.valueOf(request.getParameter("dateDeces")));
				call.postJson("/acteur/", a);
				request.setAttribute("Acteurs", listFilm());
				destinationPage = "/Acteurs/Liste.jsp";
				break;
			default:
				request.setAttribute(ERROR_KEY, "Not such action");
				destinationPage = ERROR_PAGE;
		}
	}

	protected List<Film> listFilm(){
		Gson gson = new Gson();
		Appel call = new Appel();
		return gson.fromJson(call.appelJson("/film/"), List.class);
	}
	protected List<Acteur> listActeur(){
		Gson gson = new Gson();
		Appel call = new Appel();
		return gson.fromJson(call.appelJson("/acteur/"), List.class);
	}
	protected List<Realisateur> listReal(){
		Gson gson = new Gson();
		Appel call = new Appel();
		return gson.fromJson(call.appelJson("/real/"), List.class);
	}
	protected List<Categorie> listCat(){
		Gson gson = new Gson();
		Appel call = new Appel();
		return gson.fromJson(call.appelJson("/cat/"), List.class);
	}

	protected Film getFilm(int id){
		Gson gson = new Gson();
		Appel call = new Appel();
		return gson.fromJson(call.appelJson("/film/"+id), Film.class);
	}
	protected Acteur getActeur(int id){
		Gson gson = new Gson();
		Appel call = new Appel();
		return gson.fromJson(call.appelJson("/acteur/"+id), Acteur.class);
	}
	protected Realisateur getReal(int id){
		Gson gson = new Gson();
		Appel call = new Appel();
		return gson.fromJson(call.appelJson("/real/"+id), Realisateur.class);
	}
	protected Categorie getCategorie(int id){
		Gson gson = new Gson();
		Appel call = new Appel();
		return gson.fromJson(call.appelJson("/cat/"+id), Categorie.class);
	}
}