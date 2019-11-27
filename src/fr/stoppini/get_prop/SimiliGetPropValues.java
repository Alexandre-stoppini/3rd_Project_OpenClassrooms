package fr.stoppini.get_prop;

public class SimiliGetPropValues {
    private String modeDev = "false";
    private String nombreEssais = "4";
    private String nombreEntree = "4";
public String SimiliGetPropValues(){
    return modeDev + " " + nombreEssais + " " + nombreEntree;
}
    public String getModeDev() {
        return modeDev;
    }

    public String getNombreEssais() {
        return nombreEssais;
    }

    public String getNombreEntree() {
        return nombreEntree;
    }
}
