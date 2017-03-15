package lt.vu.entities;

/**
 * Created by Aiste on 2017-03-15.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Getter
@Setter
@EqualsAndHashCode (of = "uzsakymoNr")
@ToString ( of = "uzsakymoNr")

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



}
