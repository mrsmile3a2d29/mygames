/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.mrsmile.mygames;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mrsmile
 */
public class Main {

    static Scanner kb = new Scanner(System.in);

    /**
     * Main method of the Main class
     * @param args 
     */
    public static void main(String[] args) {
        String[] listPlayers = {"", ""};
        int[] listScore = {0, 0};
        int winner;
        /*
        util.showLogo();
         */
        int choiceMenu = util.menu();
        while (choiceMenu != 0) {
            
            switch (choiceMenu) {
                case 1:
                    if (listPlayers[0].equals("") && listPlayers[1].equals("")) {
                        System.out.println("");
                        System.out.println("Creation des joueurs !");
                        addPlayers(listPlayers);
                    }
                        winner = lucifer.start(listPlayers);
                        System.out.println("");
                        listScore[winner] += 5;
                        System.out.println("Bravo "+listPlayers[winner]+" ! Vous avez gagne 5 points !");
                        util.pressEnter();
                        System.out.println("");
                    break;
                case 2:
                    if (listPlayers[0].equals("") && listPlayers[1].equals("")) {
                        System.out.println("Creation des joueurs !");
                        addPlayers(listPlayers);
                    }
                        winner = tictactoe.start(listPlayers);
                        if(winner > 1) {
                            System.out.println("");
                            System.out.println("Match nul !");
                            util.pressEnter();
                            System.out.println("");
                            break;
                        }
                        System.out.println("");
                        listScore[winner] += 5;
                        System.out.println("Bravo "+listPlayers[winner]+" ! Vous avez gagne 5 points !");
                        util.pressEnter();
                        System.out.println("");
                    break;
                case 3:
                    showScore(listPlayers, listScore);
                    System.out.println("");
                    break;
                case 4:
                    resetScore(listScore);
                    System.out.println("");
                    break;
                case 5 :
                    if (listPlayers[0].equals("") && listPlayers[1].equals("")) {
                        System.out.println("Creation des joueurs !");
                        addPlayers(listPlayers);
                        util.pressEnter();
                        System.out.println("");
                    } else {
                        System.out.println("Il y a deja deux joueurs enregistres : "+Arrays.toString(listPlayers));
                        System.out.println("Score actuel : "+Arrays.toString(listScore));
                        System.out.println("Voules-vous les ecraser ? (Le score sera reinitialise) (O/N) : ");
                        if(util.askON(kb.nextLine())) {
                            addPlayers(listPlayers);
                            if(listScore[0]==0 && listScore[1]==0) {
                            } else {
                                listScore[0]=0;
                                listScore[1]=0;
                                System.out.println("Scores reinitialises.");
                            }
                            util.pressEnter();
                            System.out.println("");
                        }
                    }
                    break;
            }
            choiceMenu = util.menu();
        }
        System.out.println("");
        System.out.println("Merci, à bientot ! :)");
        System.out.println("");
    }

    /**
     * Adds 2 new players in the array
     * @param listPlayers List of the players registered
     */
    public static void addPlayers(String[] listPlayers) {
        boolean confirm = false;
        System.out.print("Entrez le pseudo du joueur 1 : ");
        String addPlayer = kb.nextLine();
        if (addPlayer.equals("")) {
            System.out.println("Veuillez entrer un pseudo ! !");
        } else {
            System.out.print("Confirmer '" + addPlayer + "' ? (O/N) : ");
            confirm = util.askON(kb.nextLine());
        }
        while (!confirm || addPlayer.equals("")) {
            System.out.println("Reessayez !");
            System.out.print("Entrez le pseudo du joueur 1 : ");
            addPlayer = kb.nextLine();
            System.out.print("Confirmer '" + addPlayer + "' ? (O/N) : ");
            confirm = util.askON(kb.nextLine());
        }
        listPlayers[0] = addPlayer;
        System.out.println("");
        System.out.println(listPlayers[0] + " a ete ajoute ! " + Arrays.toString(listPlayers));
        System.out.println("");
        
        System.out.print("Entrez le pseudo du joueur 2 : ");
        addPlayer = kb.nextLine();
        if (addPlayer.equals("")) {
            System.out.println("Veuillez entrer un pseudo !");
        } else if (addPlayer.equals(listPlayers[0])) {
            System.out.println("Ce pseudo est deja pris !");
        } else {
            System.out.print("Confirmer '" + addPlayer + "' ? (O/N) : ");
            confirm = util.askON(kb.nextLine());
        }
        while (!confirm || addPlayer.equals("") || addPlayer.equals(listPlayers[0])) {
            if (addPlayer.equals(listPlayers[0])) {
                System.out.println("Le pseudo " + addPlayer + " est deja pris !");
            }
            System.out.println("Reessayez !");
            System.out.print("Entrez le pseudo du joueur 2 : ");
            addPlayer = kb.nextLine();
            System.out.print("Confirmer '" + addPlayer + "' ? (O/N) : ");
            confirm = util.askON(kb.nextLine());
        }
        listPlayers[1] = addPlayer;
        System.out.println("");
        System.out.println(listPlayers[1] + " a ete ajoute ! " + Arrays.toString(listPlayers));
        util.sleep(2000);
    }

    /**
     * Resets the scores saved
     * @param listScore List of the scores saved
     */
    public static void resetScore(int[] listScore) {
        System.out.println("");
        if (listScore[0] == 0 && listScore[1] == 0) {
            System.out.println("Les score sont deja nuls !");
        } else {
            System.out.println("Score actuel : [" + listScore[0] + ", " + listScore[1] + "]");
            System.out.println("Voulez-vous vraiment les reinitialiser ? (O/N) : ");
            if (util.askON(kb.nextLine())) {
                listScore[0] = 0;
                listScore[1] = 0;
                System.out.println("Score reinitialise !");
            }
        }
        System.out.println("");
        util.pressEnter();
    }

    /**
     * Shows the Scores
     * @param listPlayers List of the players registered
     * @param listScore List of the scores saved
     */
    public static void showScore(String[] listPlayers, int[] listScore) {
        System.out.println("");
        if (listPlayers[0].equals("") && listPlayers[1].equals("")) {
            System.out.println("Aucun joueur enregistre !");
        } else {
            System.out.println(listPlayers[0]+" : "+listScore[0]+" points");
            System.out.println(listPlayers[1]+" : "+listScore[1]+" points");
            if(listScore[0]==0 && listScore[1]>0) {
                System.out.println(listPlayers[0]+", tu as 0 points ! Il faut te reveiller ;)");
            }
            else if(listScore[1]==0 && listScore[0]>0) {
                System.out.println(listPlayers[1]+", tu as 0 points ! Il faut te reveiller ;)");
            }
            else if(listScore[0]==0 && listScore[1]==0) {
                System.out.println("Il faut jouer au moins une fois pour avoir des points !");
            }
        }
        System.out.println("");
        util.pressEnter();
    }

}
