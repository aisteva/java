package lt.vu.alternatives;

import javax.enterprise.inject.Alternative;

/**
 * Created by Aiste on 2017-05-06.
 */
//@Specializes
@Alternative
public class LoyalGoldClient extends GoldClient{

    public LoyalGoldClient(){

    }

    public String typeString(){
        System.out.println();
        return "Loyal gold client";
    }

    @Override
    public String printer(){
        return "LOYAL GOLD";
    }

}
