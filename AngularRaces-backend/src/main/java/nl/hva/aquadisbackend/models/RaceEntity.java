package nl.hva.aquadisbackend.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "race", schema = "persistencepractise", catalog = "")
public class RaceEntity {
    private int idrace;
    private Timestamp date;
    private String location;
    private int idgroup;

    @Id
    @Column(name = "idrace")
    public int getIdrace() {
        return idrace;
    }

    public void setIdrace(int idrace) {
        this.idrace = idrace;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "idgroup")
    public int getIdgroup() {
        return idgroup;
    }

    public void setIdgroup(int idgroup) {
        this.idgroup = idgroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceEntity that = (RaceEntity) o;

        if (idrace != that.idrace) return false;
        if (idgroup != that.idgroup) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idrace;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + idgroup;
        return result;
    }

    protected RaceEntity(){};

    public RaceEntity(int idrace, Timestamp date, String location, int idgroup) {
        this.idrace = idrace;
        this.date = date;
        this.location = location;
        this.idgroup = idgroup;
    }
}
