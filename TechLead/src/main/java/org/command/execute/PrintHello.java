package org.command.execute;

public class PrintHello implements  Command{
    @Override
    public void execute() {
        System.out.println("Hello");
    }
}
