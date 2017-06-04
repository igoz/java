package hw4.task3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> text = Files.readAllLines(getPath("hw4/task1/code.java"));

        StringBuilder sb = new StringBuilder();
        for (String s : text) {
            sb.append(s + "\n");
        }
        String result = sb.toString();
        Files.write(getPath("hw4/task3/result.txt"), result.getBytes("UTF-16"));
    }

    private static Path getPath(String name) throws URISyntaxException {
        Class<Main> cls = Main.class;
        URL url = cls.getClassLoader().getResource(name);
        System.out.println(Paths.get(url.toURI()));
        return Paths.get(url.toURI());
    }
}
