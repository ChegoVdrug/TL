package org.command.execute;

public class Test {

    public static void main(String[] args) {
        Macro macro =  new Macro();
        macro.add(new PrintHello("hello"));
        macro.add(new PrintDate());
        macro.add(new PrintHello("hi"));
        macro.add(new PrintNumber());
        macro.run();
    }
}
