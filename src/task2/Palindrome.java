package task2;

import util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Palindrome {

    private static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static Util util = new Util();
    private static final int STRING_LENGTH = 10000;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String string = util.readString(reader);
            util.checkLength(string, STRING_LENGTH);
            string = parseString(string);
            util.printResult(isPalindrome(string));
        } catch (IOException e) {
            log.info(util.INPUT_ERROR);
        } catch (IllegalArgumentException e) {
            log.info(util.DATA_ERROR);
        }
    }

    private static Boolean isPalindrome(String string) {
        if (!string.equals("")) return string.equals(new StringBuffer(string).reverse().toString());
        else return false;
    }

    private static String parseString(String readString) {
        return readString.replaceAll("\\W|\\d", "").toLowerCase();
    }

}
//##Some%men interpret..nine<3MEMOS