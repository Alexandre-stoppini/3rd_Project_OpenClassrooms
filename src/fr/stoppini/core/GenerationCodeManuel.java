package fr.stoppini.core;

import fr.stoppini.get_prop.SimiliGetPropValues;

import java.util.Scanner;

public class GenerationCodeManuel {

    SimiliGetPropValues similiGetPropValues = new SimiliGetPropValues();
    Scanner sc = new Scanner(System.in);
    private String nombreEntree = similiGetPropValues.getNombreEntree();
    private String codeManuel;

    public GenerationCodeManuel() {
        System.out.println("Veuillez entrer un nombre composé de "+ nombreEntree + " chiffres.");
        codeManuel = sc.nextLine();

    }

    public String getCodeManuel() {
        return codeManuel;
    }
}
