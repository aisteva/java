package lt.vu.decorator;

/**
 * Created by Aiste on 2017-05-10.
 */
@ClientProcessor
public class SpecialClient  implements TyperDK{

    @Override
    public String typeString1() {
        System.out.println("Speclialus klientas");
        return "Specialusis klientas";
    }
}
