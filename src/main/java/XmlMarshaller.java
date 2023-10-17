import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import modelos.Direccion;
import modelos.Localidad;
import modelos.Personas;

import java.io.File;

public class XmlMarshaller {
    public static void main(String[] args) {
        JAXBContext jaxb;

        Localidad local = new Localidad("Jaen", 23340, "Arroyo del Ojanco");
        Direccion dir = new Direccion("Calle travesia vinias", 15, local);

        try {
            jaxb = JAXBContext.newInstance(dir.getClass());
            Marshaller marsh = jaxb.createMarshaller();
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marsh.marshal(dir, new File("direccion.xml"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Personas personas = new Personas();
        personas.load("nombre_mujer.txt",
                "nombre_hombre.txt",
                "apellidos.txt",
                "codigos-postales.csv",
                "calles.txt");
        personas.generate(10);
        try {
            jaxb = JAXBContext.newInstance(personas.getClass());
            Marshaller mars = jaxb.createMarshaller();
            mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mars.marshal(personas, new File("personas.xml"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
