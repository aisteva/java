package lt.vu.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Aiste on 2017-05-06.
 */
@Named
@Decorator
public abstract class TypeDecorator implements TyperDK{

    @Inject
    @Delegate
    @Any
    TyperDK typer;

    public String typeString() {
        return "KĄ ČIA DARO? "+ typer.typeString();
    }
}
