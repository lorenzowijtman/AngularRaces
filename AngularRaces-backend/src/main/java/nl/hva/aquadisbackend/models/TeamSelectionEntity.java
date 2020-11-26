package nl.hva.aquadisbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "team_selection", schema = "persistencepractise", catalog = "")
@IdClass(TeamSelectionEntityPK.class)
public class TeamSelectionEntity {
    private int idteamSelection;
    private String name;
    private int budget;
    private int verstappenPosition;
    private int iduser;
    private int idgroup = 239;

    @Id
    @GeneratedValue
    @Column(name = "idteam_selection")
    public int getIdteamSelection() {
        return idteamSelection;
    }

    public void setIdteamSelection(int idteamSelection) {
        this.idteamSelection = idteamSelection;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "budget")
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "verstappen_position")
    public int getVerstappenPosition() {
        return verstappenPosition;
    }

    public void setVerstappenPosition(int verstappenPosition) {
        this.verstappenPosition = verstappenPosition;
    }

    @Id
    @Column(name = "iduser")
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

        TeamSelectionEntity that = (TeamSelectionEntity) o;

        if (idteamSelection != that.idteamSelection) return false;
        if (budget != that.budget) return false;
        if (verstappenPosition != that.verstappenPosition) return false;
        if (iduser != that.iduser) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idteamSelection;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + budget;
        result = 31 * result + verstappenPosition;
        result = 31 * result + iduser;
        return result;
    }

    protected TeamSelectionEntity(){}

    public TeamSelectionEntity( String name, int budget, int verstappenPosition, int iduser) {
        this.name = name;
        this.budget = budget;
        this.verstappenPosition = verstappenPosition;
        this.iduser = iduser;
        this.idgroup = 239;
    }
}
