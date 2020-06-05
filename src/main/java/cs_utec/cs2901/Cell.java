package cs_utec.cs2901;

public class Cell {
    private boolean revelada = false;
    private boolean bomba = false;
    private boolean flagged = false;
    private int adjacent = 0;

    public void setAdjacent(int new_adj) {
        adjacent = new_adj;
    }

    public boolean setBomba() {
        if (!bomba) {
            bomba = true;
            return false;
        } else {
            return true;
        }
    }

    /*public boolean click() {
        if (!bomba){
            //revealAdjacents();
        }
        revelada = true;
        return bomba;
    }*/

    public boolean isRevelada() {
        return revelada;
    }

    public void setRevelada(boolean revelada) {
        this.revelada = revelada;
    }

    public boolean isBomba() {
        return bomba;
    }

    public void setBomba(boolean bomba) {
        this.bomba = bomba;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public int getAdjacent() {
        return adjacent;
    }

    public void flag() {
        flagged = true;
    }

    Cell() {
    }
}