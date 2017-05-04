package lt.vu.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//LABA DIENA
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.johnzon.mapper.JohnzonIgnore;

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
        @NamedQuery(name = "Filmas.findByMetai", query = "SELECT f FROM Filmas f WHERE f.metai = :metai")
})



@Getter
@Setter
@EqualsAndHashCode(of = "pavadinimas")
@ToString ( of = {"filmoId", "pavadinimas"})

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

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;

    @JoinTable(name = "filmu_uzsakymas", joinColumns = {
            @JoinColumn(name = "filmo_id", referencedColumnName = "filmo_id")}, inverseJoinColumns = {
            @JoinColumn(name = "uzsakymo_nr", referencedColumnName = "uzsakymo_nr")})
    @ManyToMany
    @JohnzonIgnore
    private List<Uzsakymas> uzsakymasList;




}
