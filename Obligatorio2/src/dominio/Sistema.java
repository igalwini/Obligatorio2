//IGAL WINICKI 251512 - NICOLAS STAROVIESCHIK 270315
package dominio;

import dominio.*;
import java.util.*;
import java.io.*;

public class Sistema extends Observable implements Serializable {

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Deposito> listaDepositos;
    private ArrayList<Contrato> listaContratos;
    private int numerarContratos;

    public Sistema() {
        listaClientes = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
        listaDepositos = new ArrayList<>();
        listaContratos = new ArrayList<>();
        numerarContratos = 1;
    }

    public int getNumerarContratos() {
        return numerarContratos;
    }

    public void sumarContratos() {
        this.numerarContratos = numerarContratos + 1;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public ArrayList<Deposito> getListaDepositos() {
        return listaDepositos;
    }

    public ArrayList<Contrato> getListaContratos() {
        return listaContratos;
    }

    public ArrayList<Deposito> getListaDepositosDisponibles() {
        ArrayList<Deposito> aux = new ArrayList<>();
        ArrayList<Deposito> listaDepositos = this.getListaDepositos();
        Iterator<Deposito> it = listaDepositos.iterator();
        while (it.hasNext()) {
            Deposito deposito = it.next();
            if (!estaDeposito(deposito)) {
                aux.add(deposito);
            }
        }
        return aux;
    }

    public ArrayList<Deposito> getListaDepositosOcupados() {
        ArrayList<Deposito> aux = new ArrayList<>();
        ArrayList<Deposito> listaDepositos = this.getListaDepositos();
        Iterator<Deposito> it = listaDepositos.iterator();
        while (it.hasNext()) {
            Deposito deposito = it.next();
            if (estaDeposito(deposito)) {
                aux.add(deposito);
            }
        }
        return aux;
    }

    public boolean estaDeposito(Deposito deposito) {
        boolean esta = false;
        ArrayList<Contrato> listaContratos = this.getListaContratos();
        Iterator<Contrato> it = listaContratos.iterator();
        while (it.hasNext()) {
            Contrato contrato = it.next();
            if (contrato.getDeposito() == deposito) {
                esta = true;
            }
        }
        return esta;
    }

    public Contrato cualContrato(Deposito deposito) {
        Contrato contrato = null;
        ArrayList<Contrato> listaContratos = this.getListaContratos();
        Iterator<Contrato> it = listaContratos.iterator();
        while (it.hasNext()) {
            Contrato c = it.next();
            if (c.getDeposito() == deposito) {
                contrato = c;
            }
        }
        return contrato;
    }

    public void agregarCliente(Cliente unCliente) {
        this.getListaClientes().add(unCliente);
        setChanged();
        notifyObservers();
    }

    public void agregarEmpleado(Empleado unEmpleado) {
        this.getListaEmpleados().add(unEmpleado);
        setChanged();
        notifyObservers();
    }

    public void agregarDeposito(Deposito unDeposito) {
        this.getListaDepositos().add(unDeposito);
        setChanged();
        notifyObservers();
    }

    public void agregarContrato(Contrato unContrato) {
        this.getListaContratos().add(unContrato);
        setChanged();
        notifyObservers();
    }

    public boolean estaNumeroCedula(int num) {
        boolean esta = false;
        ArrayList<Cliente> listaClientes = this.getListaClientes();
        Iterator<Cliente> it = listaClientes.iterator();
        while (it.hasNext()) {
            Cliente cliente = it.next();
            if (cliente.getCedula() == num) {
                esta = true;
            }
        }
        ArrayList<Empleado> listaEmpleados = this.getListaEmpleados();
        Iterator<Empleado> it2 = listaEmpleados.iterator();
        while (it2.hasNext()) {
            Empleado empleado = it2.next();
            if (empleado.getCedula() == num) {
                esta = true;
            }
        }
        return esta;
    }

    public Sistema cargarSistema() {
        Sistema sistema = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATOS.TXT"));
            sistema = (Sistema) in.readObject();
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error al cargar el sistema 1");
            sistema = new Sistema();
        } catch (IOException ex) {
            System.out.println("Error al cargar el sistema 2");
            sistema = new Sistema();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el sistema 3");
            sistema = new Sistema();
        }
        return sistema;
    }

    public void guardarSistema(Sistema unSistema) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DATOS.TXT"));
            out.writeObject(unSistema);
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Hubo un problema al persistir");
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println("Hubo un problema al persistir");
            System.out.println("IOException");
        }
    }
}
