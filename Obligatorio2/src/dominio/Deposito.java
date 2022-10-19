//IGAL WINICKI 251512 - NICOLAS STAROVIESCHIK 270315
package dominio;

import java.io.*;

public class Deposito implements Serializable, Comparable<Deposito> {

    private int numeroDeIdentificacion;
    private int tamaño;
    private boolean estantes;
    private boolean refrigerado;

    public Deposito(int numeroDeIdentificacion, int tamaño, boolean estantes, boolean refrigerado) {
        this.numeroDeIdentificacion = numeroDeIdentificacion;
        this.tamaño = tamaño;
        this.estantes = estantes;
        this.refrigerado = refrigerado;
    }

    public int getNumeroDeIdentificacion() {
        return numeroDeIdentificacion;
    }

    public int getTamaño() {
        return tamaño;
    }

    public boolean isEstantes() {
        return estantes;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    @Override
    public String toString() {
        String r = "Regrigerado";
        if (!this.isRefrigerado()) {
            r = "No Refrigerado";
        }
        String e = "Con Estantes";
        if (!this.isEstantes()) {
            e = "Sin Estantes";
        }
        return "Numero: " + this.getNumeroDeIdentificacion() + "( " + this.getTamaño() + "m2) " + r + " " + e;
    }

    public int compareTo(Deposito unDeposito) {
        return this.getNumeroDeIdentificacion() - unDeposito.getNumeroDeIdentificacion();
    }
}
