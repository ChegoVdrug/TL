package org.web.proxy;

public class Test {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        System.out.println(proxy.getResource("http///"));
        System.out.println(proxy.getResource("https://github.com/ChegoVdrug/TL/pull/5"));
        System.out.println(proxy.getResource("https://github.com"));
        System.out.println(proxy.getResource("http///"));
        System.out.println(proxy.getResource("https://github.com/ChegoVdrug/TL/pull/5").GetContent());
    }
}
