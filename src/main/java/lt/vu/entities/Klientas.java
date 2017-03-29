package lt.vu.entities;

/**
 * Created by Aiste on 2017-03-15.
 */

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "klientas")
@NamedQueries({
        @NamedQuery(name = "Klientas.findAll", query = "SELECT k FROM Klientas k"),
        @NamedQuery(name = "Klientas.findByKlientoNr", query = "SELECT k FROM Klientas k WHERE k.klientoNr = :klientoNr"),
        @NamedQuery(name = "Klientas.findByVardas", query = "SELECT k FROM Klientas k WHERE k.vardas = :vardas"),
        @NamedQuery(name = "Klientas.findByPavarde", query = "SELECT k FROM Klientas k WHERE k.pavarde = :pavarde"),
        @NamedQuery(name = "Klientas.findByTelefonas", query = "SELECT k FROM Klientas k WHERE k.telefonas = :telefonas")})




@Getter
@Setter
@EqualsAndHashCode (of = "klientoNr")
@ToString (of = {"klientoNr", "vardas", "pavarde"})

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


}
