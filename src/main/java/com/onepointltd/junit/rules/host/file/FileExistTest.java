/*
 OSSCUBE 2014
 */

package com.onepointltd.junit.rules.host.file;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author onepoint
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface FileExistTest {

    String[] value();

    boolean not() default false;
}
