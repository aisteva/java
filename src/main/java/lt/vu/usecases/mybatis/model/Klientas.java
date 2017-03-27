package lt.vu.usecases.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Klientas {

    private Integer klientoNr;
    private String vardas;
    private String pavarde;
    private String telefonas;


    //OneToMany
    private List<Uzsakymas> uzsakymasList;
}