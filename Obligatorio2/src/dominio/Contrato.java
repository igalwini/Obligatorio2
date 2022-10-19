//IGAL WINICKI 251512 - NICOLAS STAROVIESCHIK 270315
package dominio;

import java.util.*;
import java.io.*;

public class Contrato extends Observable implements Serializable {

    private Cliente cliente;
    private Empleado empleado;
    private Deposito deposito;
    private int num;
    private String detalleAlquiler;
    private int cantVisitas;
    private ArrayList<Visita> listaVisitas;

    public Contrato(Cliente cliente, Empleado empleado, Deposito deposito, String detalleAlquiler, int num) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.deposito = deposito;
        this.detalleAlquiler = detalleAlquiler;
        this.num = num;
        this.cantVisitas = 0;
        this.listaVisitas = new ArrayList<Visita>();
    }

    public ArrayList<Visita> getListaVisitas() {
        return listaVisitas;
    }

    public int getCantVisitas() {
        return cantVisitas;
    }

    public void agregarVisita(int dia, int mes, Empleado empleado) {
        this.cantVisitas = this.cantVisitas + 1;
        Visita v = new Visita(empleado, dia, mes);
        listaVisitas.add(v);
        setChanged();
        notifyObservers();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNum() {
        return num;
    }

    public String getDetalleAlquiler() {
        return detalleAlquiler;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    @Override
    public String toString() {
        return "Nro: " + num + " - " + "Dep:" + this.getDeposito().getNumeroDeIdentificacion() + " (" + this.getDetalleAlquiler() + ") " + this.getCantVisitas();
    }

}
