package A_03_JavaGamesAndApps;

import java.util.Scanner;

public class TicTacToeConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] playingBoard = new char[5][5];

        createBoard(playingBoard);
        boolean haveWinner = false;
        char player = 'o';

        while (!haveWinner) {
            printBoard(playingBoard);
            if (player == 'o') {
                System.out.println("Turn O,Please select from 1-9 :");
                playTurn(scanner, playingBoard, player);
                haveWinner = checkRowCol(playingBoard, player) || checkDiagonal(playingBoard, player);
                player = 'x';

            } else if (player == 'x') {
                System.out.println("Turn X, choose 1-9 :");
                playTurn(scanner, playingBoard, player);

                player = 'o';
            }

        }


        printBoard(playingBoard);

    }

    private static boolean checkDiagonal(char[][] playingBoard, char player) {
        for (int r = 0; r < 5; r += 2) {
            int foundOnMainDiagonal = 0;
            if (playingBoard[r][r] == player) {

            }
        }
        return false;
    }

    private static boolean checkRowCol(char[][] board, char player) {
        for (int r = 0; r < 5; r += 2) {
            int foundOnRow = 0;
            int foundOnCol = 0;

            for (int c = 0; c < 5; c += 2) {
                if (board[r][c] == player) {
                    foundOnRow += 1;
                }
                if (board[c][r] == player) {
                    foundOnCol += 1;
                }
                if (foundOnRow == 3 || foundOnCol == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void playTurn(Scanner scanner, char[][] playingBoard, char player) {
        switch (scanner.nextLine()) {
            case "1":
                playingBoard[0][0] = player;
                break;
            case "2":
                playingBoard[0][2] = player;
                break;
            case "3":
                playingBoard[0][4] = player;
                break;
            case "4":
                playingBoard[2][0] = player;
                break;
            case "5":
                playingBoard[2][2] = player;
                break;
            case "6":
                playingBoard[2][4] = player;
                break;
            case "7":
                playingBoard[4][0] = player;
                break;
            case "8":
                playingBoard[4][2] = player;
                break;
            case "9":
                playingBoard[4][4] = player;
                break;
        }
    }

    private static void printBoard(char[][] board) {
        for (char[] chars : board) {
            System.out.println(chars);
        }

    }


    private static void createBoard(char[][] playingBoard) {
        playingBoard[0] = " | | ".toCharArray();
        playingBoard[1] = "-----".toCharArray();
        playingBoard[2] = " | | ".toCharArray();
        playingBoard[3] = "-----".toCharArray();
        playingBoard[4] = " | | ".toCharArray();
    }


}
