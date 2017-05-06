package lt.vu.alternatives;

import javax.enterprise.inject.Alternative;

/**
 * Created by Aiste on 2017-05-06.
 */
@Alternative
public class GoldClient implements Typer {

    public GoldClient(){

    }
    @Override
    public String typeString() {

        System.out.println();
        return "Gold client";
    }

    public String printer(){
        return "Gold";
    }
}
