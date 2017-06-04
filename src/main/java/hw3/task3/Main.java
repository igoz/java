package hw3.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Не смог придумать регулярку, которая бы правильно выделяла выражение с "Рис." из-за точки, поэтому делаю заменой
public class Main {
    public static void main(String[] args) throws URISyntaxException, UnsupportedEncodingException {
        InputStreamReader reader = new InputStreamReader(Main.class.getClassLoader().
                getResourceAsStream("text.html"), "windows-1251");

        int lastImgIdx = 0;
        int currImgIdx = 0;
        boolean isOrder = true;

        try (BufferedReader br = new BufferedReader(reader)) {
            Pattern orderPattern = Pattern.compile("\\([Рр]ис(\\. )(\\d+)([^)]*)\\)");
            Pattern sentencePattern = Pattern.compile("([А-Я][^.]*)\\([Рр]ис( )(\\d+)([^)]*)\\)[^.]*\\.");

            //Создается много строк, не придумал как избежать
            while (br.ready()) {
                String line1 = br.readLine();
                if (line1 == null) {
                    break;
                }
                String line2 = br.readLine();
                String result;
                if (line2 != null) {
                    result = line1 + line2;
                } else {
                    result = line1;
                }

                Matcher matcher = orderPattern.matcher(result);
                if (matcher.find()) {
                    if (isOrder) {
                        lastImgIdx = currImgIdx;
                        currImgIdx = Integer.parseInt(matcher.group(2));

                        System.out.println(matcher.group(2));

                        if (currImgIdx - lastImgIdx != 1 && lastImgIdx != 0) {
                            System.out.println("Ссылки на рисунки не последовательны.");
//                            isOrder = false;
                        }
                        System.out.println("found: " + matcher.group(0).replace(".", ""));

                        String replaced = matcher.replaceAll(matcher.group(0).replace(".", ""));
                        Matcher matcherSentence = sentencePattern.matcher(replaced);
                        if (matcherSentence.find()) {
                                System.out.println(matcherSentence.group(0));
                        }
                    }
                }
            }
//            Matcher matcher = pattern.matcher(result);
//            while (matcher.find()) {
//                System.out.println(matcher.group());
//                System.out.println();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}