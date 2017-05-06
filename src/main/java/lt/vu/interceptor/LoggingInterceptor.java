package lt.vu.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

/**
 * Created by Aiste on 2017-05-06.
 */
@MyInterceptor  //binding the interceptor here. now any method annotated with @MyInterceptor would be intercepted by logMethodEntry
@Interceptor
public class LoggingInterceptor implements Serializable{

    private static final long serialVersionUID = 813L;

//    Every @AroundInvoke method takes a javax.interceptor.InvocationContext argument,
//    returns a java.lang.Object, and throws an Exception.
//    It can call InvocationContext methods.
// The @AroundInvoke method must call the proceed method, which causes the target class method to be invoked.

    @AroundInvoke
    public Object logMethodEntry(InvocationContext ctx) throws Exception {
        System.out.println("Entering method: " + ctx.getMethod().getName());
        return ctx.proceed();
    }
}
