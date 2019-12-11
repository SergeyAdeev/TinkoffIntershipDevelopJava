package task4;

import util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Rectangle {

    private static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static List<Cell> filledCells = new ArrayList<>();
    private static Util util = new Util();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = util.parseStringToInt(util.readString(reader));
            checkCountRectangles(n);
            String[] stringData;
            for (int i = 0; i < n; i++) {
                stringData = util.stringToArray(util.readString(reader));
                int x1 = util.parseStringToInt(stringData[0]);
                int y1 = util.parseStringToInt(stringData[1]);
                int x2 = util.parseStringToInt(stringData[2]);
                int y2 = util.parseStringToInt(stringData[3]);
                checkCoordinates(x1, y1, x2, y2);
                fillRectangle(x1, y1, x2, y2);
            }
            System.out.println(filledCells.size());
        } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
            log.info(util.INPUT_ERROR);
        } catch (IllegalArgumentException e) {
            log.info(util.DATA_ERROR);
        }
    }

    private static void checkCountRectangles(int n) {
        final int MIN_COUNT_RECTANGLES = 1;
        final int MAX_COUNT_RECTANGLES = 2000;
        if (n <= MIN_COUNT_RECTANGLES || n >= MAX_COUNT_RECTANGLES) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkCoordinates(int x1, int y1, int x2, int y2) {
        final int MIN_COORDINATE = 0;
        final int MAX_COORDINATE = 1000;
        if (!(x1 >= MIN_COORDINATE && x1 <= x2 && x2 <= MAX_COORDINATE &&
                y1 >= MIN_COORDINATE && y1 <= y2 && y2 <= MAX_COORDINATE)) {
            throw new IllegalArgumentException();
        }
    }

    private static void fillRectangle(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                Cell cell = new Cell(i, j, true);
                if (!(filledCells.contains(cell))) {
                    filledCells.add(cell);
                }
            }
        }
    }
}
 /*
3
2 2 4 4
4 2 5 4
3 3 6 4
  */