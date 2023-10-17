package modelos;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private LocalDate fdn;
    private Direcciones direcciones;


    public Persona() {
    }

    public Persona(String nombre, String apellido1, String apellido2, String dni, LocalDate fdn, Direcciones direcciones) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.fdn = fdn;
        this.direcciones = direcciones;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFdn() {
        return this.fdn;
    }

    public void setFdn(LocalDate fdn) {
        this.fdn = fdn;
    }

    public Direcciones getDirecciones() {
        return this.direcciones;
    }

    public void setDirecciones(Direcciones direcciones) {
        this.direcciones = direcciones;
    }

    public Persona nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Persona apellido1(String apellido1) {
        setApellido1(apellido1);
        return this;
    }

    public Persona apellido2(String apellido2) {
        setApellido2(apellido2);
        return this;
    }

    public Persona dni(String dni) {
        setDni(dni);
        return this;
    }

    public Persona fdn(LocalDate fdn) {
        setFdn(fdn);
        return this;
    }

    public Persona direcciones(Direcciones direcciones) {
        setDirecciones(direcciones);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " nombre='" + getNombre() + "'" +
                ", apellido1='" + getApellido1() + "'" +
                ", apellido2='" + getApellido2() + "'" +
                ", dni='" + getDni() + "'" +
                ", fdn='" + getFdn() + "'" +
                ", direcciones='" + getDirecciones() + "'" +
                "}";
    }

}
