package lt.vu.entities;

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
@Table(name = "filmas")
@NamedQueries({
        @NamedQuery(name = "Filmas.findAll", query = "SELECT f FROM Filmas f"),
        @NamedQuery(name = "Filmas.findByFilmoId", query = "SELECT f FROM Filmas f WHERE f.filmoId = :filmoId"),
        @NamedQuery(name = "Filmas.findByPavadinimas", query = "SELECT f FROM Filmas f WHERE f.pavadinimas = :pavadinimas"),
        @NamedQuery(name = "Filmas.findByKategorija", query = "SELECT f FROM Filmas f WHERE f.kategorija = :kategorija"),
        @NamedQuery(name = "Filmas.findByKaina", query = "SELECT f FROM Filmas f WHERE f.kaina = :kaina"),
        @NamedQuery(name = "Filmas.findByMetai", query = "SELECT f FROM Filmas f WHERE f.metai = :metai")})

//TODO Lombok
public class Filmas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "filmo_id")
    private Integer filmoId;

    @Column(name = "pavadinimas")
    private String pavadinimas;
    @Column(name = "kategorija")
    private String kategorija;
    @Column(name = "kaina")
    private Short kaina;
    @Column(name = "metai")
    private Short metai;
    @JoinTable(name = "filmu_uzsakymas", joinColumns = {
            @JoinColumn(name = "filmo_id", referencedColumnName = "filmo_id")}, inverseJoinColumns = {
            @JoinColumn(name = "uzsakymo_nr", referencedColumnName = "uzsakymo_nr")})
    @ManyToMany
    private List<Uzsakymas> uzsakymasList;

    public Filmas() {
    }

    public Filmas(Integer filmoId) {
        this.filmoId = filmoId;
    }

    public Filmas(Integer filmoId, String pavadinimas) {
        this.filmoId = filmoId;
        this.pavadinimas = pavadinimas;
    }

    public Integer getFilmoId() {
        return filmoId;
    }

    public void setFilmoId(Integer filmoId) {
        this.filmoId = filmoId;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public Short getKaina() {
        return kaina;
    }

    public void setKaina(Short kaina) {
        this.kaina = kaina;
    }

    public Short getMetai() {
        return metai;
    }

    public void setMetai(Short metai) {
        this.metai = metai;
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
        hash += (filmoId != null ? filmoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filmas)) {
            return false;
        }
        Filmas other = (Filmas) object;
        if ((this.filmoId == null && other.filmoId != null) || (this.filmoId != null && !this.filmoId.equals(other.filmoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testinis.Filmas[ filmoId=" + filmoId + " ]";
    }

}
