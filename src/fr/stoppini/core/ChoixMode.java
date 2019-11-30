package fr.stoppini.core;

import java.util.Scanner;


public class ChoixMode {
    private String Choix;
    private boolean Condition = false;

    public ChoixMode() {
        Scanner sc = new Scanner(System.in);
        welcome(sc);
        yourChoice(sc);
    }

    public void welcome(Scanner sc) {

        System.out.println("*************** Bienvenue *************** \n \n Veuillez sélectionner un mode de jeu : "
                + "\n \n 1 - Défenseur\n 2 - Challenger\n 3 - Duel ");
        Choix = sc.nextLine();

    }

    public void yourChoice(Scanner sc) {
        while (Condition == false) {

            if (Choix.contains("1") || Choix.contains("Défenseur") || Choix.contains("défenseur")
                    || Choix.contains("Defenseur") || Choix.contains("defenseur")) {
                System.out.println("Mode sélectionné : Défenseur.");
                Condition = true;
                Choix = "1";

            } else if (Choix.contains("2") || Choix.contains("Challenger") || Choix.contains("challenger")) {
                System.out.println("Mode sélectionné : Challenger.");
                Condition = true;
                Choix = "2";

            } else if (Choix.contains("3") || Choix.contains("Duel") || Choix.contains("duel")) {
                System.out.println("Mode sélectionné : Duel. Préparez-vous.");
                Condition = true;
                Choix = "3";

            } else {
                System.out.println("Veuillez réitérer votre saisie. \nVeuillez sélectionner un mode de jeu : "
                        + "\n \n 1 - Défenseur\n 2 - Challenger\n 3 - Duel ");
                Choix = sc.nextLine();
            }
        }
    }


//	********************** Getter **********************

    public String getChoix() {
        return Choix;
    }


}

