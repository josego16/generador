package modelos;

public class Localidad {
    //private string municipio
    private String poblacion;
    private int cp;
    private String provincia;

    public Localidad() {
    }

    public Localidad(String poblacion, int cp, String provincia) {
        this.poblacion = poblacion;
        this.cp = cp;
        this.provincia = provincia;
    }

    public String getpoblacion() {
        return poblacion;
    }

    public void setpoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getCp() {
        return this.cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Localidad poblacion(String poblacion) {
        setpoblacion(poblacion);
        return this;
    }

    public Localidad cp(int cp) {
        setCp(cp);
        return this;
    }

    public Localidad provincia(String provincia) {
        setProvincia(provincia);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "poblacion:'" + getpoblacion() + '\'' +
                ", cp:" + getCp() + "'" +
                ", provincia: '" + getProvincia() + '\'' +
                '}';
    }
}
