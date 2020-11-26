package nl.hva.aquadisbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "driver", schema = "persistencepractise", catalog = "")
public class DriverEntity {
    private String firstname;
    private String lastname;
    private int cost;
    private int iddriver;

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "cost")
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
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

        DriverEntity that = (DriverEntity) o;

        if (cost != that.cost) return false;
        if (iddriver != that.iddriver) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + cost;
        result = 31 * result + iddriver;
        return result;
    }

    protected DriverEntity(){}

    public DriverEntity(String firstname, String lastname, int cost, int iddriver) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.cost = cost;
        this.iddriver = iddriver;
    }
}
