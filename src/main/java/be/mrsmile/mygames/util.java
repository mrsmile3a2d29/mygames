/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.mrsmile.mygames;

import java.util.Scanner;

/**
 *
 * @author mrsmile
 */
public class util {

    static Scanner kb = new Scanner(System.in);

    /**
     * Shows my personal logo :)
     */
    public static void showLogo() {
        System.out.println("");
        System.out.println("     ||||||||||||||||||||||||||||");
        System.out.println("     |        TicTacToe v1      |");
        System.out.println("     ||||||||||||||||||||||||||||");
        System.out.println("");
        System.out.println("           > by MrSmile :) <");
        System.out.println("");
        System.out.println("Chargement...");
        System.out.println("");
        for (int i = 0; i < 40; i++) {
            System.out.print("+");
            sleep(randomInt(0, 300));
        }
        System.out.println("");
        System.out.println("");
        System.out.println("              100% loaded");
        System.out.println("");
        System.out.println("----------------------------------------");
        System.out.println("");
        sleep(2000);
    }

    /**
     * Main menu of the program
     * @return The choice of the user
     */
    public static int menu() {
        System.out.println("");
        System.out.println("    Menu");
        System.out.println("");
        System.out.println("1 - Lucifers");
        System.out.println("2 - Tic Tac Toe");
        System.out.println("3 - Afficher score");
        System.out.println("4 - Reinitialiser score");
        System.out.println("5 - Changer joueurs");
        System.out.println("0 - Quitter");
        System.out.println("");
        int result = askIntBetween(0, 5);
        return result;
    }

    /**
     * Waits a given time in milliseconds
     *
     * @param ms milliseconds to wait
     */
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Returns a random integer in the range of two integers
     *
     * @param min The minimum value of the random possibility
     * @param max The maximum value of the random possibility
     * @return A random integer in the range of the two integers min and max
     */
    public static int randomInt(int min, int max) {
        int result = (int) (Math.random() * ((max - min) + 1)) + min;
        return result;
    }

    /**
     * Returns an int choosen by the user, in the range of two integers
     *
     * @param min The minimum value that the user can choose
     * @param max The maximum value that the user can choose
     * @return The int choosen by the user, in the range of the two parameters
     * min and max
     */
    public static int askIntBetween(int min, int max) {
        int result;
        System.out.print("Entrez votre choix (" + min + "/" + max + ") : ");
        while (!kb.hasNextInt()) {
            System.out.print("Ce n'est pas un entier ! Reessayez : ");
            kb.next();
        }
        result = kb.nextInt();
        while (result < min || result > max) {
            System.out.print("Veuillez entrer un entier entre " + min + " et " + max + " : ");
            while (!kb.hasNextInt()) {
                System.out.print("Ce n'est pas un entier ! Reessayez : ");
                kb.next();
            }
            result = kb.nextInt();
        }
        return result;
    }

    /**
     * Returns True if the user typed 'O' or 'o' and False if he typed 'N' or 'n'
     * @return True (O/o) or False (N/n)
     */
    public static boolean askON(String confirm) {
        while (!confirm.equalsIgnoreCase("o") && !confirm.equalsIgnoreCase("n")) {
            System.out.print("Veuillez entrer un choix valide ! (O/N) : ");
            confirm = kb.nextLine();
            confirm = confirm.toLowerCase();
        }
        return confirm.equalsIgnoreCase("o");
    }
    
    /**
     * Flip a coin to choose who starts playing
     * @param listPlayers List of the players registered
     * @return Random index of listPlayers[] (0 or 1)
     */
    public static int flipCoin(String[] listPlayers) {
        final String[] coin = {"Pile", "Face"};
        int winCoin = 0;
        int whoChooseCoin = randomInt(0, 1);
        System.out.println("");
        System.out.println("Attention...");
        sleep(1000);
        System.out.println("");
        System.out.println("C'est a "+listPlayers[whoChooseCoin]+" de choisir son cote de la piece !");
        sleep(1000);
        System.out.println("");
        System.out.println("Tape 0 pour pile");
        System.out.println("Tape 1 pour face");
        System.out.println("");
        int choiceCoin = askIntBetween(0, 1);
        System.out.println("");
        System.out.println("Tu as choisi "+coin[choiceCoin]);
        sleep(300);
        System.out.println("");
        System.out.println("Lancement de la piece !");
        sleep(400);
        System.out.println("");
        int showedCoin = randomInt(0, 1);
        for (int i = 0; i < 10+randomInt(0, 1); i++) {
            showedCoin = 1 - showedCoin;
            System.out.print(coin[showedCoin]+"... ");
            sleep(i*100);
        }
        /******************************************************************************************************************/
        if((listPlayers[whoChooseCoin].equalsIgnoreCase("blacky") && choiceCoin == showedCoin) || (listPlayers[whoChooseCoin].equalsIgnoreCase("mrsmile") && choiceCoin == showedCoin)) {
            showedCoin = 1 - showedCoin;
            System.out.print(coin[showedCoin]+"... ");
            sleep(1000);
        }
        else if((listPlayers[1-whoChooseCoin].equalsIgnoreCase("blacky") && choiceCoin != showedCoin) || (listPlayers[1-whoChooseCoin].equalsIgnoreCase("mrsmile") && choiceCoin != showedCoin)) {
            showedCoin = 1 - showedCoin;
            System.out.print(coin[showedCoin]+"... ");
            sleep(1000);
        }
        /******************************************************************************************************************/
        showedCoin = 1 - showedCoin;
        System.out.println("C'est "+coin[showedCoin]+" !");
        sleep(1000);
        System.out.println("");
        if(choiceCoin == showedCoin) {
            winCoin = whoChooseCoin;
        } else {
            winCoin = 1 - whoChooseCoin;
        }
        System.out.println("C'est donc "+listPlayers[winCoin]+" qui commence.");
        System.out.println("");
        return winCoin;
    }

    /**
     * Press enter to continue
     */
    public static void pressEnter() {
        System.out.println("Appuyez sur entrer pour continuer...");
        try {
            System.in.read();
        } catch(Exception ex) {
            
        }
    }
}
