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
import java.lang.reflect.Executable;
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
		String destinationPage;
		Appel call = new Appel();
		Gson gson = new Gson();
try {
	switch (request.getParameter(ACTION_TYPE)) {
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
			Categorie cat = new Categorie();
			Realisateur real = new Realisateur();
			cat.setCode(request.getParameter("categorie"));
			real.setId(gson.fromJson(request.getParameter("realisateur"), Integer.class));
			f.setBudget(gson.fromJson(request.getParameter("budget"), Integer.class));
			f.setCategorie(cat);
			f.setDateSortie(request.getParameter("dateSortie"));
			f.setDuree(gson.fromJson(request.getParameter("duree"), Integer.class));
			f.setMontantRecette(gson.fromJson(request.getParameter("recette"), Integer.class));
			f.setRealisateur(real);
			f.setTitre(request.getParameter("titre"));
			call.postJson("/film/", f);
			destinationPage = "/index.jsp";
			break;
		case SUPPRIMER_FILMS:
			int id = gson.fromJson(request.getParameter("id"), Integer.class);
			call.deleteJson("/film/" + id);
			destinationPage = "/index.jsp";
			break;
		case CHERCHER_FILMS:
			id = gson.fromJson(request.getParameter("id"), Integer.class);
			request.setAttribute("Film", getFilm(id));
			request.setAttribute("Categories", listCat());
			request.setAttribute("Reals", listReal());
			destinationPage = "/Films/Details.jsp";
			break;
		case MODIFIER_FILMS:
			f = new Film();
			f.setId(gson.fromJson(request.getParameter("idFilm"), Integer.class));
			f.setBudget(gson.fromJson(request.getParameter("budget"), Integer.class));
			f.setCategorie(getCategorie(request.getParameter("categorie")));
			f.setDateSortie(request.getParameter("dateSortie"));
			f.setDuree(gson.fromJson(request.getParameter("duree"), Integer.class));
			f.setMontantRecette(gson.fromJson(request.getParameter("recette"), Integer.class));
			f.setRealisateur(getReal(gson.fromJson(request.getParameter("realisateur"), Integer.class)));
			f.setTitre(request.getParameter("titre"));
			call.putJson("/film/" + f.getId(), f);
			destinationPage = "/index.jsp";
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
			a.setDateNaiss(request.getParameter("dateNaissance"));
			try {
				a.setDateDeces(request.getParameter("dateDeces"));
			} catch (Exception e) {
			}
			call.postJson("/acteur/", a);
			destinationPage = "/index.jsp";
			break;
		case SUPPRIMER_ACTEURS:
			id = gson.fromJson(request.getParameter("id"), Integer.class);
			call.deleteJson("/acteur/" + id);
			destinationPage = "/index.jsp";
			break;
		case CHERCHER_ACTEURS:
			id = gson.fromJson(request.getParameter("id"), Integer.class);
			request.setAttribute("Acteur", getActeur(id));
			destinationPage = "/Acteurs/Details.jsp";
			break;
		case MODIFIER_ACTEURS:
			a = new Acteur();
			a.setId(gson.fromJson(request.getParameter("idActeur"), Integer.class));
			a.setNom(request.getParameter("nom"));
			a.setPrenom(request.getParameter("prenom"));
			a.setDateNaiss(request.getParameter("dateNaiss"));
			a.setDateDeces(request.getParameter("dateDeces"));
			call.postJson("/acteur/", a);
			destinationPage = "/index.jsp";
			break;
		default:
			request.setAttribute(ERROR_KEY, "Not such action");
			destinationPage = ERROR_PAGE;
	}
}catch(Exception e){
	request.setAttribute(ERROR_KEY, "An error occured");
	destinationPage = ERROR_PAGE;}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request,response);
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
	protected Categorie getCategorie(String id){
		Gson gson = new Gson();
		Appel call = new Appel();
		return gson.fromJson(call.appelJson("/cat/"+id), Categorie.class);
	}
}