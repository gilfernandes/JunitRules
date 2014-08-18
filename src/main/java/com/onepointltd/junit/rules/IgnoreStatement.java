/*
 OSSCUBE 2014
 */

package com.onepointltd.junit.rules;

import org.junit.Assume;
import org.junit.runners.model.Statement;

/**
 * Use this statement in order to make tests being ignored.
 * @author onepoint
 * @param <T> The type of the test class to be ignored.
 */
public class IgnoreStatement<T> extends Statement {

    /**
     * Class on which the ignore is active.
     */
    private final Class<T> clazz;

    /**
     * Associates with the class on which the ignore is active.
     * @param clazz The class on which the ignore is active.
     */
    public IgnoreStatement(Class<T> clazz) {
        this.clazz = clazz;
    }


    @Override
    public void evaluate() throws Throwable {
        Assume.assumeTrue("Ignored by " + clazz.getSimpleName(), false);
    }

}
