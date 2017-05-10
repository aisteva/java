package lt.vu.alternatives;

import javax.enterprise.inject.Alternative;

/**
 * Created by Aiste on 2017-05-06.
 */
@Alternative
public class LoyalGoldClient extends GoldClient{

    public LoyalGoldClient(){

    }

    @Override
    public String typeString(){

        return "Loyal gold client";
    }


}
