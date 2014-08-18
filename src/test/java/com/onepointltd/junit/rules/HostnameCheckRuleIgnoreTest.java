/*
 OSSCUBE 2014
 */

package com.onepointltd.junit.rules;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * Used to check the hostname rule.
 * @author onepoint
 */
@HostnameIgnore(names = {"onepoint-17L"}) // Means: if the host if ... ignore
public class HostnameCheckRuleIgnoreTest {

    /**
     * Activates the rule.
     */
    @Rule
    public HostnameCheckRule rule = new HostnameCheckRule();

    @Test
    public void testName() {
        Assert.assertTrue("Just checking", true);
    }
}
