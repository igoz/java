package hw5.task1;

import java.util.Scanner;

public class Command {
    private Scanner sc = new Scanner(System.in);
    private String command;
    private String path;

    public void readCommand() throws CommandFormatException {
        String[] tokens = sc.nextLine().split(" ");

        if (tokens.length == 1 && isNoArgsCommand(tokens[0])) {
            command = tokens[0];
            path = "";
        }

        if (tokens.length == 2) {
            command = tokens[0];
            path = tokens[1];
        } else {
            throw new CommandFormatException(tokens[0]);
        }
    }

    private boolean isNoArgsCommand(String token) {
        return token.equals("help") || token.equals("stop");
    }

    public String getCommand() {
        return command;
    }

    public String getPath() {
        return path;
    }

    public class CommandFormatException extends Throwable {
        public CommandFormatException(String command) {
            System.out.printf("%s was not found. Type \"help\" to see the list of available commands.", command);
        }
    }
}
