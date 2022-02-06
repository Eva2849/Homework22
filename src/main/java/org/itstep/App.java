package org.itstep;

import java.util.Scanner;

import org.itstep.command.*;

public class App {
    public static void main(String[] args) {
        // Пишите ваш код здесь
        Scanner scanner = new Scanner(System.in);
        String text;
        System.out.println("Введите необходимую команду (help, echo <Ваш текст>, now, exit) после \">>>\" ");
        do {
            System.out.print(">>> ");
            text = scanner.nextLine();
            if (commandExists(text)) {
                commandExecution(text);
            }
        } while (!text.equals("exit"));
    }

    public static void commandExecution(String text) {
        Command help = new HelpCommand();
        Command echo = new EchoCommand();
        Command now = new NowCommand();
        Command exit = new ExitCommand();
        while (true) {
            if (text.equals("help")) {
                help.execute();
                break;
            }
            if (text.startsWith("echo")) {
                echo.execute(text);
                break;
            }
            if (text.equals("now")) {
                now.execute();
                break;
            }
            if (text.equals("exit")) {
                exit.execute();
                break;
            }
        }
    }

    public static boolean commandExists(String text) {
        if (text.equals("help") || text.startsWith("echo")
                || text.equals("now") || text.equals("exit")) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }
}
