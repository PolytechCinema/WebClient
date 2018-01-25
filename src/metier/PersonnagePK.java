package metier;

import java.io.Serializable;

/**
 * Created by Andzura on 23/01/2018.
 */
public class PersonnagePK implements Serializable{
    protected long acteurId;
    protected long filmId;

    public PersonnagePK(){}

    public PersonnagePK(long acteurId, long filmId) {
        this.acteurId = acteurId;
        this.filmId = filmId;
    }

    public long getActeurId() {
        return acteurId;
    }

    public void setActeurId(long acteurId) {
        this.acteurId = acteurId;
    }

    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonnagePK that = (PersonnagePK) o;

        if (acteurId != that.acteurId) return false;
        return filmId == that.filmId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
