package org.web.proxy;

import java.util.Hashtable;

class Proxy {
    private Hashtable<String, WebResource> webResources
            = new Hashtable<>();

    WebResource getResource(String urlAddress) {
        if (webResources.get(urlAddress) != null) {
            System.out.print("был в наличии: ");
        } else {
            System.out.print("новенький:");
            webResources.put(urlAddress, new WebResource(urlAddress));
        }
        return webResources.get(urlAddress);
    }
}