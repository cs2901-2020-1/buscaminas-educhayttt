package cs_utec.cs2901;

import java.util.Scanner;

public class Game {
    Board board = new Board();

    public void play() {
        boolean playing = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ok. Let's play.");
        while (playing) {
            board.print();
            int row, col;
            do {
                System.out.print("Ingresa la fila: ");
                row = scanner.nextInt();
                System.out.print("Ingresa la columna: ");
                col = scanner.nextInt();
                if (row > board.getNumberOfRows()-2 || col > board.getNumberOfColumns()-2 || row < 1 || col < 1){
                    System.out.println("Ingrese nuevamente");
                }
                if (board.getBoard()[row][col].isRevelada()) {
                    System.out.println("Intente nuevamente.");
                }
            } while (row > board.getNumberOfRows()-2 || col > board.getNumberOfColumns()-2 || row < 1 || col < 1);
            if (board.click(row, col)) {
                playing = false;
                board.revealBombas();
                board.print();
                System.out.println("Lastima, perdiste :(");
            }
            if (board.getCounter() <= 0){
                playing = false;
                board.revealBombas();
                board.print();
                System.out.println("Ganaste!!");
            }
        }
    }
}
