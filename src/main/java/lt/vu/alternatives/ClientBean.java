package lt.vu.alternatives;

import lombok.Getter;
import lombok.Setter;
import lt.vu.decorator.RegularClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Aiste on 2017-05-06.
 */
@ApplicationScoped
@Named
@Setter
@Getter
public class ClientBean {

    private String clientType = null;
    private String ClientType2 = null;

    @Inject
    Typer typer;
//
//@Inject
//    TyperDK typerDK;

    public String typeString() {
        setClientType(typer.typeString());
        lt.vu.decorator.RegularClient rg = new RegularClient();
        rg.typeString1();
        //goldClient.extraTypeString();
        //System.out.println(goldClient.printer());
        return getClientType();

    }

//    public String typeString1(){
//        setClientType2(typerDK.typeString1());
//        return getClientType2();
//    }



}
