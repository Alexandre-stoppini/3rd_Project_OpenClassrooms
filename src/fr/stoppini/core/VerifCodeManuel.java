package fr.stoppini.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VerifCodeManuel {
    private String code = " ";
    private int nombreEssais = 4;
    private String prop = " ";
    private List<String> userFeedback = new ArrayList<String>();
    private boolean runCode = true;

    public VerifCodeManuel() {

        GenerationAuto generationAuto = new GenerationAuto();
        System.out.println(generationAuto.getCode());
        code = generationAuto.getCode();
        initVerifCodeManuel();

    }

    public void initVerifCodeManuel() {
        do {
            for (int i = 1; i < nombreEssais + 1; i++) {
                tryAndCatch(i);
                userFeedback.clear(); //  clear userFeedback en début d'instance afin de pouvoir l'utiliser tout le temps.
                implementUserFeedback();
                verifyUserFeedBack();
                if (runCode == false || i == 4) {
                    runCode = false;
                    break;
                }
            }
        } while (runCode == true);
    }
    /*
    * Travailler là-dessus. C'est pas encore bien au point...
    * Cependant, le but est de faire en sorte que l'utilisateur ne puisse pas rentrer n'importe quoi.
    * Il ne doit pas pouvoir rentrer de non-digit ou alors entrer un autre nombre d'input que demandé.
    @param i prend pour paramètre i de la boucle ci dessus.
     */

    public void tryAndCatch(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vous devez cracker un code long de " + "4" + " caractères.\nNombre d'essais : " + i + "/" + nombreEssais + ".");
        prop = sc.nextLine();
        if (prop.length() != code.length() - 1 || prop.matches("[^0-9]")) {
            System.out.println("Erreur de contenu. Veuillez effectuer une nouvelle saisie.");
        }
    }

    /*
    Boucle tant que : toujours vrai.
    Boucle pour : vérifie pour chaque itération si la proposition est égale, supérieur ou inférieur au code à craquer.
    En fonction du résultat, ajoute le signe correspondant à "userFeedback"
    */
    public void implementUserFeedback() {
        while (true) {
            for (int i = 1; i < prop.length() + 1; i++) {

                Character p = prop.charAt(i - 1);
                Character c = code.charAt(i);
                //System.out.println("Prop : "+p+"\nCode : "+c);
                if (p.equals(c)) {
                    //System.out.println(p.equals(c));
                    userFeedback.add("=");
                } else if (p.compareTo(c) > 0) {
                    //System.out.println(p.compareTo(c)>0);
                    userFeedback.add("-");
                } else if (p.compareTo(c) < 0) {
                    //System.out.println(p.compareTo(c)<0);
                    userFeedback.add("+");
                }
            }
            break;
        }
    }

    /*
    Cette boucle permet de vérifier si l'array comportant la réponse de l'utilisateur contient bien uniquement des "=".
    Si oui, elle affiche un message "gagné" et fait sortir l'utilisateur de la boucle.
    Si non, elle indique à l'utilisateur qu'il a entré une mauvaise combinaison.
    */
    public void verifyUserFeedBack() {
        for (int i = 0; i < userFeedback.size(); i++) {

            if (userFeedback.get(i).contains("=")) {
                // System.out.println(true);
            } else {
                //System.out.println(false);
                System.out.println("Mauvaise combinaison :/");
                System.out.println("Voici le rendu de votre proposition : " + userFeedback);
                break;
            }
            if (i == userFeedback.size() - 1) {
                System.out.println("Gagné !!!\nLe code était bien " + code);
                runCode = false;
            }
        }
    }
}
