package nl.hva.aquadisbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "usergroup", schema = "persistencepractise", catalog = "")
@IdClass(UsergroupEntityPK.class)
public class UsergroupEntity {
    private int iduser;
    private int idgroup;
    private byte isAdmin;

    @Id
    @Column(name = "iduser")
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Id
    @Column(name = "idgroup")
    public int getIdgroup() {
        return idgroup;
    }

    public void setIdgroup(int idgroup) {
        this.idgroup = idgroup;
    }

    @Basic
    @Column(name = "is_admin")
    public byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsergroupEntity that = (UsergroupEntity) o;

        if (iduser != that.iduser) return false;
        if (idgroup != that.idgroup) return false;
        if (isAdmin != that.isAdmin) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iduser;
        result = 31 * result + idgroup;
        result = 31 * result + (int) isAdmin;
        return result;
    }
    protected UsergroupEntity(){}
    public UsergroupEntity(int iduser, int idgroup, byte isAdmin) {
        this.iduser = iduser;
        this.idgroup = idgroup;
        this.isAdmin = isAdmin;
    }
}
