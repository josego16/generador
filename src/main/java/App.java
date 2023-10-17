import modelos.Localidades;
import modelos.Personas;

public class App {
    public static void main(String[] args) {
        Localidades localidades = new Localidades();
        localidades.load("codigos-postales.csv");
        System.out.println(localidades);

        Personas per = new Personas();
        per.load("nombre_mujer.txt",
                "nombre_hombre.txt",
                "apellidos.txt",
                "codigos-postales.csv",
                "calles.txt");
        per.generate(5);
        System.out.println(per.getPersonas().toString());
    }
}