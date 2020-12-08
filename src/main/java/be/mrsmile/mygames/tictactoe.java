/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.mrsmile.mygames;

import java.util.Arrays;

/**
 *
 * @author mrsmile
 */
public class tictactoe {

    /**
     * Starts tictactoe game
     * @param listPlayers Array of players registered
     * @return The index of the winner (0 or 1)
     */
    public static int start(String[] listPlayers) {
        int currentPlayer = util.flipCoin(listPlayers);
        System.out.println("");
        System.out.println("Lancement du jeu...");
        util.sleep(1000);
        System.out.println("");

        int[] tictactoe = new int[9];
        int win = 0;
        int choice = 0;

        showTictactoe(tictactoe, win);

        while (win == 0) {
            System.out.println(listPlayers[currentPlayer] + ", choisissez un emplacement (1/9)");
            choice = util.askIntBetween(1, 9);
            while (tictactoe[choice - 1] != 0) {
                System.out.println("Cet emplacement n'est plus disponible. Choisissez-en un autre !");
                choice = util.askIntBetween(1, 9);
            }
            tictactoe[choice - 1] = currentPlayer + 1;
            win = checkWin(tictactoe);
            showTictactoe(tictactoe, win);
            currentPlayer = 1 - currentPlayer;
        }

        return 1 - currentPlayer;
    }

    /**
     * Displays the tictactoe boards
     * @param tictactoe Arrays with value of each case
     * @param win The way the winner wins, to show the line of the three same symbols
     */
    public static void showTictactoe(int[] tictactoe, int win) {
        for (int i = 0; i < 9; i++) {
            if (win == 123 && i < 3) {
                System.out.print("--|--");
            } else if (win == 456 && (i >= 3 && i < 6)) {
                System.out.print("--|--");
            } else if (win == 789 && (i >= 6 && i < 9)) {
                System.out.print("--|--");
            } else {
                System.out.print("  |  ");
            }
            if (tictactoe[i] == 1) {
                System.out.print("X");
            } else if (tictactoe[i] == 2) {
                System.out.print("O");
            } else {
                System.out.print((i + 1));
            }
            if ((i + 1) % 3 == 0) {
                if (win == 123 && i == 2) {
                    System.out.println("--|--");
                } else if (win == 456 && i == 5) {
                    System.out.println("--|--");
                } else if (win == 789 && i == 8) {
                    System.out.println("--|--");
                } else {
                    System.out.println("  |  ");
                }
                if ((i == 2 || i == 5)) {
                    if (win == 147) {
                        System.out.println("     |");
                        System.out.println("     |");
                    } else if (win == 258) {
                        System.out.println("           |");
                        System.out.println("           |");
                    } else if (win == 369) {
                        System.out.println("                 |");
                        System.out.println("                 |");
                    } else if (win == 159) {
                        if (i == 2) {
                            System.out.println("        \\");
                            System.out.println("         \\");
                        } else if (i == 5) {
                            System.out.println("             \\");
                            System.out.println("              \\");
                        }
                    } else if (win == 357) {
                        if (i == 2) {
                            System.out.println("              /");
                            System.out.println("             /");
                        } else if (i == 5) {
                            System.out.println("        /");
                            System.out.println("       /");
                        }
                    } else {
                        System.out.println("");
                        System.out.println("");
                    }
                } else {
                    System.out.println("");
                    System.out.println("");
                }

            }

        }
    }

    /**
     * Checks if someone won the game
     * @param tictactoe Array with value of each case
     * @return The way the winner won (or 0 if didn't win)
     */
    public static int checkWin(int[] tictactoe) {
        int result = 0;
        for (int i = 1; i <= 2; i++) {
            if (tictactoe[0] == i && tictactoe[1] == i && tictactoe[2] == i) {
                result = 123;
            } else if (tictactoe[3] == i && tictactoe[4] == i && tictactoe[5] == i) {
                result = 456;
            } else if (tictactoe[6] == i && tictactoe[7] == i && tictactoe[8] == i) {
                result = 789;
            } else if (tictactoe[0] == i && tictactoe[3] == i && tictactoe[6] == i) {
                result = 147;
            } else if (tictactoe[1] == i && tictactoe[4] == i && tictactoe[7] == i) {
                result = 258;
            } else if (tictactoe[2] == i && tictactoe[5] == i && tictactoe[8] == i) {
                result = 369;
            } else if (tictactoe[0] == i && tictactoe[4] == i && tictactoe[8] == i) {
                result = 159;
            } else if (tictactoe[2] == i && tictactoe[4] == i && tictactoe[6] == i) {
                result = 357;
            }
        }
        return result;
    }
}
