//IGAL WINICKI 251512 - NICOLAS STAROVIESCHIK 270315
package interfaz;
import dominio.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaConsultaBaja extends javax.swing.JFrame implements Observer {

    private Sistema modelo;

    public VentanaConsultaBaja() {
        initComponents();
    }

    public VentanaConsultaBaja(Sistema unSistema) {
        initComponents();
        modelo = unSistema;
        modelo.addObserver(this);
        listaContratosPantalla();
    }

    public void listaContratosPantalla() {
        lstContratos.setListData(modelo.getListaContratos().toArray());
    }

    public void cargarTabla(Contrato contrato) {
        if (contrato != null) {
            Collections.sort(contrato.getListaVisitas());
            ArrayList<Visita> listaVisitas = contrato.getListaVisitas();
            Iterator<Visita> it = listaVisitas.iterator();

            while (it.hasNext()) {
                Visita v = it.next();
                int dia = v.getDia();
                int mes = v.getMes();
                String empleado = v.getEmpleado().getNombre();
                DefaultTableModel prueba = (DefaultTableModel) tblTabla.getModel();
                prueba.addRow(new Object[]{dia, mes, empleado});

            }
        }

    }

    public void ventanaConfirmacion() {
        int panel = JOptionPane.showConfirmDialog(null, "Desea dar de baja este contrato?", "Confirmación", 2);
        if (panel == 0) {//SI ES 0
            Contrato c = (Contrato) lstContratos.getSelectedValue();
            String nombre = c.getCliente().getNombre();
            int num = c.getNum();
            ArchivoGrabacion arch = new ArchivoGrabacion(nombre + " " + num + ".TXT");
            for (int i = 0; i < c.getCantVisitas(); i++) {
                Visita v = c.getListaVisitas().get(i);
                arch.grabarLinea(v.toString());
            }
            modelo.getListaContratos().remove(c);

            listaContratosPantalla();
            arch.cerrar();

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstContratos = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        btnBaja = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta/Baja");

        lstContratos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstContratos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstContratosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstContratos);

        jLabel1.setText("Contratos");

        btnBaja.setText("Baja");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Día", "Mes", "Empleado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(347, 347, 347))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void lstContratosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstContratosValueChanged
        DefaultTableModel model = (DefaultTableModel) tblTabla.getModel();
        model.setRowCount(0);
        cargarTabla((Contrato) lstContratos.getSelectedValue());

    }//GEN-LAST:event_lstContratosValueChanged

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        ventanaConfirmacion();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBajaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstContratos;
    private javax.swing.JTable tblTabla;
    // End of variables declaration//GEN-END:variables
@Override
    public void update(Observable o, Object arg) {
        listaContratosPantalla();
    }
}
