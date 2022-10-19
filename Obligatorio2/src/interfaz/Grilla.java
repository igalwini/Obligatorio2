//IGAL WINICKI 251512 - NICOLAS STAROVIESCHIK 270315
package interfaz;

import java.awt.*;
import javax.swing.*;
import dominio.*;
import java.awt.event.ActionListener;
import java.util.*;

public class Grilla extends javax.swing.JFrame implements Observer {
    private Sistema modelo;
    JPanel panel;JScrollPane scroll;
    
    public Grilla() {
        initComponents();
    }

    public Grilla(Sistema unSistema) {
        modelo = unSistema;
        cargarGrilla();
        modelo.addObserver(this);
    }

    public void cargarGrilla() {
        panel = new JPanel();
        scroll = new JScrollPane();
        getContentPane().add(panel);
        this.getContentPane().add(scroll);
        for (int i = 0; i < modelo.getListaDepositos().size(); i++) {
            Collections.sort(modelo.getListaDepositos());
            Deposito deposito = modelo.getListaDepositos().get(i);
            int numeroDepositos = deposito.getNumeroDeIdentificacion();
            JButton btni = new JButton("Num: " + numeroDepositos);
            panel.add(btni);
            // setting grid layout of x rows and 5 columns
            panel.setLayout(new GridLayout(0,5));
            panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            String refrigerado;
            String estantes;
            if (deposito.isRefrigerado()) {
                refrigerado = "SI";
            } else {
                refrigerado = "NO";
            }
            if (deposito.isEstantes()) {
                estantes = "SI";
            } else {
                estantes = "NO";
            }
            if (modelo.getListaDepositosDisponibles().contains(deposito)) {
                btni.setBackground(Color.green);
                btni.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    JOptionPane.showMessageDialog(null, "Número: " + deposito.getNumeroDeIdentificacion() + "\n" + "Tamaño: " + deposito.getTamaño() + "m2" + "\n" + "Refrigerado: " + refrigerado + "\n" + "Tiene estantes: " + estantes, "depósito  " + deposito.getNumeroDeIdentificacion(), 1);
                }
            });
            } else {
                btni.setBackground(Color.red);
                btni.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Contrato contrato = modelo.cualContrato(deposito);
                    JOptionPane.showMessageDialog(null, "Número de contrato: "+contrato.getNum()+"\n"+"Nombre del cliente: "+contrato.getCliente().getNombre()+"\n"+"Cantidad de visitas: "+contrato.getCantVisitas()+"\n"+"Número: " + deposito.getNumeroDeIdentificacion() + "\n" + "Tamaño: " + deposito.getTamaño() + "m2" + "\n" + "Refrigerado: " + refrigerado + "\n" + "Tiene estantes: " + estantes+"\n", "Depósito " + deposito.getNumeroDeIdentificacion(), 1);
                }
            });
            }
            
        }
        
        scroll.setViewportView(panel);
        //panel.setSize(400, 400);
        this.setSize(400, 400);
        //panel.setVisible(true);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventana Depósitos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
 @Override
    public void update(Observable o, Object arg) {
       // modelo.getListaDepositos().size();
       // modelo.getListaDepositos();
        this.remove(scroll);
        
        cargarGrilla();
        panel.revalidate();
        
        
    }
}
