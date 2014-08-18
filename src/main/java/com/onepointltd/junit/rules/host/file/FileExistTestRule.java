/*
 OSSCUBE 2014
 */
package com.onepointltd.junit.rules.host.file;

import com.onepointltd.junit.rules.IgnoreStatement;
import java.io.File;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Annotation based rule for ignoring tests on the basis of the existence of a file.
 * @author onepoint
 */
public class FileExistTestRule implements TestRule {

    @Override
    public Statement apply(Statement statement, Description description) {
        FileExistTest annotation = description.getAnnotation(FileExistTest.class);
        final Class<?> testClass = description.getTestClass();
        if(annotation == null) {
            annotation = testClass.getAnnotation(FileExistTest.class);
        }
        if (annotation == null) {
            return statement;
        }
        // TODO: check also the not argument.
        String[] files = annotation.value();
        boolean notExist = checkNotExist(files);
        if (notExist) {
            return new IgnoreStatement(this.getClass());
        }
        return statement;
    }

    /**
     * Checks, if any of the files does not exist.
     * @param files The files to be checked for their existence.
     * @return {@code true} if none of the files exists, {@code false} if at least one exists.
     */
    private boolean checkNotExist(String[] files) {
        for(String file : files) {
            if(new File(file).exists()) {
                return false;
            }
        }
        return true;
    }

}
