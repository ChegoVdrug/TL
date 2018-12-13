package org.command.execute;

import java.util.ArrayList; // enum не нужен, в лист добавляем сразу команды

class Macro {
    private ArrayList<Command> commandChain = new ArrayList<>();

    void add(Command cmd){
        commandChain.add(cmd);
    }

    void run(){
        for (Command command : commandChain) {
            command.execute();
        }
    }
   /*
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
}
