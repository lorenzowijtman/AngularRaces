package nl.hva.aquadisbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "team_selectiondriver", schema = "persistencepractise", catalog = "")
@IdClass(TeamSelectiondriverEntityPK.class)
public class TeamSelectiondriverEntity {
    private int idteamSelection;
    private int iduser;
    private int iddriver;

    @Id
    @Column(name = "idteam_selection")
    public int getIdteamSelection() {
        return idteamSelection;
    }

    public void setIdteamSelection(int idteamSelection) {
        this.idteamSelection = idteamSelection;
    }

    @Id
    @Column(name = "iduser")
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Id
    @Column(name = "iddriver")
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

        TeamSelectiondriverEntity that = (TeamSelectiondriverEntity) o;

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

    protected TeamSelectiondriverEntity(){};

    public TeamSelectiondriverEntity(int idteamSelection, int iduser, int iddriver) {
        this.idteamSelection = idteamSelection;
        this.iduser = iduser;
        this.iddriver = iddriver;
    }
}
