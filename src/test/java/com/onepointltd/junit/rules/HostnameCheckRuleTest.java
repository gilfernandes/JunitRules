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
@HostnameIgnore(names = {"bogus"}) // Means: if the host name is "bogus" ignore.
public class HostnameCheckRuleTest {

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
