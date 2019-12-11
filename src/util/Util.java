package util;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {
    public final String INPUT_ERROR = "Ошибка ввода";
    public final String DATA_ERROR = "Введенные данные не соответствуют условию задачи";

    public String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    public String[] stringToArray(String string) {
        return string.split(" ");
    }

    public int parseStringToInt(String string) {
        return Integer.parseInt(string);
    }

    public void checkLength(String string, int maxLength) {
        if (string.length() > maxLength) {
            throw new IllegalArgumentException();
        }
    }

    public void printResult(Boolean isCondition) {
        String YES = "YES";
        String NO = "NO";
        System.out.println(isCondition ? YES : NO);
    }
}
