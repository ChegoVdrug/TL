package org.command.execute;

import java.util.Date;

public class PrintDate implements  Command{
    static String date;
    @Override
    public void execute() {
        date = new Date().toString();
        System.out.println(date);
    }
}
