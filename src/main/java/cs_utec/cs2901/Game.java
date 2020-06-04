package cs_utec.cs2901;

import java.util.Scanner;

public class Game {
    int counter;
    Board board = new Board();

    public void play() {
        Scanner scanner = new Scanner(System.in);
        counter = board.getNumberOfRows() * board.getNumberOfColumns() - board.getNumberOfBombs();
        System.out.println("Ok. Let's play.");
        while (counter > 0) {
            board.print();
            System.out.print("Ingresa la fila: ");
            int row = scanner.nextInt();
            System.out.print("Ingresa la columna: ");
            int col = scanner.nextInt();
            if (board.getBoard()[row][col].revelada) {
                System.out.println("Intente nuevamente.");
            } else {
                // check if bomb
                if (board.getBoard()[row][col].click()) {
                    // TODO
                }
            }
        }
    }
}
