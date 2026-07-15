package ru.kvaytg.wintools.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks an element as dangerous, indicating it performs
 * a potentially harmful, irreversible, or system-level action.
 * Use with caution. May require explicit permission checks.
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Dangerous {

    /**
     * Optional description of the danger or side effects.
     *
     * @return a warning message or explanation
     */
    String value() default "This element performs a dangerous or irreversible action.";

}