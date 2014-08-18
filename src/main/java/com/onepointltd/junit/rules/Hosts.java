/*
 OSSCUBE 2014
 */

package com.onepointltd.junit.rules;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility used to get the host name with no exceptions.
 * @author onepoint
 */
public enum Hosts {

    INSTANCE;

    public String getHostname() {
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            return hostName;
        } catch (UnknownHostException ex) {
            Logger.getLogger(Hosts.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException("Could not determine the host name.", ex);
        }
    }
}
