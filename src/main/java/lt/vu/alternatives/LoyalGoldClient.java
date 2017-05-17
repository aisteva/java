package lt.vu.alternatives;

import javax.enterprise.inject.Specializes;

/**
 * Created by Aiste on 2017-05-06.
 */
@Specializes
public class LoyalGoldClient extends GoldClient{

    public LoyalGoldClient(){

    }

    @Override
    public String typeString(){

        return "Loyal gold client";
    }


}
