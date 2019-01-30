package org.command.execute;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList; // enum не нужен, в лист добавляем сразу команды
import java.util.List;

public class Macro extends Commands{
Docs docs = new Docs();
    List<Command> commandChain = new ArrayList<>();


    void addCommandsFromXML(String inputFile1) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
Document doc = docs.getDocument(inputFile1);
        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList nodes = (NodeList)xpath.evaluate
                ("//command", doc, XPathConstants.NODESET);
        for(int i = 0; i<nodes.getLength();i++) {
            Node commandXml = nodes.item(i);
            NodeList childNodes = commandXml.getChildNodes();
            Command cmd = createCommandByName(childNodes);
            add(cmd);
        }
    }
    void add(Command cmd){

        commandChain.add(cmd);
    }
    void run() {
        for (Command command : commandChain) {
            command.execute();
        }
    /*  void addCommandToXML(Command command) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException, TransformerException {

          String inputFile = "src\\main\\java\\org\\command\\execute/chain.xml";
          Document doc = DocumentBuilderFactory.newInstance()
                  .newDocumentBuilder().parse(new InputSource(inputFile));

          XPath xpath = XPathFactory.newInstance().newXPath();
          NodeList commands = (NodeList)xpath.evaluate
                  ("//commands", doc, XPathConstants.NODESET);
          for(int i = 0; i<commands.getLength();i++) {

              System.out.println(commands.item(i).appendChild(doc.createElement("command"))
                      .appendChild(doc.createElement("type"))
                      .appendChild(doc.createTextNode(command.toString()))
                      .getParentNode().getParentNode().appendChild((doc.createElement("text")))
                      .appendChild(doc.createTextNode("hgjgjhgjg")));
              Transformer transformer = TransformerFactory.newInstance().newTransformer();
              transformer.transform
                      (new DOMSource(doc), new StreamResult(new File(inputFile)));

              }
          }
  */
    /* }

    void run(){
        for(int i = 0; i <commandChain.size(); i++) {
   //         System.out.println(commandChain.get(0));
            switch (commandChain.get(i)) {

                case PRINT_HELLO:
                    PrintHello printHello = new PrintHello();
                    printHello.execute();
                    break;
                case PRINT_DATE:
                    PrintDate printDate = new PrintDate();
                    printDate.execute();
                    break;
                case PRINT_NUMBER:
                    PrintNumber printNumber = new PrintNumber();
                    printNumber.execute();
                    break;
                    default:
                        System.out.println("ggggggggggggggg");
            }

        }
    }
    */

    }}