/*
 OSSCUBE 2014
 */
package com.onepointltd.junit.rules.host;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Rule used to check the hostname.
 *
 * @author onepoint
 */
public class HostnameCheckRule implements TestRule {

    /**
     * Processes the annotation by checking the hostname.
     *
     * @param statement The statement to be returned in case the hostname check
     * fails.
     * @param description Used to access the annotations.
     * @return the {@code statement} parameter in case the match fails, else an
     * instance of the ignore statement.
     */
    @Override
    public Statement apply(Statement statement, Description description) {
        HostnameIgnore annotation = extractAnnotation(description);
        if (annotation == null) {
            return statement;
        }
        boolean not = annotation.not();
        String[] files = annotation.names();
        boolean match = nameMatch(files);
        if(not) {
            match = !match;
        }
        if (match) {
            return new IgnoreStatement(this.getClass());
        }
        return statement;
    }

    /**
     * First tries to extract the annotation from the method and then from the
     * class itself.
     *
     * @param description Used to access the annotations of the method OR the
     * annotations of the class.
     * @return The annotation instance.
     */
    private HostnameIgnore extractAnnotation(Description description) {
        HostnameIgnore annotation = description.getAnnotation(HostnameIgnore.class);
        if (annotation == null) {
            final Class<?> testClass = description.getTestClass();
            annotation = testClass.getAnnotation(HostnameIgnore.class);
        }
        return annotation;
    }

    /**
     * Checks, if the host name is contained in the {@code files} array.
     *
     * @param files The array with the possible host name ffor matches.
     * @return {@code true} in case the host name is contained in the
     * {@code files} array.
     */
    private boolean nameMatch(String[] files) {
        if (files == null) {
            return false;
        }
        String hostName = Hosts.INSTANCE.getHostname();
        for (String name : files) {
            if (name.equalsIgnoreCase(hostName)) {
                return true;
            }
        }
        return false;
    }

}
