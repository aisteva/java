package lt.vu.decorator;

/**
 * Created by Aiste on 2017-05-10.
 */
@ClientProcessor
public class RegularClient implements TyperDK {
    @Override
    public String typeString1() {
        System.out.println("Regular clientas");
        return "Regular client";
    }
}
