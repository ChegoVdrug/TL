package org.command.execute;

public class Test {

    public static void main(String[] args) {
        Macro macro =  new Macro();
        macro.add(Commands.PRINT_HELLO);
        macro.add(Commands.PRINT_DATE);
        macro.add(Commands.PRINT_HELLO);
        macro.add(Commands.PRINT_NUMBER);
        macro.run();
    }
}
