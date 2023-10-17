package modelos;

import jakarta.xml.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@XmlRootElement(name = "lista_personas")
@XmlAccessorType(XmlAccessType.FIELD)
public class Personas {
    @XmlElement(name = "persona")
    private List<Persona> personas;
    @XmlTransient
    private List<String> nombres_hombre;
    @XmlTransient
    private List<String> nombres_mujer;
    @XmlTransient
    private List<String> apellidos;
    @XmlTransient
    private Direcciones direcciones;


    public Personas() {
        personas = new ArrayList<Persona>();
    }

    public Personas(List<Persona> personas, List<String> nombres_hombre, List<String> nombres_mujer, List<String> apellidos, Direcciones direcciones) {
        this.personas = personas;
        this.nombres_hombre = nombres_hombre;
        this.nombres_mujer = nombres_mujer;
        this.apellidos = apellidos;
        this.direcciones = direcciones;
    }

    public List<Persona> getPersonas() {
        return this.personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<String> getNombres_hombre() {
        return this.nombres_hombre;
    }

    public void setNombres_hombre(List<String> nombres_hombre) {
        this.nombres_hombre = nombres_hombre;
    }

    public List<String> getNombres_mujer() {
        return this.nombres_mujer;
    }

    public void setNombres_mujer(List<String> nombres_mujer) {
        this.nombres_mujer = nombres_mujer;
    }

    public List<String> getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(List<String> apellidos) {
        this.apellidos = apellidos;
    }

    public Direcciones getDirecciones() {
        return this.direcciones;
    }

    public void setDirecciones(Direcciones direcciones) {
        this.direcciones = direcciones;
    }

    public Personas personas(List<Persona> personas) {
        setPersonas(personas);
        return this;
    }

    public Personas nombres_hombre(List<String> nombres_hombre) {
        setNombres_hombre(nombres_hombre);
        return this;
    }

    public Personas nombres_mujer(List<String> nombres_mujer) {
        setNombres_mujer(nombres_mujer);
        return this;
    }

    public Personas apellidos(List<String> apellidos) {
        setApellidos(apellidos);
        return this;
    }

    public Personas direcciones(Direcciones direcciones) {
        setDirecciones(direcciones);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " personas='" + getPersonas() + "'" +
                ", nombres_hombre='" + getNombres_hombre() + "'" +
                ", nombres_mujer='" + getNombres_mujer() + "'" +
                ", apellidos='" + getApellidos() + "'" +
                ", direcciones='" + getDirecciones() + "'" +
                "}";
    }

    public void load(
            String nombre_mujer_filename,
            String nombre_hombre_filename,
            String apellidos_filename,
            String localidades_filename,
            String calles_filename) {
        try {
            this.nombres_hombre = Files.readAllLines(
                    Paths.get(nombre_hombre_filename), StandardCharsets.UTF_8);
            this.nombres_mujer = Files.readAllLines(
                    Paths.get(nombre_mujer_filename), StandardCharsets.UTF_8);
            this.apellidos = Files.readAllLines(
                    Paths.get(apellidos_filename), StandardCharsets.UTF_8);
            this.direcciones = new Direcciones();
            this.direcciones.load(localidades_filename, calles_filename);
            this.direcciones.generate(1000);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void generate(int cuantas) {
        // hay que hacer el "load" antes
        if (this.apellidos != null && this.direcciones != null &&
                this.nombres_hombre != null && this.nombres_mujer != null &&
                this.personas != null) {

            for (int i = 0; i < cuantas; i++) {

                // generamos un DNI con su letra aleatoria
                int dni = ThreadLocalRandom.current().
                        nextInt(20000000, 100000000);
                String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
                int resto = dni % 23;
                char letra = caracteres.charAt(resto);
                String nif = Integer.toString(dni) + letra;

                // generamos una fecha aleatoria
                // con el número de días que hay entre el 1/1/1900 y hoy
                long diaMin = LocalDate.of(1900, 1, 1).toEpochDay();
                long diaMax = LocalDate.of(2023, 10, 17).toEpochDay();
                LocalDate fdn = LocalDate.ofEpochDay(
                        ThreadLocalRandom.current().nextLong(diaMin, diaMax));

                String nombre;
                if (ThreadLocalRandom.current().nextInt(2) == 0) {
                    nombre = this.nombres_mujer.get(
                            ThreadLocalRandom.current().nextInt(
                                    this.nombres_mujer.size()));
                } else {
                    nombre = this.nombres_hombre.get(
                            ThreadLocalRandom.current().nextInt(
                                    this.nombres_hombre.size()));
                }
                String apellido1 = this.apellidos.get(
                        ThreadLocalRandom.current().nextInt(apellidos.size()));
                String apellido2 = this.apellidos.get(
                        ThreadLocalRandom.current().nextInt(apellidos.size()));
                Direccion dir = direcciones.getDirecciones().get(
                        ThreadLocalRandom.current().nextInt(
                                direcciones.getDirecciones().size())
                );

                List<Direccion> dirs = new ArrayList<>();
                dirs.add(dir);
                Persona p = new Persona(nombre, apellido1, apellido2,
                        nif, fdn, dirs);

                // añado la persona creada a la lista de personas
                this.personas.add(p);
            }
        }

    }
}