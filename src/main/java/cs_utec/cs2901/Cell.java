package cs_utec.cs2901;

public class Cell {
    boolean revelada = false;
    boolean bomba = false;
    boolean flagged = false;
    int adjacent = 0;

    public void setAdjacent(int new_adj) {
        adjacent = new_adj;
    }

    public boolean setBomba() {
        if (bomba = false) {
            bomba = true;
            return false;
        } else {
            return true;
        }
    }

    public boolean click() {
        return bomba;
    }

    public void flag() {
        flagged = true;
    }

    Cell() {
    }
}