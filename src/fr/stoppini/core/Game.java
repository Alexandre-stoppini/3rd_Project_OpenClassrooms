package fr.stoppini.core;



public class Game {
    ChoixMode choixMode = new ChoixMode();
    private String choix = choixMode.getChoix();
    public Game() {
        if (choix.equals("1")) {
            VerifCodeManuel verifCodeManuel = new VerifCodeManuel();
        }else if (choix.equals("2")) {
            VerifCodeAuto VerifCodeAuto = new VerifCodeAuto();
        }else if (choixMode.equals("3")){
            System.out.println("Pas encore implémenté.");
        }
    }
}
