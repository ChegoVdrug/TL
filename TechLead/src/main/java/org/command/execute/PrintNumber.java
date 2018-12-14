package org.command.execute;

public class PrintNumber implements  Command {
    @Override
    public void execute() {
        System.out.println(100);
    }
}
