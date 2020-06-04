package cs_utec.cs2901;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Board {
    public Cell[][] getBoard() {
        return board;
    }

    private Cell[][] board;

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    private int numberOfRows;
    private int numberOfColumns;

    public int getNumberOfBombs() {
        return numberOfBombs;
    }

    private int numberOfBombs;

    public Board() {
        System.out.println("Ingrese las dimensiones del tablero:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Número de filas: ");
        numberOfRows = scanner.nextInt();
        System.out.print("Número de columnas: ");
        numberOfColumns = scanner.nextInt();
        System.out.println("_____________________________________");
        System.out.print("Número de bombas: ");
        numberOfBombs = scanner.nextInt();
        createBoard(numberOfRows, numberOfRows, numberOfBombs);
    }

    private void createBoard(int r, int c, int n) {
        board = new Cell[r][c];
        for (int i = 0; i < r; i++) {
            Cell cell = new Cell();
            Arrays.fill(board[i], cell);
        }
        insertBombs(n);
    }

    private void insertBombs(int bombs) {
        Random random = new Random();
        while (bombs != 0) {
            System.out.println(bombs);
            int randomRow = random.nextInt(numberOfRows);
            int randomColumn = random.nextInt(numberOfColumns);
            if (!board[randomRow][randomColumn].setBomba()) {
                bombs--;
            }
        }
    }
    // v2.0 observer coming soon

    public void print() {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (!board[i][j].revelada) {
                    System.out.print("* ");
                } else {
                    System.out.print(board[i][j].adjacent);
                }
            }
            System.out.println();
        }
    }

    private void contarBombas(){


        for (int i=0;i<numberOfRows;i++) {
            for (int j = 0; j < numberOfColumns; j++){
                int bombas=0;
                if (board[i][j].bomba){
                    break;
                }
                if (board[i+1][j].bomba){
                    bombas++;
                }
                if (i-1>0 && board[i-1][j].bomba){
                    bombas++;
                }
                if (board[i][j+1].bomba){
                    bombas++;
                }
                if (j-1>0 && board[i][j-1].bomba){
                    bombas++;
                }
                if (j-1>0 && board[i+1][j-1].bomba){
                    bombas++;
                }
                if (i-1>0 && board[i-1][j+1].bomba){
                    bombas++;
                }
                if (j-1>0 && i-1>0 && board[i-1][j-1].bomba){
                    bombas++;
                }
                if (board[i+1][j+1].bomba){
                    bombas++;
                }
                board[i][j].setAdjacent(bombas);
            }
        }
    }
}
