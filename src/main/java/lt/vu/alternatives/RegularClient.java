package lt.vu.alternatives;

import javax.enterprise.inject.Alternative;

/**
 * Created by Aiste on 2017-05-06.
 */
@Alternative
public class RegularClient implements Typer {
    @Override
    public String typeString(){
        System.out.println();
        return "Regular client";
    }
}
