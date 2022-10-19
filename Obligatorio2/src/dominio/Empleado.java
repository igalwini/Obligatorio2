//IGAL WINICKI 251512 - NICOLAS STAROVIESCHIK 270315
package dominio;

import java.io.*;

public class Empleado extends Persona implements Serializable {

    private String direccion;
    private int añoIngreso;

    public Empleado(String nombre, String direccion, int cedula, int añoIngreso, int telefono) {
        super(nombre, cedula, telefono);
        this.direccion = direccion;
        this.añoIngreso = añoIngreso;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getAñoIngreso() {
        return añoIngreso;
    }

    @Override
    public String toString() {
        return getNombre() + " (" + super.getCedula() + ")  " + super.getTelefono() + "--[" + getDireccion() + "]--" + getAñoIngreso();
    }

}
