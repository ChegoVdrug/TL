package org.command.execute;

public class PrintHello implements  Command{
    String massage;
    PrintHello(String massage) {
        this.massage=massage;
    }

    @Override
    public void execute() {
        System.out.println(massage); // передавать текст
    }

    @Override
    public String toString() {
        return "PrintHello";
    }


  /*  public String toString() {
        return "PrintHello" +
                "massage='" + massage + '\'' +
                '}';
    }
    */
}
