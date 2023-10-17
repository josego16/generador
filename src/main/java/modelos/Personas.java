package modelos;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Personas {
    private List<Persona> personas;
    private List<String> nombres_hombre;
    private List<String> nombres_mujer;
    private List<String> apellidos;
    private List<Direccion> direcciones;

    public Personas() {
        personas = new ArrayList<>();
    }

    public Personas(List<Persona> personas, List<String> nombres_hombre, List<String> nombres_mujer, List<String> apellidos, List<Direccion> direcciones) {
        this.personas = personas;
        this.nombres_hombre = nombres_hombre;
        this.nombres_mujer = nombres_mujer;
        this.apellidos = apellidos;
        this.direcciones = direcciones;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<String> getNombres_hombre() {
        return nombres_hombre;
    }

    public void setNombres_hombre(List<String> nombres_hombre) {
        this.nombres_hombre = nombres_hombre;
    }

    public List<String> getNombres_mujer() {
        return nombres_mujer;
    }

    public void setNombres_mujer(List<String> nombres_mujer) {
        this.nombres_mujer = nombres_mujer;
    }

    public List<String> getApellidos() {
        return apellidos;
    }

    public void setApellidos(List<String> apellidos) {
        this.apellidos = apellidos;
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
                Random rand = new Random();
                LocalDate fdn = LocalDate.of(
                        2023 - rand.nextInt(120),
                        rand.nextInt(12) + 1,
                        rand.nextInt(28) + 1);
            }
        } else {
        }
    }
}
