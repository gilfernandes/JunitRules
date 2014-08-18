/*
 OSSCUBE 2014
 */

package com.onepointltd.junit.rules.host;

import com.onepointltd.junit.rules.host.HostnameIgnore;
import com.onepointltd.junit.rules.host.HostnameCheckRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * Used to check the hostname rule.
 * @author onepoint
 */
@HostnameIgnore(names = {"onepoint-17L"}, not=true) // Means: if the host name is not ... ignore
public class HostnameCheckRuleIgnoreNotTest {

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
