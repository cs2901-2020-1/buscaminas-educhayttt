package cs_utec.cs2901;

import java.util.Scanner;

public class Game {
    int counter;
    Board board = new Board();

    public void play() {
        boolean continua = true;
        Scanner scanner = new Scanner(System.in);
        counter = board.getNumberOfRows() * board.getNumberOfColumns() - board.getNumberOfBombs();
        System.out.println("Ok. Let's play.");
        while (counter > 0 && continua) {
            board.print();
            int row, col;
            do {
                System.out.print("Ingresa la fila: ");
                row = scanner.nextInt();
                System.out.print("Ingresa la columna: ");
                col = scanner.nextInt();
                if (row > board.getNumberOfRows() || col > board.getNumberOfColumns() || row < 0 || col < 0){
                    System.out.println("Ingrese nuevamente");
                }
                if (board.getBoard()[row][col].isRevelada()) {
                    System.out.println("Intente nuevamente.");
                }
            } while (row > board.getNumberOfRows() || col > board.getNumberOfColumns() || row < 0 || col < 0);
                // check if bomb
            if (board.click(row, col)) {
                // TODO
                continua = false;
                board.revealBombas();
                board.print();
                System.out.println("Lastima, perdiste :(");
            }
            counter--;
        }
        if (counter == 0){
            System.out.println("Ganaste!!");
        }
    }
}
