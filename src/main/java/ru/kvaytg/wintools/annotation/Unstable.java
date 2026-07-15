package ru.kvaytg.wintools.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks an element as unstable, indicating its behavior
 * or implementation may change or it may not work reliably.
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Unstable {

    /**
     * Optional description explaining the instability or caveats.
     *
     * @return warning message or note
     */
    String value() default "This element is unstable and may not work as intended.";

}