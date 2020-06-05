package cs_utec.cs2901;

import java.util.*;

public class Board {
    private int numberOfRows;
    private int numberOfColumns;
    private int numberOfBombs;
    private int counter;
    private Cell[][] board;

    public int getCounter() {
        /*counter = 0;
        for (int i = 1; i < numberOfRows-1; i++){
            for (int j = 1; j < numberOfColumns-1; j++){
                if (board[i][j].isRevelada()){
                    counter++;
                }
            }
        }*/
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Board() {
        System.out.println("Ingrese las dimensiones del tablero:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Número de filas: ");
        numberOfRows = scanner.nextInt() + 2;
        System.out.print("Número de columnas: ");
        numberOfColumns = scanner.nextInt() + 2;
        System.out.println("_____________________________________");
        System.out.print("Número de bombas: ");
        numberOfBombs = scanner.nextInt();
        counter = ((numberOfColumns-2) * (numberOfRows-2)) - numberOfBombs;
        createBoard();
    }

    public Cell[][] getBoard() {
        return board;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfBombs() {
        return numberOfBombs;
    }

    private void createBoard() {
        board = new Cell[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++){
                Cell cell = new Cell();
                board[i][j] = cell;
            }
        }
        insertBombs();
    }

    private void insertBombs() {
        int bombs = numberOfBombs;
        Random random = new Random();
        while (bombs != 0) {
            int randomRow = random.nextInt(numberOfRows-2) + 1;
            int randomColumn = random.nextInt(numberOfColumns-2) + 1;
            if (!board[randomRow][randomColumn].setBomba()) {
                bombs--;
            }
        }
        contarBombas();
    }

    public void print() {
        for (int i = 1; i < numberOfRows-1; i++) {
            for (int j = 1; j < numberOfColumns-1; j++) {
                if (!board[i][j].isRevelada()) {
                    System.out.print("*");
                } else {
                    if (!board[i][j].isBomba()){
                        int aux = board[i][j].getAdjacent();
                        if (aux == 0){
                            System.out.print("-");
                        } else {
                            System.out.print(aux);
                        }
                    } else {
                        System.out.print("X");
                    }
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private void contarBombas(){
        for (int i = 1; i < numberOfRows - 1; i++) {
            for (int j = 1; j < numberOfColumns - 1; j++){
                int bombas = 0;
                if (board[i+1][j].isBomba()){
                    bombas++;
                }
                if (board[i-1][j].isBomba()){
                    bombas++;
                }
                if (board[i][j+1].isBomba()){
                    bombas++;
                }
                if (board[i][j-1].isBomba()){
                    bombas++;
                }
                if (board[i+1][j-1].isBomba()){
                    bombas++;
                }
                if (board[i-1][j+1].isBomba()){
                    bombas++;
                }
                if (board[i-1][j-1].isBomba()){
                    bombas++;
                }
                if (board[i+1][j+1].isBomba()){
                    bombas++;
                }
                board[i][j].setAdjacent(bombas);
            }
        }
    }

    public boolean click(int row, int col){
        if (!board[row][col].isRevelada()){
            if (!board[row][col].isBomba()){
                counter--;
                if (board[row][col].getAdjacent()==0) {
                    revealAdjacents(row, col);
                } else {
                    board[row][col].setRevelada(true);
                }
            }
            return board[row][col].isBomba();
        }
        return false;
    }

    private void revealAdjacents(int row, int col){
        if (row >= 1 && col >= 1 && col <= numberOfColumns - 2  && row <= numberOfRows - 2){
            if (!board[row][col].isRevelada()){
                board[row][col].setRevelada(true);
                counter--;
                if (board[row][col].getAdjacent() != 0){
                    return;
                }
                revealAdjacents(row+1, col); // 2 1
                revealAdjacents(row+1, col+1); // 2 2
                revealAdjacents(row, col+1); // 1 2
                revealAdjacents(row-1, col); // 0 1
                revealAdjacents(row-1, col+1); // 0 2
                revealAdjacents(row, col-1); // 1 0
                revealAdjacents(row+1, col-1); // 2 0
                revealAdjacents(row-1, col-1); // 0 0
            }
        }
    }

    public void revealBombas(){
        for (int i = 1; i<numberOfRows-1; i++){
            for (int j = 1; j<numberOfColumns-1; j++){
                board[i][j].setRevelada(true);
            }
        }
    }
}
