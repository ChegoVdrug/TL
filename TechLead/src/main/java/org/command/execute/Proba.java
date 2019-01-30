package org.command.execute;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;


import com.thoughtworks.xstream.XStream;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
/*import org.command.execute.Model.Command;
import org.command.execute.Model.Commands;
import org.command.execute.Model.Macro;*/

public class Proba {
    public static void main(String[] args) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException, TransformerException {
        Macro macro = new Macro();
        macro.addCommandsFromXML("src\\main\\java\\org\\command\\execute/chain.xml");
        macro.run();


        //   macro.addCommandToXML(new PrintHello("hghg"));

 /*
        macro.add(new PrintNumber());
        macro.add(new PrintDate());
        macro.add(new PrintHello("jopa"));
        macro.add(new PrintHello("teatr Globus"));

        serilizationToXml(macro, "e:/file.xml");

        Macro macro2 = (Macro) deserilizationToXml("e:/file.xml");
        macro2.run();

*/
        //macro.run();

/*        Commands cmd = new Commands();
        cmd.Command.add(new Command("", "PrintDate"));
        cmd.Command.add(new Command("jjoppa", "PrintHello"));
        cmd.Command.add(new Command("ioo", "PrintHello"));

        Macro macro = new Macro();
        macro.Commands = cmd;*/

/*        XMLDecoder decoder = new XMLDecoder(
                new BufferedInputStream(
                        new FileInputStream("e:/execute.xml")
                )
        );

        Macro macro2 = (Macro) decoder.readObject();
        decoder.close();*/


    }

    public static void serilizationToXml(Object data, String path) throws IOException {
        XStream xmlwriter = new XStream();
        String xml = xmlwriter.toXML(data);
        FileWriter fw = new FileWriter(path);
        fw.write(xml);
        fw.flush();
        fw.close();

    }


    public static Object deserilizationToXml(String path) throws IOException {
        XStream xmlreader = new XStream();

        String data =readFile(path,Charset.defaultCharset());
        return xmlreader.fromXML(data);
    }

    public static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }



}
