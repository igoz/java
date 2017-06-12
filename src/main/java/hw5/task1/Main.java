package hw5.task1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Command.CommandFormatException {
        Command command = new Command();
        StringBuilder help = new StringBuilder();
        try {
            Files.readAllLines(getPath("help.txt")).forEach(help::append);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        command.readCommand();

        while (!command.getCommand().equals("stop")) {
            switch (command.getCommand()) {
                case "dir":
                    FileSystemWorker.printDirectoryContent(command.getPath());
                    break;
                case "file":
                    try {
                        FileSystemWorker.printFile(command.getPath());
                    } catch (FileSystemWorker.NotFileException e) {

                    }
                    break;
                case "create":
                    FileSystemWorker.createFile(command.getPath());
                    break;
                case "append":
                    FileSystemWorker.appendToFile(command.getPath());
                    break;
                case "delete":
                    FileSystemWorker.deleteFile(command.getPath());
                    break;
                case "help" :
                    System.out.println(help);
                    break;
                case "stop":
                    System.exit(5);
                    break;
                default:
                    System.out.println("Command not found. Type \"help\" to see the list of available commands");
                    break;
            }

            command.readCommand();
        }
    }

    private static void printHelp() {
        try {
            Files.readAllLines(getPath("help.txt")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static Path getPath(String name) throws URISyntaxException {
        Class<Main> cls = Main.class;
        URL url = cls.getResource(name);
        return Paths.get(url.toURI());
    }
}
