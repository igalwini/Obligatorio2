//IGAL WINICKI 251512 - NICOLAS STAROVIESCHIK 270315
package dominio;

import java.io.*;

import java.util.*;

public class ArchivoGrabacion {

    private Formatter out;

    public ArchivoGrabacion(String unNombre, boolean ext) {
        try {
            //Si el parametro ext es true, extiendo el archivo
            //Si es false, sobreescribo
            FileWriter f = new FileWriter(unNombre, ext);
            out = new Formatter(f);
        } catch (IOException ex) {
            System.out.println("Error con el archivo de grabacion");
        }
    }

    public ArchivoGrabacion(String nombre) {
        try {
            out = new Formatter(nombre);
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo crear");
        }
    }

    public void grabarLinea(String linea) {
        out.format("%s%n", linea);
    }

    public void cerrar() {
        out.close();
    }
}
