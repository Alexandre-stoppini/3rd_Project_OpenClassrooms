package fr.stoppini.core;


import java.util.Scanner;

public class Game {


    Scanner sc = new Scanner(System.in);
    private boolean condit = false;
    private String replay;

    public Game() {
        do {
            ChoixMode choixMode = new ChoixMode();
            String choix = choixMode.getChoix();
            if (choix.equals("1")) {
                VerifCodeManuel verifCodeManuel = new VerifCodeManuel();
            } else if (choix.equals("2")) {
                VerifCodeAuto VerifCodeAuto = new VerifCodeAuto();
            } else if (choix.equals("3")) {
                System.out.println("Pas encore implémenté.");
            }


            System.out.println("\n-----------------------------------------\n" +
                    "Voulez-vous relancer une partie ?" +
                    "\n-----------------------------------------\n" +
                    "O / N");
            replay = sc.next();
            if (replay.equals("O")) {
                condit = false;
                System.out.println("C'est repartit pour un tour !");
            } else if (replay.equals("N")) {
                condit = true;
                System.out.println("Merci d'avoir joué. Aurevoir." +
                        "\n-----------------------------------------");
            } else {
                System.out.println("Je n'ai pas compris votre demande.");
            }
        } while (condit == false);
    }


}
