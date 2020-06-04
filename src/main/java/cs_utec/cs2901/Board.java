package cs_utec.cs2901;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    Cell[][] board;
    int numberOfRows, numberOfColumns, numberOfBombs;

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

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
