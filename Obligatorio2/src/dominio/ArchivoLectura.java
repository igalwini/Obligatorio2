//IGAL WINICKI 251512 - NICOLAS STAROVIESCHIK 270315
package dominio;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ArchivoLectura {

    private Scanner in;
    private String linea;

    public ArchivoLectura(String unNombre) {
        try {
            Path p = Paths.get(unNombre);
            System.out.println(p.toAbsolutePath());
            in = new Scanner(Paths.get(unNombre));
        } catch (IOException ex) {
            System.out.println("No se encontro el archivo");
        }
    }

    public boolean hayMasLineas() {
        //Se fija si hay mas lineas y setea linea en la proxima
        boolean hayMas = false;
        linea = null;
        if (in.hasNext()) {
            linea = in.nextLine();
            hayMas = true;
        }
        return hayMas;
    }

    public String linea() {
        //retorna la ultima linea leida
        return linea;
    }

    public void cerrar() {
        in.close();
    }

}
