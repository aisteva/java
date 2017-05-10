package lt.vu.alternatives;

import javax.enterprise.inject.Alternative;

/**
 * Created by Aiste on 2017-05-06.
 */
@Alternative
public class RegularClient implements Typer {

    public RegularClient(){}

    public String typeString(){

        return "Regular client";
    }



    public String typeString1() {
        return "regular dekor";
    }
}
