package hw5.task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSystemWorker {
    static public void printDirectoryContent(String directory) {
        List<String> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException ex) {

        }

        for (String fileName : fileNames) {
            File file = new File(fileName);
            if (file.isDirectory()) {
                System.out.println("dir " + file);
            } else {
                System.out.println("file " + file);
            }
        }
    }

    static public void printFile(String path) throws NotFileException {
        File file = new File(path);
        if (!file.isFile()) {
            throw new NotFileException();
        }
        try {
            Files.lines(Paths.get(path)).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Problem occurred when reading from " + path);
        }
    }

    static public void createFile(String file) {
        Path path = Paths.get(file + ".txt");
        if (Files.exists(path)) {

        } else {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("Problem occurred when creating " + path);
            }
        }
    }

    static public void appendToFile(String filePath) {
        Path path = Paths.get(filePath);
        File file = new File(filePath);

        Scanner sc = new Scanner(System.in);

        if (Files.exists(path) && file.canWrite()) {
            StringBuilder fileContent = new StringBuilder();
            try {
                Files.lines(path).forEach(fileContent::append);
                if (fileContent.length() > 0) {
                    System.out.println(fileContent);
                }

                while (!sc.next().equals("-end")) {
                    fileContent.append(sc.nextLine());
                }
            } catch (IOException e) {
                System.out.println("Problem occurred when appending to" + path);
            }
        } else {

        }
    }

    static public void deleteFile(String filePath) {
        Path path = Paths.get(filePath);
        File file = new File(filePath);

        if (Files.exists(path) && file.canWrite()) {
            try {
                Files.delete(path);
            } catch (NoSuchFileException x) {
                System.err.format("%s: no such" + " file or directory%n", path);
            } catch (DirectoryNotEmptyException x) {
                System.err.format("%s not empty%n", path);
            } catch (IOException x) {
                System.err.println(x);
            }
        } else {

        }
    }

    public static class NotFileException extends Throwable {
        public NotFileException() {
            System.out.println("No file with a given path.");
        }
    }
}
