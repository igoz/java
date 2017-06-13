package hw6.task2;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Map, при добавлении нового значения с уже существующим ключом, перезаписывает существующую запись
 */
public class Main {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            String fileName = "file.properties";
            properties.load(getStream(fileName));

            Map<String, String> propertiesMap = new HashMap<>();

            for (String s : properties.stringPropertyNames()) {
                properties.put(s, properties.getProperty(s));
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
