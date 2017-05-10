package lt.vu.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 * Created by Aiste on 2017-05-06.
 */

@Decorator
public abstract class TypeDecorator implements TyperDK {


    @Inject
    @Delegate
    @ClientProcessor
    private TyperDK typer;

    public String typeString1() {
        System.out.println("Pridedamas funkcionalumas");
        System.out.println(typer.typeString1()+ ": nurodomas elementas papildytas");
        return typer.typeString1();
    }
}
