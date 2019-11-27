package fr.stoppini.core;

import fr.stoppini.get_prop.SimiliGetPropValues;

import java.util.Scanner;

public class GenerationCodeManuel {

    SimiliGetPropValues similiGetPropValues = new SimiliGetPropValues();
    Scanner sc = new Scanner(System.in);
    private String nombreEntree = similiGetPropValues.getNombreEntree();
    private String codeManuel;
    private boolean tryCatch = true;

    public GenerationCodeManuel() {
        System.out.println("Vous allez devoir defier un algorithme.");
        do {
            System.out.println("Vous devez rentrer une série de " + nombreEntree + " chiffres afin de commencer le défi." +
                    "\nEntrer votre combinaison : ");
            codeManuel = sc.nextLine();
            TryAndCatch();
        }while(tryCatch==true);


    }

    public void TryAndCatch(){
        if (codeManuel.length() != Integer.parseInt(nombreEntree) ) {
            System.out.println("Erreur de contenu. Veuillez effectuer une nouvelle saisie.");
            tryCatch = true;
        }else if (codeManuel.matches("[^0-9]")) {
            System.out.println("Erreur de contenu. Veuillez effectuer une nouvelle saisie.");
            tryCatch = true;
        }else{tryCatch=false;}
    }

    public String getCodeManuel() {
        return codeManuel;
    }
}
