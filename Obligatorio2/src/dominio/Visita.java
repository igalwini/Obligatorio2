//IGAL WINICKI 251512 - NICOLAS STAROVIESCHIK 270315
package dominio;

import java.io.*;

public class Visita implements Serializable, Comparable<Visita> {

    private Empleado empleado;
    private int dia;
    private int mes;

    public Visita(Empleado empleado, int dia, int mes) {
        this.empleado = empleado;
        this.dia = dia;
        this.mes = mes;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    @Override
    public String toString() {
        return "Visita (" + "empleado:" + empleado + ", dia:" + dia + ", mes:" + mes + ')';
    }

    public int compareTo(Visita unaVisita) {
        int comparando = this.getMes() - unaVisita.getMes();
        if (comparando == 0) {
            comparando = this.getDia() - unaVisita.getDia();
        }
        return comparando;
    }
}
