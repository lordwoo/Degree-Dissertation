
package framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to annotate fields in subclasses of {@link Form} to indicate that they
 * represent fields in the underlying web form, and to define any basic
 * validation rules that should be used as part of the form validation
 * component.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FormField
{
    /**
     * The name that will be used in any error messages generated for this
     * field.
     */
    String displayName();

    /**
     * Declares whether or not the field is required.
     */
    boolean required() default true;

    /**
     * The minimum length for text fields.
     */
    int minLength() default 0;

    /**
     * The maximum length for text fields.
     */
    int maxLength() default Integer.MAX_VALUE;

    /**
     * The minimum value for numerical fields.
     */
    double min() default Double.MIN_VALUE;

    /**
     * The maximum value for numerical fields.
     */
    double max() default Double.MAX_VALUE;
}
