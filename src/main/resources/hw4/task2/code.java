package hw4.task1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Map<String, Integer> keywordMap = readKeywordsFromFile("java_keywords.txt");

        byte[] bytes = Files.readAllBytes(getPath("code.java"));

        String text = new String(bytes, StandardCharsets.UTF_8);

        text = text.replaceAll("[\\p{Punct}&&[^_-]]+", "");
        String[] tokens = text.split("\\W+");

        for (String token : tokens) {
            if (keywordMap.containsKey(token)) {
                keywordMap.put(token, keywordMap.get(token) + 1);
            }
        }

        byte[] result = keywordMap.toString().getBytes();

        Files.write(getPath("result.txt"), result);

    }

    private static Map<String, Integer> readKeywordsFromFile(String fileName) throws IOException, URISyntaxException {
        Map<String, Integer> keywordMap = new HashMap<>();

        byte[] keywordBytes = Files.readAllBytes(getPath(fileName));

        String keywordString = new String(keywordBytes, StandardCharsets.UTF_8);
        String[] keywords = keywordString.split("\n");

        for (String keyword : keywords) {
            keywordMap.put(keyword, 0);
        }

        return keywordMap;
    }

    private static Path getPath(String name) throws URISyntaxException {
        Class<Main> cls = Main.class;
        URL url = cls.getResource(name);
        System.out.println(Paths.get(url.toURI()));
        return Paths.get(url.toURI());
    }
}
