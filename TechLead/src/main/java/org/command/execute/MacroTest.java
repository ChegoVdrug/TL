package org.command.execute;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MacroTest {
    private Macro macro = new Macro();
    private File file;

    @BeforeEach
    void before() {
        file = new File("stdout.log");
    }

    @Test
    void printHelloTest() throws FileNotFoundException {

        //file.delete();
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("stdout.log")), true));
        macro.add(new PrintHello("hello"));
        macro.run();
        String result = getTextFromFile(file);

        assertEquals(result, "hello\n");

    }

    @Test
    void printHelloNumberTest() throws FileNotFoundException {
        //File file = new File("stdout.log");
        //file.delete();
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("stdout.log")), true));
        macro.add(new PrintHello("hello-bum"));
        macro.add(new PrintNumber());
        macro.run();
        String result = getTextFromFile(file);

        assertEquals(result, "hello-bum\n" + "100\n");

    }

    @Test
    void printHelloNumberDateTest() throws FileNotFoundException {
        //   File file = new File("stdout.log");
        //  file.delete();
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("stdout.log")), true));
        macro.add(new PrintHello("QWERTY"));
        macro.add(new PrintNumber());
        macro.add(new PrintDate());
        macro.run();
        String result = getTextFromFile(file);

        assertEquals(result, "QWERTY\n" + "100\n" + PrintDate.date + "\n");

    }

    private String getTextFromFile(File file) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        Scanner in = new Scanner(file);
        while (in.hasNext())
            result.append(in.nextLine()).append("\n");
        in.close();
        return result.toString();
    }

}
