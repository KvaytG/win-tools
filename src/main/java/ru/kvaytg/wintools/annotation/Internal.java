package ru.kvaytg.wintools.annotation;

import java.lang.annotation.*;

/**
 * Indicates that the annotated element is for internal use only.
 * It is not part of the public API and may change at any time.
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Internal {}
