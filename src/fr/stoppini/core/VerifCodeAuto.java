package fr.stoppini.core;


import fr.stoppini.get_prop.SimiliGetPropValues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VerifCodeAuto {

    /*
    Série de variable inhérente à la recherche du code
     */
    private List<Integer> prop = new ArrayList<Integer>();
    private List<Integer> intervalleMin = new ArrayList<>();
    private List<Integer> intervalleMax = new ArrayList<>();
    private List<Integer> codeList = new ArrayList<>();

    /*
    Donne le code sous format String
     */
    GenerationCodeManuel generationCodeManuel = new GenerationCodeManuel();
    private String code = generationCodeManuel.getCodeManuel();


    /*
    Donne le nombre d'essais et la longueur du code sous format int. De base ils sont en String
     */
    SimiliGetPropValues similiGetPropValues = new SimiliGetPropValues();
    private int nombreEssais = Integer.parseInt(similiGetPropValues.getNombreEssais());
    private int codeLength = Integer.parseInt(similiGetPropValues.getNombreEntree());

    /*
   Variable servant à rendre à user ce que l'ordi fait. Se faisant, il peut "dialoguer" avec ce dernier.
    */
    private List<String> userFeedback = new ArrayList<String>();

    /*
    Valeur permettant de dire si oui ou non le programme doit continuer.
     */
    private boolean fin = false;


    public VerifCodeAuto() {

        init();
        if (fin == false) {
            for (int j = 1; j < nombreEssais; j++) {
                verifCode(j);
                if (fin == true) {
                    break;
                } else if (j == nombreEssais - 1) {
                    System.out.println("\n--------------------------------------------\n" +
                            "L'ordinateur n'a pas pu cracker votre code.\nFélicitations !!! ");
                }
            }
        } else {
            System.out.println("L'ordinateur à gagné du premier coup !");
        }
    }

    /*
    Fonction permettant de créer une proposition initiale pour le code à déchiffrer.
     */
    public void init() {
        for (int i = 0; i < codeLength; i++) {
            userFeedback.add("");
            intervalleMin.add(i, 0);
            intervalleMax.add(i, 10);
            int iMin = intervalleMin.get(i);
            int iMax = intervalleMax.get(i);
            prop.add((iMax - iMin) / 2 + iMin);
            Integer pr = prop.get(i);
            int c = (code.codePointAt(i)) - 48;
            if (pr == c) {
                preRetourUser(pr, c, i);
            } else if (pr < c) {
                preRetourUser(pr, c, i);
            } else if (pr > c) {
                preRetourUser(pr, c, i);
            }
            endGame(c, i);
        }
        retourUser();
    }

    /*
    Fonction permettant de vérifier la proposition en la comparant au code.
    Suite à cela, attribue de nouvelles valeurs avec la formule suivante : (iMax-iMin)/2+iMin
    @param c : le "-48" permet de faire en sorte que la valeur qui sort de ce résulat soit
                bien égale à la valeur voulu. (sinon le string "0" vaut 48 une fois convertit)
     */
    public void verifCode(int j) {
        for (int i = 0; i < codeLength; i++) {
            Integer pr = prop.get(i);
            int c = (code.codePointAt(i)) - 48;
            if (pr == c) {
                preRetourUser(pr, c, i);
            } else if (pr < c) {
                intervalleMin.set(i, pr--);
                pr = (intervalleMax.get(i) - intervalleMin.get(i)) / 2 + intervalleMin.get(i);
                prop.set(i, pr);
                preRetourUser(pr, c, i);
            } else if (pr > c) {
                intervalleMax.set(i, pr++);
                pr = (intervalleMax.get(i) - intervalleMin.get(i)) / 2 + intervalleMin.get(i);
                prop.set(i, pr);
                preRetourUser(pr, c, i);
            }

            endGame(c, i);
        }
        retourUser();
        if (fin == true) {
            System.out.println("L'ordinateur a réussi à craquer le code en " + (j = j + 1) + " coups.");
        }
    }


    /*
        permet de verifier si le code est égal ou non à la proposition. si oui, fin du programme
       @param c : donne le code
       @param i : donne l'endroit où l'itération en est
     */
    public void endGame(int c, int i) {
        codeList.add(i, c);
        if (codeList.equals(prop)) {
            fin = true;
        }
        if (i == 3) {
            codeList.clear();
        }
    }

    /*
    Attribue à userFeedback un signe en focntion de la valeur du code en fin de boucle
    @param pr : la proposition
    @param c : le code
    @param i : l'itération de la boucle
     */
    public void preRetourUser(int pr, int c, int i) {
        if (pr == c) {
            userFeedback.set(i, "=");
        } else if (pr < c) {
            userFeedback.set(i, "-");
        } else if (pr > c) {
            userFeedback.set(i, "+");
        }
    }

    public void retourUser() {
        Scanner sc = new Scanner(System.in);
        boolean condition = false;
        do {
            System.out.println("Voici ce qu'a trouvé la machine comme proposition pour votre code " + prop + " (pour rappel votre code est : " + code + " )." +
                    "\nQu'en pensez vous ?" +
                    "\nSi la valeur donnée est plus importante que celle du code, répondez par +" +
                    "\nSi elle est inférieure, répondez par -" +
                    "\nSi enfin elle est égale, répondez par =");
            String retour = sc.nextLine();
            for (int i = 0; i < codeLength; i++) {
                String conditionA = userFeedback.get(i);
                String conditionB = Character.toString(retour.charAt(i));
                if (retour.length() != userFeedback.size()) {
                    System.out.println("\nÊtes-vous sûr du résultat ?\n");
                    condition = false;
                    break;
                } else if (conditionA.equals(conditionB)) {
                    condition = true;
                } else {
                    condition = false;
                    System.out.println("\nÊtes-vous sûr du résultat ?\n");
                    break;
                }
            }
        } while (condition == false);
    }
}

