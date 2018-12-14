package org.web.proxy;

public class WebResource {
    private String urlAddress;

    @Override
    public String toString() {
        return "WebResource{" +
                "urlAddress='" + urlAddress + '\'' +
                '}';
    }

    WebResource(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    String GetContent() {
        return "Content: " + urlAddress;
    }
}
