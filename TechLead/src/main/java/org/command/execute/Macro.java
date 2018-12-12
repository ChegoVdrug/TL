package org.command.execute;

import java.util.ArrayList;

public class Macro {
    ArrayList<Commands> commandChain = new ArrayList<>();

    void add(Commands cmd){
        commandChain.add(cmd);
    }
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
}
