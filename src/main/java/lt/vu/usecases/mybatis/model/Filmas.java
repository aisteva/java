package lt.vu.usecases.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Filmas {

    private Integer filmoId;
    private String pavadinimas;
    private String kategorija;
    private Short kaina;
    private Short metai;



    //ManyToMany
    private List<Uzsakymas> uzsakymasList;
}