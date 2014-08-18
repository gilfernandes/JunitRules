/*
 OSSCUBE 2014
 */

package com.onepointltd.junit.rules.host;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * Used to check the hostname rule.
 * @author onepoint
 */
@HostnameIgnore(names = {"bogus"}, not=true) // Means: if the host name is not bogus ignore.
public class HostnameCheckRuleIgnoreTest2 {

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
