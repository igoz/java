package hw3.task1;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CrazyLogger {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY : HH-mm");
    private StringBuilder log = new StringBuilder();

    public CrazyLogger() {
    }

    public void addMessage(String message) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.systemDefault());
        log.append(formatter.format(dateTime));
        log.append(String.format(" - %s;\n", message));
    }

    public List<String> findList(String s) {
        List<String> result = new ArrayList<>();

        if (log.length() == 0) return result;

        String[] lines = log.toString().split("\n");
        for (String line : lines) {
            if (line.toLowerCase().contains(s.toLowerCase())) {
                result.add(line);
            }
        }

        return result;
    }

    public String findStrings(String s) {
        StringBuilder builder = new StringBuilder();
        List<String> strings = findList(s);
        for (String string : strings) {
            builder.append(string);
        }

        return builder.toString();
    }
}
