/*
 Onepoint Ltd 2014
 */

package com.onepointltd.junit.rules.host;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to ignore all tests when there is a hostname match via JUnit rules.
 * @author onepoint
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface HostnameIgnore {

    /**
     * The list of names to check.
     * @return a list of names.
     */
    String[] names();

    /**
     * Inverts the logic order.
     * @return if {@code true} the logic is inverted, else not.
     */
    boolean not() default false;
}
