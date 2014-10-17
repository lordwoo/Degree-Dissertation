
package framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to annotate methods in subclasses of {@link Form} to indicate that they
 * should be called by the framework as part of the form validation component.
 * Such methods should have no parameters, and a return type of {@code void}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Validation
{
}
