package org.perfcake.perfcontrol.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Put this on
 *
 * {@code private static PerfCakeController}
 *      field in your test class.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PerfControl {
    /**
     * Name of Scenario injected to the controller
     *
     */
    String scenario() default "";
}