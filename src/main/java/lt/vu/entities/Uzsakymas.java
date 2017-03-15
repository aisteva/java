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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aiste
 */
@Entity
@Table(name = "uzsakymas")
@NamedQueries({
        @NamedQuery(name = "Uzsakymas.findAll", query = "SELECT u FROM Uzsakymas u"),
        @NamedQuery(name = "Uzsakymas.findByUzsakymoNr", query = "SELECT u FROM Uzsakymas u WHERE u.uzsakymoNr = :uzsakymoNr"),
        @NamedQuery(name = "Uzsakymas.findByPaemimoData", query = "SELECT u FROM Uzsakymas u WHERE u.paemimoData = :paemimoData"),
        @NamedQuery(name = "Uzsakymas.findByGrazinimoData", query = "SELECT u FROM Uzsakymas u WHERE u.grazinimoData = :grazinimoData")})

//TODO Lombok
public class Uzsakymas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "uzsakymo_nr")
    private Integer uzsakymoNr;

    @Column(name = "paemimo_data")
    @Temporal(TemporalType.DATE)
    private Date paemimoData;

    @Column(name = "grazinimo_data")
    @Temporal(TemporalType.DATE)
    private Date grazinimoData;
    @ManyToMany(mappedBy = "uzsakymasList")
    private List<Filmas> filmasList;
    @JoinColumn(name = "kliento_nr", referencedColumnName = "kliento_nr")
    @ManyToOne(optional = false)
    private Klientas klientoNr;

    public Uzsakymas() {
    }

    public Uzsakymas(Integer uzsakymoNr) {
        this.uzsakymoNr = uzsakymoNr;
    }

    public Uzsakymas(Integer uzsakymoNr, Date paemimoData, Date grazinimoData) {
        this.uzsakymoNr = uzsakymoNr;
        this.paemimoData = paemimoData;
        this.grazinimoData = grazinimoData;
    }

    public Integer getUzsakymoNr() {
        return uzsakymoNr;
    }

    public void setUzsakymoNr(Integer uzsakymoNr) {
        this.uzsakymoNr = uzsakymoNr;
    }

    public Date getPaemimoData() {
        return paemimoData;
    }

    public void setPaemimoData(Date paemimoData) {
        this.paemimoData = paemimoData;
    }

    public Date getGrazinimoData() {
        return grazinimoData;
    }

    public void setGrazinimoData(Date grazinimoData) {
        this.grazinimoData = grazinimoData;
    }

    public List<Filmas> getFilmasList() {
        return filmasList;
    }

    public void setFilmasList(List<Filmas> filmasList) {
        this.filmasList = filmasList;
    }

    public Klientas getKlientoNr() {
        return klientoNr;
    }

    public void setKlientoNr(Klientas klientoNr) {
        this.klientoNr = klientoNr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uzsakymoNr != null ? uzsakymoNr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uzsakymas)) {
            return false;
        }
        Uzsakymas other = (Uzsakymas) object;
        if ((this.uzsakymoNr == null && other.uzsakymoNr != null) || (this.uzsakymoNr != null && !this.uzsakymoNr.equals(other.uzsakymoNr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testinis.Uzsakymas[ uzsakymoNr=" + uzsakymoNr + " ]";
    }

}
