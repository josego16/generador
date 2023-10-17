import modelos.Localidades;

public class App {
    public static void main(String[] args) {
        Localidades localidades = new Localidades();
        localidades.load("codigos-postales.csv");
        System.out.println(localidades);
    }
}