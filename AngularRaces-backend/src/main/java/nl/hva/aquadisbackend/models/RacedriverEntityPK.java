package nl.hva.aquadisbackend.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RacedriverEntityPK implements Serializable {
    private int idrace;
    private int iddriver;

    @Column(name = "idrace")
    @Id
    public int getIdrace() {
        return idrace;
    }

    public void setIdrace(int idrace) {
        this.idrace = idrace;
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

        RacedriverEntityPK that = (RacedriverEntityPK) o;

        if (idrace != that.idrace) return false;
        if (iddriver != that.iddriver) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idrace;
        result = 31 * result + iddriver;
        return result;
    }
}
