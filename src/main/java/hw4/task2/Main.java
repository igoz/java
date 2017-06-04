package hw4.task2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(getFile("java_keywords.txt"));
        BufferedReader br = new BufferedReader(fr);
        Map<String, Integer> keywordMap = new HashMap<>();

        while (br.ready()) {
            String keyword = br.readLine();
            if (keyword == null) {
                break;
            }

            keywordMap.put(keyword, 0);
        }

        br.close();
        fr.close();

        fr = new FileReader(getFile("code.java"));
        br = new BufferedReader(fr);

        while (br.ready()) {
            String line = br.readLine();
            if (line == null) {
                break;
            }

            line = line.replaceAll("[\\p{Punct}&&[^_-]]+", " ");
            String[] tokens = line.split(" ");

            for (String token : tokens) {
                if (keywordMap.containsKey(token)) {
                    keywordMap.put(token, keywordMap.get(token) + 1);
                }
            }

        }

        br.close();
        fr.close();

        FileWriter fw = new FileWriter(getFile("result.txt"));
        fw.write(keywordMap.toString());
        fw.close();
    }

    private static File getFile(String fileName) {
        String file = Main.class.getResource(fileName).getFile();
        return new File(file);
    }
}
