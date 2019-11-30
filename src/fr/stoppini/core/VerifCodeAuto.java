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

    private boolean fin = false;

    /*
    Travailler la dessus, pour le moment, ca renvoie bien une valeur égale à 5 pour chaque instance.
    Il faut essayer de faire les conditions en boucle de rendre tout ça propre.
    Bon courage ;p
     */

    public VerifCodeAuto() {

        init();
        retourUser();
        if(fin == false) {
            for (int j = 0; j < nombreEssais; j++) {
                verifCode();
                retourUser();
                if (fin == true) {
                    break;
                }
            }
        }else {}
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
    }

    /*
    Fonction permettant de vérifier la proposition en la comparant au code.
    Suite à cela, attribue de nouvelles valeurs avec la formule suivante : (iMax-iMin)/2+iMin
    @param c : le "-48" permet de faire en sorte que la valeur qui sort de ce résulat soit
                bien égale à la valeur voulu. (sinon le string "0" vaut 48 une fois convertit)
     */
    public void verifCode() {
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

    }


    /*

     */
    public void endGame(int c, int i) {
        codeList.add(i, c);
        System.out.println("Voici codeList : " + codeList + " et voici prop : " + prop);
        if (codeList.equals(prop)) {
            System.out.println("Cest la fin");
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

