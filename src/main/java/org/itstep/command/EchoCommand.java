package org.itstep.command;

public class EchoCommand implements Command {

    @Override
    public void execute(String... args) {
        for (String arg : args) {
            arg = arg.replace("echo ", "");
            System.out.print(arg + " ");
        }
        System.out.println();
    }
}
