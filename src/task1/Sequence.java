package task1;

import util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Sequence {

    private static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static Util util = new Util();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] stringData = util.stringToArray(util.readString(reader));
            int[] arrayOfNaturals = fillArray(util.parseStringToInt(stringData[0]));
            changeSequence(util.parseStringToInt(stringData[1]),
                    util.parseStringToInt(stringData[2]),
                    arrayOfNaturals);
            printResult(changeSequence(util.parseStringToInt(stringData[3]),
                    util.parseStringToInt(stringData[4]),
                    arrayOfNaturals));
        } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
            log.info(util.INPUT_ERROR);
        } catch (IllegalArgumentException e) {
            log.info(util.DATA_ERROR);
        }
    }

    private static void printResult(int[] arrayOfNaturals) {
        for (int number : arrayOfNaturals) {
            System.out.print(number + " ");
        }
    }

    private static int[] changeSequence(int x, int y, int[] arrayOfNaturals) {
        checkConditions(x, y, arrayOfNaturals.length);
        int[] temporaryArray = new int[y - x + 1];
        for (int i = 0; i < temporaryArray.length; i++) {
            temporaryArray[i] = arrayOfNaturals[y - 1];
            y--;
        }

        for (int value : temporaryArray) {
            arrayOfNaturals[x - 1] = value;
            x++;
        }
        return arrayOfNaturals;
    }

    private static void checkConditions(int x, int y, int length) {
        if (!(x > 0 && x < y && y < length)) {
            throw new IllegalArgumentException();
        }
    }

    private static int[] fillArray(int n) {
        checkCountNumbers(n);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    private static void checkCountNumbers(int n) {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 10000;
        if (n < MIN_NUMBER || n > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
