package lt.vu.decorator;

/**
 * Created by Aiste on 2017-05-10.
 */
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@javax.inject.Qualifier
@java.lang.annotation.Retention(RUNTIME)
@java.lang.annotation.Target({METHOD, TYPE, FIELD})
@java.lang.annotation.Documented
public @interface ClientProcessor {
}
