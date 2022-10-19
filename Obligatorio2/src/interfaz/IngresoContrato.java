//IGAL WINICKI 251512 - NICOLAS STAROVIESCHIK 270315
package interfaz;

import dominio.*;
import java.awt.*;

import java.util.*;
import static javax.management.Query.value;
import javax.swing.*;

public class IngresoContrato extends javax.swing.JFrame implements Observer {

    private Sistema modelo;

  
    public IngresoContrato() {
        initComponents();
    }

    public IngresoContrato(Sistema unSistema) {
        modelo = unSistema;

        initComponents();
        listaClientesPantalla();
        listaEmpleadosPantalla();
        
        rdoENoRelevante.setSelected(true);
        rdoRNoRelevante.setSelected(true);
        modelo.addObserver(this);
        Collections.sort(modelo.getListaDepositos());
        lstDepositos.setListData(modelo.getListaDepositosDisponibles().toArray());
        pintar();
        
     
    }

    public void listaClientesPantalla() {
        lstClientes.setListData(modelo.getListaClientes().toArray());
    }

    public void listaEmpleadosPantalla() {
        lstEmpleados.setListData(modelo.getListaEmpleados().toArray());
    }

    public void cargarListaDepositos(int min, int max, boolean estantesRelevante, boolean estantes, boolean refrigeradoRelevante, boolean refrigerado) {
        ArrayList<Deposito> listaAux = new ArrayList<>();
        ArrayList<Deposito> listaDepositos = modelo.getListaDepositosDisponibles();
        Iterator<Deposito> it = listaDepositos.iterator();
        while (it.hasNext()) {
            Deposito dep = it.next();
            boolean seAgrega = true;
            if (dep.getTamaño() < min || dep.getTamaño() > max) {
                seAgrega = false;
            }
            if (!estantesRelevante) {
                if (estantes != dep.isEstantes()) {
                    seAgrega = false;
                }
            }
            if (!refrigeradoRelevante) {
                if (refrigerado != dep.isRefrigerado()) {
                    seAgrega = false;

                }
            }
            if (seAgrega) {
                listaAux.add(dep);
            }
        }
        lstDepositos.setListData(listaAux.toArray());
    }
    public void pintar() {
        
                lstDepositos.setCellRenderer(new DefaultListCellRenderer() {
                    @Override
                    public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus) {
                        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                        Deposito deposito = (Deposito) value;
                        
                        
                        if (deposito.isRefrigerado() && deposito.isEstantes()) {
                            setBackground(Color.GREEN);
                        } else {
                            if (!deposito.isRefrigerado() && !deposito.isEstantes()) {
                                setBackground(Color.getHSBColor((float)0.48333335,(float)0.71428573,(float)0.8784314));
                            } else {
                                if (!deposito.isRefrigerado() && deposito.isEstantes()) {
                                    setBackground(Color.YELLOW);
                                } else {
                                    setBackground(Color.ORANGE);
                                }
                            }
                        }
                        return this;
                    }
                });
            }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEmpleados = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstClientes = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstDepositos = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTamañoMinimo = new javax.swing.JTextField();
        txtTamañoMaximo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDetalleAlquiler = new javax.swing.JTextField();
        rdoCEstantes = new javax.swing.JRadioButton();
        rdoENoRelevante = new javax.swing.JRadioButton();
        rdoRefrigerado = new javax.swing.JRadioButton();
        rdoSEstantes = new javax.swing.JRadioButton();
        rdoNoRefrigerado = new javax.swing.JRadioButton();
        rdoRNoRelevante = new javax.swing.JRadioButton();
        btnDeposito = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso Contratos");

        jLabel1.setText("Clientes");

        jLabel2.setText("Empleados");

        lstEmpleados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstEmpleados);

        lstClientes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstClientes);

        lstDepositos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(lstDepositos);

        jLabel3.setText("Depósitos a alquilar");

        jLabel4.setText("Tamaño mínimo");

        jLabel5.setText("Tamaño máximo");

        jLabel6.setText("Detalle alquiler");

        buttonGroup1.add(rdoCEstantes);
        rdoCEstantes.setText("Con Estantes");

        buttonGroup1.add(rdoENoRelevante);
        rdoENoRelevante.setText("No relevante");
        rdoENoRelevante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoENoRelevanteActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoRefrigerado);
        rdoRefrigerado.setText("Refrigerado");

        buttonGroup1.add(rdoSEstantes);
        rdoSEstantes.setText("Sin Estantes");

        buttonGroup2.add(rdoNoRefrigerado);
        rdoNoRefrigerado.setText("No Refrigerado");

        buttonGroup2.add(rdoRNoRelevante);
        rdoRNoRelevante.setText("No relevante");

        btnDeposito.setText("Depósito");
        btnDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositoActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTamañoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2)))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6))
                            .addComponent(jScrollPane3)
                            .addComponent(txtDetalleAlquiler, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTamañoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoCEstantes)
                                .addGap(18, 18, 18)
                                .addComponent(rdoRefrigerado))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoENoRelevante)
                                .addGap(18, 18, 18)
                                .addComponent(rdoRNoRelevante))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoSEstantes)
                                .addGap(23, 23, 23)
                                .addComponent(rdoNoRefrigerado)))
                        .addGap(30, 30, 30)
                        .addComponent(btnDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDetalleAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTamañoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTamañoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoCEstantes)
                            .addComponent(rdoRefrigerado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoSEstantes)
                            .addComponent(rdoNoRefrigerado, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoENoRelevante)
                            .addComponent(rdoRNoRelevante))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int min;
    int max;
    private void btnDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositoActionPerformed

        if (txtTamañoMinimo.getText().isBlank()) {
            min = 0;
        } else {
            min = Integer.parseInt(txtTamañoMinimo.getText());
        }

        if (txtTamañoMaximo.getText().isBlank()) {
            max = Integer.MAX_VALUE;
        } else {
            max = Integer.parseInt(txtTamañoMaximo.getText());
        }

        boolean estantesRelevante = rdoENoRelevante.isSelected();
        boolean estantes = rdoCEstantes.isSelected();
        boolean refrigeradoRelevante = rdoRNoRelevante.isSelected();
        boolean refrigerado = rdoRefrigerado.isSelected();
        cargarListaDepositos(min, max, estantesRelevante, estantes, refrigeradoRelevante, refrigerado);

        txtTamañoMinimo.setText("");
        txtTamañoMaximo.setText("");
        pintar();
        Collections.sort(modelo.getListaDepositos());
    }//GEN-LAST:event_btnDepositoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();//        this.setVisible(false);    }//GEN-LAST:event_btnSalirActionPerformed
    }
    private void rdoENoRelevanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoENoRelevanteActionPerformed
        // TODO add dyour handling e here:
    }//GEN-LAST:event_rdoENoRelevanteActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        boolean estantesRelevante = rdoENoRelevante.isSelected();
        boolean estantes = rdoCEstantes.isSelected();
        boolean refrigeradoRelevante = rdoRNoRelevante.isSelected();
        boolean refrigerado = rdoRefrigerado.isSelected();
        Cliente cliente = (Cliente) lstClientes.getSelectedValue();
        if (lstClientes.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar Cliente", "Error", 0);
        } else {
            Empleado empleado = (Empleado) lstEmpleados.getSelectedValue();
            if (lstEmpleados.getSelectedValue() == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar Empleado", "Error", 0);
            } else {
                Deposito deposito = (Deposito) lstDepositos.getSelectedValue();
                if (lstDepositos.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un deposito", "Error", 0);
                } else {
                    if (lstDepositos.getSelectedIndices().length > 1) {
                        String detalleAlquiler = txtDetalleAlquiler.getText();
                        for (int i = 0; i < lstDepositos.getSelectedIndices().length; i++) {
                            Contrato c1 = new Contrato(cliente, empleado, (Deposito)lstDepositos.getSelectedValuesList().get(i), detalleAlquiler, modelo.getNumerarContratos());
                            modelo.sumarContratos();
                            modelo.agregarContrato(c1);
                          
                           
                           
                        }
                        cargarListaDepositos(min, max, estantesRelevante, estantes, refrigeradoRelevante, refrigerado);
                        JOptionPane.showMessageDialog(null, "Se registraron los contratos", "Registro Contratos", 1);
                    } else {
                        String detalleAlquiler = txtDetalleAlquiler.getText();
                      

                        if (txtTamañoMinimo.getText().isBlank()) {
                            min = 0;
                        } else {
                            min = Integer.parseInt(txtTamañoMinimo.getText());
                        }

                        if (txtTamañoMaximo.getText().isBlank()) {
                            max = Integer.MAX_VALUE;
                        } else {
                            max = Integer.parseInt(txtTamañoMaximo.getText());
                        }
                        Contrato c1 = new Contrato(cliente, empleado, deposito, detalleAlquiler, modelo.getNumerarContratos());
                        modelo.sumarContratos();
                        modelo.agregarContrato(c1);
                        JOptionPane.showMessageDialog(null, "Se registro el contrato", "Registro Contratos", 1);
                       
                        
                        cargarListaDepositos(min, max, estantesRelevante, estantes, refrigeradoRelevante, refrigerado);
                        txtDetalleAlquiler.setText("");
                    }

                }
            }
        }


    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDeposito;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList lstClientes;
    private javax.swing.JList lstDepositos;
    private javax.swing.JList lstEmpleados;
    private javax.swing.JRadioButton rdoCEstantes;
    private javax.swing.JRadioButton rdoENoRelevante;
    private javax.swing.JRadioButton rdoNoRefrigerado;
    private javax.swing.JRadioButton rdoRNoRelevante;
    private javax.swing.JRadioButton rdoRefrigerado;
    private javax.swing.JRadioButton rdoSEstantes;
    private javax.swing.JTextField txtDetalleAlquiler;
    private javax.swing.JTextField txtTamañoMaximo;
    private javax.swing.JTextField txtTamañoMinimo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        listaClientesPantalla();
        listaEmpleadosPantalla();
    }
}
