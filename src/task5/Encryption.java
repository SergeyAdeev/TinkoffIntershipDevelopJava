package task5;

import util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.lang.Math.abs;

public class Encryption {

    private static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static final int DATA_COUNT = 34;
    private static final int STRING_LENGTH = 100;

    private static Util util = new Util();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String string = util.readString(reader);
            util.checkLength(string, STRING_LENGTH);
            int cipher = abs(util.parseStringToInt(string));
            System.out.println(decrypt(cipher));
        } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
            log.info(util.INPUT_ERROR);
        } catch (IllegalArgumentException e) {
            log.info(util.DATA_ERROR);
        }
    }

    private static int decrypt(int cipher) {
        List<Integer> tableCiphers = fillTableCiphers();
        return checkVariations(cipher, tableCiphers);
    }

    private static int checkVariations(int cipher, List<Integer> tableCiphers) {
        int countVariations = 1;

        while (cipher > 0) {
            if (tableCiphers.contains(cipher % 100) && tableCiphers.contains(cipher / 10 % 100)) {
                countVariations = countVariations * 3;
                cipher = cipher / 100;
            } else if (tableCiphers.contains(cipher % 100)) {
                countVariations = countVariations * 2;
                cipher = cipher / 10;
            } else {
                cipher = cipher / 10;
            }
        }
        return countVariations;
    }

    private static List<Integer> fillTableCiphers() {
        List<Integer> tableCiphers = new ArrayList<>();
        for (int i = 10; i < DATA_COUNT; i++) {
            tableCiphers.add(i);
        }
        return tableCiphers;
    }
}