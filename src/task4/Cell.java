package task4;

import java.util.Objects;

class Cell {
    private int x;
    private int y;
    private boolean isFilled;

    Cell(int x, int y, boolean isFilled) {
        this.x = x;
        this.y = y;
        this.isFilled = isFilled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y &&
                isFilled == cell.isFilled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, isFilled);
    }
}
