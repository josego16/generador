package modelos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Localidades {
    private List<Localidad> localidades;


    public Localidades() {
    }

    public Localidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    public List<Localidad> getLocalidades() {
        return this.localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    public Localidades localidades(List<Localidad> localidades) {
        setLocalidades(localidades);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " localidades: " + getLocalidades() + "}";
    }


    public void load(String filename) {
        try {

            List<String> lineas = Files.readAllLines(
                    Paths.get(filename),
                    StandardCharsets.UTF_8);
            this.localidades = new ArrayList<>();
            for (int i = 1; i < lineas.size(); i++) {
                String[] celdas = lineas.get(i).split(";");
                Localidad loc = new Localidad(
                        celdas[1],
                        Integer.parseInt(celdas[0]),
                        celdas[3]);
                localidades.add(loc);
            }

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}

