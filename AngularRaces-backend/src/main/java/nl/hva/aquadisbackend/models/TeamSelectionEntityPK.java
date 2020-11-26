package nl.hva.aquadisbackend.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TeamSelectionEntityPK implements Serializable {
    private int idteamSelection;
    private int iduser;

    @Column(name = "idteam_selection")
    @Id
    public int getIdteamSelection() {
        return idteamSelection;
    }

    public void setIdteamSelection(int idteamSelection) {
        this.idteamSelection = idteamSelection;
    }

    @Column(name = "iduser")
    @Id
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamSelectionEntityPK that = (TeamSelectionEntityPK) o;

        if (idteamSelection != that.idteamSelection) return false;
        if (iduser != that.iduser) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idteamSelection;
        result = 31 * result + iduser;
        return result;
    }
}
