package nl.hva.aquadisbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "points", schema = "persistencepractise", catalog = "")
public class PointsEntity {
    private Integer gamePoints;
    private int idpoints;
    private UsergroupEntity usergroup;

    @Basic
    @Column(name = "game_points")
    public Integer getGamePoints() {
        return gamePoints;
    }

    public void setGamePoints(Integer gamePoints) {
        this.gamePoints = gamePoints;
    }

    @Id
    @Column(name = "idpoints")
    public int getIdpoints() {
        return idpoints;
    }

    public void setIdpoints(int idpoints) {
        this.idpoints = idpoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointsEntity that = (PointsEntity) o;

        if (idpoints != that.idpoints) return false;
        if (gamePoints != null ? !gamePoints.equals(that.gamePoints) : that.gamePoints != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gamePoints != null ? gamePoints.hashCode() : 0;
        result = 31 * result + idpoints;
        return result;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "iduser", referencedColumnName = "iduser", nullable = false), @JoinColumn(name = "idgroup", referencedColumnName = "idgroup", nullable = false)})
    public UsergroupEntity getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(UsergroupEntity usergroup) {
        this.usergroup = usergroup;
    }

    protected PointsEntity(){};

    public PointsEntity(Integer gamePoints, int idpoints, UsergroupEntity usergroup) {
        this.gamePoints = gamePoints;
        this.idpoints = idpoints;
        this.usergroup = usergroup;
    }
}
