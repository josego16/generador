import modelos.Personas;

public class App {
    public static void main(String[] args) {
        Personas people = new Personas();
        people.load("nombre_mujer.txt",
                "nombre_hombre.txt",
                "apellidos.txt",
                "codigos-postales.csv",
                "calles.txt");
        people.generate(5);
        System.out.println(people.getPersonas().toString());
    }
}