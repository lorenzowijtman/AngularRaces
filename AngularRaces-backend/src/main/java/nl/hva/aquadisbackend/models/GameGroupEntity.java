package nl.hva.aquadisbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "game_group", schema = "persistencepractise", catalog = "")
public class GameGroupEntity {
    private int idgroup;
    private String name;
    private int adminId;

    @Id
    @Column(name = "idgroup")
    public int getIdgroup() {
        return idgroup;
    }

    public void setIdgroup(int idgroup) {
        this.idgroup = idgroup;
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
    @Column(name = "admin_id")
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameGroupEntity that = (GameGroupEntity) o;

        if (idgroup != that.idgroup) return false;
        if (adminId != that.adminId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idgroup;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + adminId;
        return result;
    }

    protected GameGroupEntity() {};

    public GameGroupEntity(int idgroup, String name, int adminId) {
        this.idgroup = idgroup;
        this.name = name;
        this.adminId = adminId;
    }
}
