package fr.stoppini.core;


import fr.stoppini.get_prop.SimiliGetPropValues;
import java.util.ArrayList;
import java.util.List;

public class VerifCodeAuto {

    private List<Integer> prop = new ArrayList<Integer>();
    private List<Integer> intervalleMin = new ArrayList<>();
    private List<Integer> intervalleMax = new ArrayList<>();

    private List<String> userFeedback = new ArrayList<String>();

    GenerationCodeManuel generationCodeManuel = new GenerationCodeManuel();
    private String code = generationCodeManuel.getCodeManuel();

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
        for (int i = 0; i <codeLength;i++) {
            intervalleMin.add(i, 0);
            intervalleMax.add(i,10);
            int iMin = intervalleMin.get(i);
            int iMax = intervalleMax.get(i);
            prop.add((iMax-iMin)/2+iMin);


            Character c = code.charAt(i);
            Integer pr = prop.get(i);
            System.out.println(pr);
        }
    }
    /*public void createI_Min(int i){
        iMin.add(i,0);

    }
    public void createI_Max(int i){
        iMax.add(i,10);
    }
    public void createProp(int i){
        //prop.add(i,(iMax-iMin)/2+iMin);
    }*/
}

