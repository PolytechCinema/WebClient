package metier;


/**
 * Created by Andzura on 23/01/2018.
 */
public class Personnage {
    private PersonnagePK id;
    private Acteur acteur;
    private Film film;
    private String nom;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
        if(id == null){
            id = new PersonnagePK();
        }
        id.setFilmId(film.getId());
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
        if(id == null){
            id = new PersonnagePK();
        }
        id.setActeurId(acteur.getId());
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
