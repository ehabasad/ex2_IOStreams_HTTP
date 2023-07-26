package pac;

import pac.command.Command;
import pac.execute.CommandExecutor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandExecutor executor = CommandExecutor.getInstance();
        while (true) {
            System.out.print("Enter a command: ");
            String input = scanner.nextLine();
            try {
                Command command = CommandParser.parseCommand(input);
                executor.execute(command);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


