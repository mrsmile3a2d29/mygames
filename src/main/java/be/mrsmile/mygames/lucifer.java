/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.mrsmile.mygames;

/**
 *
 * @author mrsmile
 */
public class lucifer {

    /**
     * Starts the game Lucifer
     * @param listPlayers Array of players registered
     * @return Index of the winner (0 or 1)
     */
    public static int start(String[] listPlayers) {
        int currentPlayer = util.flipCoin(listPlayers);
        System.out.println("");
        System.out.println("Lancement du jeu...");
        util.sleep(1000);
        System.out.println("");
        boolean[] lucifers = new boolean[20];
        for (int i = 0; i < lucifers.length; i++) {
            lucifers[i] = true;
        }
        int lucifersLeft = 20;
        int nbLucifers;

        while (lucifersLeft > 0) {
            showLucifers(lucifers);
            System.out.println("");
            if (lucifersLeft < 0) {
                lucifersLeft = 0;
            }
            System.out.println("Allumettes restantes : " + lucifersLeft);
            System.out.println("");
            System.out.println(listPlayers[currentPlayer] + ", combien d'allumettes voulez-vous enlever ? ");
            System.out.println("");
            if(lucifersLeft < 3) {
                nbLucifers = util.askIntBetween(1, lucifersLeft);
            } else {
                nbLucifers = util.askIntBetween(1, 3);
            }
            System.out.println("");
            if(nbLucifers == 1) {
                System.out.print("Allumette supprimee : ");
            } else {
                System.out.print("Allumettes supprimees : ");
            }
            for (int i = 0; i < nbLucifers; i++) {
                int delLucifer = util.randomInt(0, 19);
                while (!lucifers[delLucifer]) {
                    delLucifer = util.randomInt(0, 19);
                }
                lucifers[delLucifer] = false;
                System.out.print(delLucifer + 1);
                if(i < nbLucifers-1) {
                    System.out.print(", ");
                }
                lucifersLeft--;
            }
            System.out.println("");
            currentPlayer = 1 - currentPlayer;
        }
        return currentPlayer;
    }

    /**
     * Displays lucifers left on the screen
     * @param lucifers Boolean array of lucifers (true if one, false if none)
     */
    public static void showLucifers(boolean[] lucifers) {
        System.out.println("");
        for (int i = 0; i < 20; i++) {
            System.out.print("   ");
            if (lucifers[i]) {
                System.out.print("|");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println("");
        for (int i = 0; i < 20; i++) {
            if (i > 9) {
                System.out.print("  ");
            } else {
                System.out.print("   ");
            }
            if (lucifers[i]) {
                System.out.print(i + 1);
            } else {
                if (i > 9) {
                    System.out.print("  ");
                } else {
                    System.out.print(" ");
                }
            }
        }
        System.out.println("");
    }
}
