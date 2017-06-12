package hw5.task2;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

public class Main {
    static Properties properties = new Properties();

    public static void main(String[] args) {
        try {
            String fileName = "file.properties";
            properties.load(getStream(fileName));
            String key = "key";
            String property = properties.getProperty(key, "");
            if (property.equals("")) {
                System.out.println(key + " was not found in " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static InputStream getStream(String name) throws URISyntaxException {
        Class<Main> cls = Main.class;
        return cls.getResourceAsStream(name);
    }
}
