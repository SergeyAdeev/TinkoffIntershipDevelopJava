package task3;

import util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Mobile {

    private static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static Util util = new Util();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] stringData = util.stringToArray(util.readString(reader));
            int lengthSim = util.parseStringToInt(stringData[0]);
            checkInputData(lengthSim);
            int widthSim = util.parseStringToInt(stringData[1]);
            checkInputData(widthSim);
            stringData = util.stringToArray(util.readString(reader));
            int lengthEnvelope = util.parseStringToInt(stringData[0]);
            checkInputData(lengthEnvelope);
            int widthEnvelope = util.parseStringToInt(stringData[1]);
            checkInputData(widthEnvelope);
            util.printResult(compareSizes(lengthSim, widthSim, lengthEnvelope, widthEnvelope));
        } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
            log.info(util.INPUT_ERROR);
        } catch (IllegalArgumentException e) {
            log.info(util.DATA_ERROR);
        }
    }

    private static void checkInputData(int data) {
        final int MAX_SIZE = 10000;
        final int MIN_SIZE = 1;
        if (data > MAX_SIZE || data < MIN_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static Boolean compareSizes(int lengthSim, int widthSim, int lengthEnvelope, int widthEnvelope) {
        return lengthSim <= lengthEnvelope && widthSim <= widthEnvelope ||
                lengthSim <= widthEnvelope && widthSim <= lengthEnvelope;
    }
}
