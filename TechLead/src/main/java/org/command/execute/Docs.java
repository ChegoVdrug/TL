package org.command.execute;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Docs {

    Document getDocument(String inputFile1) throws SAXException, IOException, ParserConfigurationException {
        String inputFile = inputFile1;
        return DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().parse(new InputSource(inputFile));
    }
}
