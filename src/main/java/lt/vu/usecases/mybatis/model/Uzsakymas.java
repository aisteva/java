package lt.vu.usecases.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
public class Uzsakymas {

    private Integer uzsakymoNr;
    private Date paemimoData;
    private Date grazinimoData;
    private Short klientoNr;

    //ManyToMany and ManyToOne
    private List<Filmas> filmasList;
    private Klientas klientas;

}