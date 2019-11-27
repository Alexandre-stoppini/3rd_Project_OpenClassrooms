package fr.stoppini.test;



import fr.stoppini.core.GenerationCodeManuel;
import fr.stoppini.get_prop.SimiliGetPropValues;

import java.util.ArrayList;
import java.util.List;

public class TestVerifCodeAuto {
    private String prop = " ";
    private List<String> userFeedback = new ArrayList<String>();
    private boolean runCode = true;
    GenerationCodeManuel generationCodeManuel = new GenerationCodeManuel();
    private String code = generationCodeManuel.getCodeManuel();

    SimiliGetPropValues similiGetPropValues = new SimiliGetPropValues();
    private int nombreEssais = Integer.parseInt(similiGetPropValues.getNombreEssais());


    public TestVerifCodeAuto(){

        System.out.println("nombreEssais : " + nombreEssais);
        System.out.println("code : " + code);


    }
}
