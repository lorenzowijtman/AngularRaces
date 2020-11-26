package nl.hva.aquadisbackend.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UsergroupEntityPK implements Serializable {
    private int iduser;
    private int idgroup;

    @Column(name = "iduser")
    @Id
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Column(name = "idgroup")
    @Id
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

        UsergroupEntityPK that = (UsergroupEntityPK) o;

        if (iduser != that.iduser) return false;
        if (idgroup != that.idgroup) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iduser;
        result = 31 * result + idgroup;
        return result;
    }
}
