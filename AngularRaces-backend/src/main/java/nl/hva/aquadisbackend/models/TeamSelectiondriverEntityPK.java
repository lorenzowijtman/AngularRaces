package nl.hva.aquadisbackend.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TeamSelectiondriverEntityPK implements Serializable {
    private int idteamSelection;
    private int iduser;
    private int iddriver;

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

    @Column(name = "iddriver")
    @Id
    public int getIddriver() {
        return iddriver;
    }

    public void setIddriver(int iddriver) {
        this.iddriver = iddriver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamSelectiondriverEntityPK that = (TeamSelectiondriverEntityPK) o;

        if (idteamSelection != that.idteamSelection) return false;
        if (iduser != that.iduser) return false;
        if (iddriver != that.iddriver) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idteamSelection;
        result = 31 * result + iduser;
        result = 31 * result + iddriver;
        return result;
    }
}
