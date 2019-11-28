package fr.stoppini.core;


import fr.stoppini.get_prop.SimiliGetPropValues;

import java.util.ArrayList;
import java.util.List;

public class VerifCodeAuto {

    /*
    Série de variable inhérente à la recherche du code
     */
    private List<Integer> prop = new ArrayList<Integer>();
    private List<Integer> intervalleMin = new ArrayList<>();
    private List<Integer> intervalleMax = new ArrayList<>();

    /*
    Variable servant à rendre à user ce que l'ordi fait. Se faisant, il peut "dialoguer" avec ce dernier.
     */
    private List<String> userFeedback = new ArrayList<String>();

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
    Travailler la dessus, pour le moment, ca renvoie bien une valeur égale à 5 pour chaque instance.
    Il faut essayer de faire les conditions en boucle de rendre tout ça propre.
    Bon courage ;p
     */

    public VerifCodeAuto() {

        System.out.println("nombreEssais : " + nombreEssais);
        System.out.println("code : " + code);
        init();
        System.out.println(prop);
        // for (int i = 0; i < nombreEssais; i++) {
        verifCode();
        //}
    }

    /*
    Fonction permettant de créer une proposition initiale pour le code à déchiffrer.
     */
    public void init() {
        for (int i = 0; i < codeLength; i++) {
            intervalleMin.add(i, 0);
            intervalleMax.add(i, 10);
            int iMin = intervalleMin.get(i);
            int iMax = intervalleMax.get(i);
            prop.add((iMax - iMin) / 2 + iMin);
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
            int c = (code.codePointAt(i)) - 48; //
            if (pr == c) {
                System.out.println("Valeur pr : " + pr + " Valeur c : " + c);
                System.out.println("=");
            } else if (pr < c) {
                System.out.println("Valeur pr : " + pr + " Valeur c : " + c);
                System.out.println("-");
            } else if (pr > c) {
                System.out.println("Valeur pr : " + pr + " Valeur c : " + c);
                System.out.println("+");
            }
        }
    }

    public void retourUser() {

    }

}

