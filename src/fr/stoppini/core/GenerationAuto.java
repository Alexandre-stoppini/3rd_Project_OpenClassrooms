package fr.stoppini.core;

public class GenerationAuto {
    private String code = " ";
    private double X;

    public GenerationAuto() {

        for (int i = 0; i < 4/* à  remplacer par la valeur issu de properties*/; i++) {
            X = Math.round(-0.5 + Math.random() * 10);
            code = code + (int) X;
        }
    }

    public String getCode() {
        return code;
    }
}
