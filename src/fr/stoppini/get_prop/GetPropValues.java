package fr.stoppini.get_prop;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropValues {


    private String modeDev;
    private String nombreEssais;
    private String nombreEntree;
    private InputStream inputstream;

    public String getPropertiesValues() throws IOException {
        Properties prop = new Properties();
        String propFile = "ressource.properties";

        inputstream = getClass().getClassLoader().getResourceAsStream(propFile);
        try {
            prop.load(inputstream);
            modeDev = prop.getProperty("modeDev");
            nombreEssais = prop.getProperty("nombreEssais");
            nombreEntree = prop.getProperty("nombreEntree");
            return modeDev + " " + nombreEssais + " " + nombreEntree;
        } finally {
            if (inputstream != null) {
                inputstream.close();
            }
        }
    }
    // *******************Getter*****************

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


