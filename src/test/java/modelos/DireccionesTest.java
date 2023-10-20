package modelos;

import org.junit.Test;

import java.io.IOException;

public class DireccionesTest {
    @Test
    public void testLoadDirecciones() throws IOException{
        Direcciones dir1 = new Direcciones();
        Direcciones dir2 = new Direcciones();

        dir1.load("codigos_postales.csv","calles.txt");
        dir2.load("codigos_postales.csv","calles.txt");
    }
}
