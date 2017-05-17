package lt.vu.alternatives;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * Created by Aiste on 2017-05-06.
 */

@Decorator
public abstract class TypeDecorator implements Typer {


    @Inject
    @Delegate
    @Any
    private Typer typer;

    public String typeString() {
        System.out.println("Pridedamas funkcionalumas");
        System.out.println(typer.typeString()+ ": nurodomas elementas papildytas");
        return typer.typeString();
    }
}
