//IGAL WINICKI 251512 - NICOLAS STAROVIESCHIK 270315
package dominio;

import java.io.*;

public abstract class Persona implements Serializable {

    private String nombre;
    private int cedula;
    private int telefono;

    public Persona(String nombre, int cedula, int telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return nombre + cedula + telefono;
    }

}
