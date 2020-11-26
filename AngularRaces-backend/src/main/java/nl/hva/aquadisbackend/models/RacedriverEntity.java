package nl.hva.aquadisbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "racedriver", schema = "persistencepractise", catalog = "")
@IdClass(RacedriverEntityPK.class)
public class RacedriverEntity {
    private int idrace;
    private int iddriver;
    private int startingPosition;
    private int finishPosition;
    private boolean finished;

    @Id
    @Column(name = "idrace")
    public int getIdrace() {
        return idrace;
    }

    public void setIdrace(int idrace) {
        this.idrace = idrace;
    }

    @Id
    @Column(name = "iddriver")
    public int getIddriver() {
        return iddriver;
    }

    public void setIddriver(int iddriver) {
        this.iddriver = iddriver;
    }

    @Basic
    @Column(name = "starting_position")
    public int getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(int startingPosition) {
        this.startingPosition = startingPosition;
    }

    @Basic
    @Column(name = "finish_position")
    public int getFinishPosition() {
        return finishPosition;
    }

    public void setFinishPosition(int finishPosition) {
        this.finishPosition = finishPosition;
    }

    @Basic
    @Column(name = "finished")
    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RacedriverEntity that = (RacedriverEntity) o;

        if (idrace != that.idrace) return false;
        if (iddriver != that.iddriver) return false;
        if (startingPosition != that.startingPosition) return false;
        if (finishPosition != that.finishPosition) return false;
        if (finished != that.finished) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idrace;
        result = 31 * result + iddriver;
        result = 31 * result + startingPosition;
        result = 31 * result + finishPosition;
        return result;
    }

    protected RacedriverEntity(){}

    public RacedriverEntity(int idrace, int iddriver, int startingPosition, int finishPosition, boolean finished) {
        this.idrace = idrace;
        this.iddriver = iddriver;
        this.startingPosition = startingPosition;
        this.finishPosition = finishPosition;
        this.finished = finished;
    }
}
