package org.command.execute;

import java.util.Date;

public class PrintDate implements  Command{
    @Override
    public void execute() {
        System.out.println(new Date().toString());
    }
}
