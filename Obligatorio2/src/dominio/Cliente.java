//IGAL WINICKI 251512 - NICOLAS STAROVIESCHIK 270315
package dominio;

import java.io.*;

public class Cliente extends Persona implements Serializable {

    private String mail;

    public Cliente(String nombre, String mail, int cedula, int telefono) {
        super(nombre, cedula, telefono);
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        return super.getNombre() + " ( " + super.getCedula() + " )--" + super.getTelefono() + "-- " + this.getMail();
    }

}
