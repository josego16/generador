import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import modelos.Personas;

import java.io.File;

public class XmlMarshaller {
    public static void main(String[] args) {
        JAXBContext jaxbContext;

        /*
        Localidad localidad = new Localidad(
            "Jaén", 23008, "Jaén");

        Direccion direccion = new Direccion(
            "Paseo de la Estacion", 44, localidad);


        try {
            jaxbContext = JAXBContext.newInstance(direccion.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(
                Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(direccion, new File("direccion.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        Personas personas = new Personas();
        personas.load(
                "nombre_mujer.txt",
                "nombre_hombre.txt",
                "apellidos.txt",
                "codigos-postales.csv",
                "calles.txt");

        personas.generate(100);

        try {
            jaxbContext = JAXBContext.newInstance(personas.getClass());
            Marshaller mars = jaxbContext.createMarshaller();
            mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mars.marshal(personas, new File("personas.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
