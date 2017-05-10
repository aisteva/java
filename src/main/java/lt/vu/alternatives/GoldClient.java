package lt.vu.alternatives;

import javax.enterprise.inject.Alternative;

/**
 * Created by Aiste on 2017-05-06.
 */


@Alternative
public class GoldClient implements Typer{

    public GoldClient() {

    }

    public String typeString() {

        return "Gold client";
    }


}
