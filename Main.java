import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[][] gameBoard = {{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', ' ', '|', ' '}};

        Game game = new Game();
        Board board = new Board();

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;


        System.out.printf(" Hello! Please let me know your name!%n");
        String name = scanner.next();
        Players firstPlayer = new Players(name, 1);
        System.out.printf("Nice to meet you %s, you are player number %d%n Let's meet your opponent!%n", firstPlayer.name, firstPlayer.number);
        System.out.printf("Hello! Please let me know your name!%n");
        name = scanner.next();
        Players secondPlayer = new Players(name, 2);
        System.out.printf("Nice to meet you %s, you are player number %d%n", secondPlayer.name, secondPlayer.number);
        System.out.printf("Let's start our match! %n %s versus %s %n", firstPlayer.name, secondPlayer.name);

        board.printBoard(gameBoard);

        while (flag) {
            game.playing(firstPlayer, gameBoard);
            if (game.winningGame(gameBoard, firstPlayer, secondPlayer)) {
                if (game.checkGameOver(firstPlayer, secondPlayer)) {
                    flag = false;
                    break;
                } else {
                    gameBoard = new char[][]{{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', ' ', '|', ' '}};
                    game.playing(firstPlayer, gameBoard);
                }
            }
            game.playing(secondPlayer, gameBoard);
            if (game.winningGame(gameBoard, firstPlayer, secondPlayer)) {
                if (game.checkGameOver(firstPlayer, secondPlayer)) {
                    flag = false;
                    break;
                } else {
                    gameBoard = new char[][]{{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', ' ', '|', ' '}};
                    game.playing(secondPlayer, gameBoard);
                }
                if (!flag) {
                    break;
                }
            }
        }
    }
}
