//IGAL WINICKI 251512 - NICOLAS STAROVIESCHIK 270315
package interfaz;
import dominio.*;
import java.awt.Desktop;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class VentanaOpciones extends javax.swing.JFrame {

    public VentanaOpciones() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSistemaPrevio = new javax.swing.JButton();
        btnSistemaNuevo = new javax.swing.JButton();
        btnArchivo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSistemaPrevio.setText("Cargar Sistema previo");
        btnSistemaPrevio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSistemaPrevioActionPerformed(evt);
            }
        });

        btnSistemaNuevo.setText("Crear nuevo Sistema");
        btnSistemaNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSistemaNuevoActionPerformed(evt);
            }
        });

        btnArchivo.setText("Archivo...");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        jLabel1.setText("Por Archivo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSistemaPrevio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(btnSistemaNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnSistemaPrevio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSistemaNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSistemaPrevioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSistemaPrevioActionPerformed
        Sistema s1 = new Sistema();
        Sistema s = s1.cargarSistema();
        MenuIngresos ingresoDeTodo = new MenuIngresos(s);
        ingresoDeTodo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSistemaPrevioActionPerformed

    private void btnSistemaNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSistemaNuevoActionPerformed
        Sistema s1 = new Sistema();
        MenuIngresos ingresoDeTodo = new MenuIngresos(s1);
        ingresoDeTodo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSistemaNuevoActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        try {
            Sistema s1 = new Sistema();
            File archivoSeleccionado;
            JFileChooser seleccionarArchivo;
            seleccionarArchivo = new JFileChooser();
            seleccionarArchivo.showOpenDialog(null);
            String nombre = seleccionarArchivo.getSelectedFile().getAbsolutePath();
            ArchivoLectura arch = new ArchivoLectura(nombre);
            while (arch.hayMasLineas()) {
                String[] datos = arch.linea().split("#");
                int numeroDeIdentificacion = Integer.parseInt(datos[0]);
                int tamaño = Integer.parseInt(datos[1]);
                boolean estantes;
                boolean refrigerado;
                if (datos[2].toString().equals("S")) {
                    estantes = true;
                } else {
                    estantes = false;
                }
                if (datos[3].toString().equals("S")) {
                    refrigerado = true;
                } else {
                    refrigerado = false;
                }
                Deposito d1 = new Deposito(numeroDeIdentificacion, tamaño, estantes, refrigerado);
                s1.agregarDeposito(d1);
            }
            arch.cerrar();
            MenuIngresos ingresoDeTodo = new MenuIngresos(s1);
            ingresoDeTodo.setVisible(true);

            this.dispose();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", 0);
        }

    }//GEN-LAST:event_btnArchivoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnSistemaNuevo;
    private javax.swing.JButton btnSistemaPrevio;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
