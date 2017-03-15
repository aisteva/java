package lt.vu.entities;

/**
 * Created by Aiste on 2017-03-15.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Aiste
 */
@Entity
@Table(name = "klientas")
@NamedQueries({
        @NamedQuery(name = "Klientas.findAll", query = "SELECT k FROM Klientas k"),
        @NamedQuery(name = "Klientas.findByKlientoNr", query = "SELECT k FROM Klientas k WHERE k.klientoNr = :klientoNr"),
        @NamedQuery(name = "Klientas.findByVardas", query = "SELECT k FROM Klientas k WHERE k.vardas = :vardas"),
        @NamedQuery(name = "Klientas.findByPavarde", query = "SELECT k FROM Klientas k WHERE k.pavarde = :pavarde"),
        @NamedQuery(name = "Klientas.findByTelefonas", query = "SELECT k FROM Klientas k WHERE k.telefonas = :telefonas")})


//TODO lombok
public class Klientas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "kliento_nr")
    private Integer klientoNr;

    @Column(name = "vardas")
    private String vardas;

    @Column(name = "pavarde")
    private String pavarde;

    @Column(name = "telefonas")
    private String telefonas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klientoNr")
    private List<Uzsakymas> uzsakymasList;

    public Klientas() {
    }

    public Klientas(Integer klientoNr) {
        this.klientoNr = klientoNr;
    }

    public Klientas(Integer klientoNr, String vardas, String pavarde, String telefonas) {
        this.klientoNr = klientoNr;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.telefonas = telefonas;
    }

    public Integer getKlientoNr() {
        return klientoNr;
    }

    public void setKlientoNr(Integer klientoNr) {
        this.klientoNr = klientoNr;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getTelefonas() {
        return telefonas;
    }

    public void setTelefonas(String telefonas) {
        this.telefonas = telefonas;
    }

    public List<Uzsakymas> getUzsakymasList() {
        return uzsakymasList;
    }

    public void setUzsakymasList(List<Uzsakymas> uzsakymasList) {
        this.uzsakymasList = uzsakymasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klientoNr != null ? klientoNr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klientas)) {
            return false;
        }
        Klientas other = (Klientas) object;
        if ((this.klientoNr == null && other.klientoNr != null) || (this.klientoNr != null && !this.klientoNr.equals(other.klientoNr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testinis.Klientas[ klientoNr=" + klientoNr + " ]";
    }

}
