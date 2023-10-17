package modelos;

public class Direccion {
    private String calle;
    private int numero;
    private Localidad localidad;

    public Direccion() {
    }

    public Direccion(String calle, int numero, Localidad localidad) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Direccion calle(String calle) {
        setCalle(calle);
        return this;
    }

    public Direccion numero(int numero) {
        setNumero(numero);
        return this;
    }

    public Direccion localidad(Localidad localidad) {
        setLocalidad(localidad);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " calle:'" + getCalle() + '\'' +
                ", numero:" + getNumero() + "'" +
                ", localidad:" + getLocalidad() + "'" +
                '}';
    }
}
