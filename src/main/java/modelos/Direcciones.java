package modelos;

import jakarta.xml.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Direcciones {
    @XmlElement(name = "direccion")
    private List<Direccion> direcciones;
    @XmlTransient
    private Localidades localidades;
    @XmlTransient
    private List<String> calles;

    public Direcciones() {
        direcciones = new ArrayList<Direccion>();
    }

    public Direcciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public void add(Direccion d) {
        direcciones.add(d);
    }

    public void load(
            String localidades_filename,
            String calles_filename
    ) {
        try {
            this.calles = Files.readAllLines(Paths.get(calles_filename));
            this.localidades = new Localidades();
            localidades.load(localidades_filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generate(int cuantas) {
        if (this.calles != null && this.localidades != null) {

            this.direcciones = new ArrayList<Direccion>();
            List<Localidad> locs = this.localidades.getLocalidades();
            Random rand = new Random();

            for (int i = 0; i < cuantas; i++) {
                String calle = this.calles.get(
                        rand.nextInt(this.calles.size())
                );
                Localidad loc = locs.get(
                        rand.nextInt(locs.size())
                );
                Direccion dir = new Direccion(
                        calle, rand.nextInt(100), loc);
                this.direcciones.add(dir);
            }
        } else {
            System.out.println("ERROR: Primero hay que cargar las calles y localidades");
        }
    }

    public List<Direccion> getDirecciones() {
        return this.direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public Direcciones direcciones(List<Direccion> direcciones) {
        setDirecciones(direcciones);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
                " direcciones='" + getDirecciones() + "'" +
                "}";
    }
}