import java.util.InputMismatchException;
import java.util.Scanner;

public class Game extends Players {
    private char[][] gameBoard = {{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', ' ', '|', ' '}};

    int round = 1;
    int firstPlayerScore = 0;
    int secondPlayerScore = 0;

    Scanner scanner = new Scanner(System.in);
    Board game = new Board();


    public void playing(Players player, char[][] gameBoard) {
        boolean loop = true;
        int position = 0;

    while(loop) {
        try {
            position = scanner.nextInt();
            while (!checkFreePosition(gameBoard, position)) {
                position = scanner.nextInt();
            }
            loop = false;

        } catch (InputMismatchException e) {
            System.out.printf("Invalid format. Try again. %n ");
            scanner.next();
        }
    }
        setPositions(position, player.number, gameBoard);

    }
    public void setPositions(int positions, int playerNumber, char[][] gameBoard) {

        char character;
        if (playerNumber == 1) {
            character = 'X';
        } else {
            character = '0';
        }

        switch (positions) {
            case 1 -> {
                gameBoard[0][0] = character;
                game.printBoard(gameBoard);
            }
            case 2 -> {
                gameBoard[0][2] = character;
                game.printBoard(gameBoard);
            }
            case 3 -> {
                gameBoard[0][4] = character;
                game.printBoard(gameBoard);
            }
            case 4 -> {
                gameBoard[1][0] = character;
                game.printBoard(gameBoard);
            }
            case 5 -> {
                gameBoard[1][2] = character;
                game.printBoard(gameBoard);
            }
            case 6 -> {
                gameBoard[1][4] = character;
                game.printBoard(gameBoard);
            }
            case 7 -> {
                gameBoard[2][0] = character;
                game.printBoard(gameBoard);
            }
            case 8 -> {
                gameBoard[2][2] = character;
                game.printBoard(gameBoard);
            }
            case 9 -> {
                gameBoard[2][4] = character;
                game.printBoard(gameBoard);
            }
            default -> {
                System.out.printf("%n Invalid position. Please enter a number between 1 and 9. %n");

            }

        }
    }

    public boolean winningGame(char[][] gameBoard, Players firstPlayer, Players secondPlayer) {
        //horizontal player one
        if (gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X') {
            firstPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", firstPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, firstPlayer.name, firstPlayerScore, secondPlayer.name, secondPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d%n", round);
            return true;
        }
        if (gameBoard[1][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[1][4] == 'X') {
            firstPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", firstPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, firstPlayer.name, firstPlayerScore, secondPlayer.name, secondPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d%n", round);

            return true;
        }
        if (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
            firstPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", firstPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, firstPlayer.name, firstPlayerScore, secondPlayer.name, secondPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d", round);

            return true;
        }

        // vertical player one
        if (gameBoard[0][0] == 'X' && gameBoard[1][0] == 'X' && gameBoard[2][0] == 'X') {
            firstPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", firstPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, firstPlayer.name, firstPlayerScore, secondPlayer.name, secondPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d", round);

            return true;
        }
        if (gameBoard[0][2] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][2] == '4') {
            firstPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", firstPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, firstPlayer.name, firstPlayerScore, secondPlayer.name, secondPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d", round);
            return true;
        }
        if (gameBoard[0][4] == 'X' && gameBoard[1][4] == 'X' && gameBoard[2][4] == 'X') {
            firstPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", firstPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, firstPlayer.name, firstPlayerScore, secondPlayer.name, secondPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d%n", round);
            return true;
        }

        //diagonal player one
        if (gameBoard[0][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][4] == 'X') {
            firstPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", firstPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, firstPlayer.name, firstPlayerScore, secondPlayer.name, secondPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d%n", round);
            return true;
        }
        if (gameBoard[2][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[0][4] == 'X') {
            firstPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", firstPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, firstPlayer.name, firstPlayerScore, secondPlayer.name, secondPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d%n", round);
            return true;
        }

        //horizontal player two
        if (gameBoard[0][0] == '0' && gameBoard[0][2] == '0' && gameBoard[0][4] == '0') {
            secondPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", secondPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, secondPlayer.name, secondPlayerScore, firstPlayer.name, firstPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d%n", round);
            return true;
        }
        if (gameBoard[1][0] == '0' && gameBoard[1][2] == '0' && gameBoard[1][4] == '0') {
            secondPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", secondPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, secondPlayer.name, secondPlayerScore, firstPlayer.name, firstPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d%n", round);
            return true;
        }
        if (gameBoard[2][0] == '0' && gameBoard[2][2] == 'X' && gameBoard[2][4] == '0') {
            secondPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", secondPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, secondPlayer.name, secondPlayerScore, firstPlayer.name, firstPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d%n", round);
            return true;
        }

        // vertical player two
        if (gameBoard[0][0] == '0' && gameBoard[1][0] == '0' && gameBoard[2][0] == '0') {
            secondPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", secondPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, secondPlayer.name, secondPlayerScore, firstPlayer.name, firstPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d%n", round);
            return true;
        }
        if (gameBoard[0][2] == '0' && gameBoard[1][2] == '0' && gameBoard[2][2] == '0') {
            secondPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", secondPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, secondPlayer.name, secondPlayerScore, firstPlayer.name, firstPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d%n", round);
            return true;
        }
        if (gameBoard[0][4] == '0' && gameBoard[1][4] == '0' && gameBoard[2][4] == '0') {
            secondPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", secondPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, secondPlayer.name, secondPlayerScore, firstPlayer.name, firstPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d%n", round);
            return true;
        }

        //diagonal player two
        if (gameBoard[0][0] == '0' && gameBoard[1][2] == '0' && gameBoard[2][4] == '0') {
            secondPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", secondPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, secondPlayer.name, secondPlayerScore, firstPlayer.name, firstPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d%n", round);

            return true;
        }
        if (gameBoard[2][0] == '0' && gameBoard[1][2] == '0' && gameBoard[0][4] == '0') {
            secondPlayerScore++;
            System.out.printf("%n Congrats %s! You won! %n ", secondPlayer.name);
            System.out.printf("Round no. %d of 5 %n %s %d vs %s %d. %n", round, secondPlayer.name, secondPlayerScore, firstPlayer.name, firstPlayerScore);
            round++;
            System.out.printf("%n  Round no. %d%n", round);
            return true;
        }
        if (gameBoard[0][0] != '_' && gameBoard[0][2] != '_' && gameBoard[0][4] != '_' && gameBoard[1][0] != '_' && gameBoard[1][2] != '_' && gameBoard[1][4] != '_' && gameBoard[2][0] != ' ' && gameBoard[2][2] != ' ' && gameBoard[2][4] != ' ') {
            System.out.printf("%n It's a tie. Round no. %d of 5 %n %s %d vs %s %d. %n", round, secondPlayer.name, secondPlayerScore, firstPlayer.name, firstPlayerScore);
            round++;
            return true;
        }
        return false;
    }

    public boolean checkGameOver(Players firstPlayer, Players secondPlayer) {
        boolean flag = true;
        if (round > 5 || firstPlayerScore >= 3 || secondPlayerScore >= 3) {
            if (firstPlayerScore > secondPlayerScore) {
                System.out.printf("%n Congrats %s, YOU WON! %n Your score was %d - %d %n Best luck next time %s%n", firstPlayer.name, firstPlayerScore, secondPlayerScore, secondPlayer.name);
                flag = false;
            } else if (secondPlayerScore > firstPlayerScore) {
                System.out.printf("%n Congrats %s, YOU WON! %n Your score was %d - %d %n Best luck next time %s%n", secondPlayer.name, secondPlayerScore, firstPlayerScore, firstPlayer.name);
                flag = false;
            } else {
                System.out.printf("%n It's a tie. %n Best luck next time");
                flag = false;
            }
        }
        return !flag;
    }

    public boolean checkFreePosition(char[][] gameBoard, int position) {
        switch (position) {
            case 1 -> {
                if (gameBoard[0][0] == '_') {
                    return true;
                } else {
                    System.out.printf("%n Sorry. Not Free. Try Again %n");
                    return false;
                }
            }
            case 2 -> {
                if (gameBoard[0][2] == '_') {
                    return true;
                } else {
                    System.out.printf("%n Sorry. Not Free. Try Again %n");
                    return false;
                }
            }
            case 3 -> {
                if (gameBoard[0][4] == '_') {
                    return true;
                } else {
                    System.out.printf("%n Sorry. Not Free. Try Again %n");
                    return false;
                }
            }
            case 4 -> {
                if (gameBoard[1][0] == '_') {
                    return true;
                } else {
                    System.out.printf("%n Sorry. Not Free. Try Again %n");
                    return false;
                }
            }
            case 5 -> {
                if (gameBoard[1][2] == '_') {
                    return true;
                } else {
                    System.out.printf("%n Sorry. Not Free. Try Again %n");
                    return false;
                }
            }
            case 6 -> {
                if (gameBoard[1][4] == '_') {
                    return true;
                } else {
                    System.out.printf("%n Sorry. Not Free. Try Again %n");
                    return false;
                }
            }
            case 7 -> {
                if (gameBoard[2][0] == ' ') {
                    return true;
                } else {
                    System.out.printf("%n Sorry. Not Free. Try Again %n");
                    return false;
                }
            }
            case 8 -> {
                if (gameBoard[2][2] == ' ') {
                    return true;
                } else {
                    System.out.printf("%n Sorry. Not Free. Try Again %n");
                    return false;
                }
            }
            case 9 -> {
                if (gameBoard[2][4] == ' ') {
                    return true;
                } else {
                    System.out.printf("%n Sorry. Not Free. Try Again %n");
                    return false;
                }
            }
            default -> {
                System.out.printf("Invalid position. Please try again. Enter a number : 1- 9 %n");
                return false;
            }
        }
    }
}