package org.command.execute;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Commands {

    Command createCommandByName(NodeList childNodes) {
        Node type = childNodes.item(1);
        String className = type.getChildNodes().item(0).getTextContent();
        switch (className) {
            case "PrintHello":
                return createPrintHello(childNodes);
            case "PrintDate":
                return createPrintDate();
            case "PrintNumber":
                return createPrintNumber();
        }
        return null;
    }

    private PrintHello createPrintHello(NodeList childNodes) {
        return new PrintHello(childNodes.item(3).getTextContent());
    }

    private PrintNumber createPrintNumber() {
        return new PrintNumber();
    }
    private PrintDate createPrintDate() {
        return new PrintDate();
    }

}
