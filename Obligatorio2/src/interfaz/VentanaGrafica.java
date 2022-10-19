//IGAL WINICKI 251512 - NICOLAS STAROVIESCHIK 270315
package interfaz;

import dominio.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class VentanaGrafica extends javax.swing.JFrame implements Observer {

    private Sistema modelo;
    JPanel panel;

    public VentanaGrafica() {
        initComponents();
    }

    public VentanaGrafica(Sistema unSistema) {

        setTitle("Gráfica Depósitos");
        setSize(800, 600);
        setLocationRelativeTo(null);
        modelo = unSistema;
        init();
        setVisible(true);
        modelo.addObserver(this);
    }

    private void init() {
        panel = new JPanel();
        getContentPane().add(panel);

        DefaultPieDataset data = new DefaultPieDataset();

        ArrayList<Deposito> listaDepositos = modelo.getListaDepositosOcupados();

        int total = listaDepositos.size();
        int sinRefSinEst = 0;
        int sinRefConEst = 0;
        int conRefSinEst = 0;
        int conRefConEst = 0;

        if (total == 0) {
            JFreeChart chart = ChartFactory.createPieChart(
                    "Gráfica Vacía",
                    data,
                    true,
                    true,
                    false);
            data.setValue("NO HAY DATOS", 100);
            ChartPanel chartPanel = new ChartPanel(chart);
            panel.add(chartPanel);
        } else {
            Iterator<Deposito> it = listaDepositos.iterator();
            while (it.hasNext()) {
                Deposito deposito = it.next();
                if (deposito.isRefrigerado() && deposito.isEstantes()) {
                    conRefConEst++;
                }
                if (!deposito.isRefrigerado() && !deposito.isEstantes()) {
                    sinRefSinEst++;
                }
                if (!deposito.isRefrigerado() && deposito.isEstantes()) {
                    sinRefConEst++;
                }
                if (deposito.isRefrigerado() && !deposito.isEstantes()) {
                    conRefSinEst++;
                }
            }

            data.setValue("No refrigerado sin estantes: " + sinRefSinEst, (sinRefSinEst * 100) / total);
            data.setValue("No refrigerado con estantes: " + sinRefConEst, (sinRefConEst * 100) / total);
            data.setValue("Con refrigerado sin estantes: " + conRefSinEst, (conRefSinEst * 100) / total);
            data.setValue("Con refrigerado con estantes: " + conRefConEst, (conRefConEst * 100) / total);

            // Creando el Grafico
            JFreeChart chart = ChartFactory.createPieChart(
                    "Grafica de depósitos alquilados - total: " + total,
                    data,
                    true,
                    true,
                    false);

            // Crear el Panel del Grafico con ChartPanel
            ChartPanel chartPanel = new ChartPanel(chart);
            panel.add(chartPanel);
        }
    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 121, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
@Override
    public void update(Observable o, Object arg) {
        panel.setVisible(false);
        init();
        modelo.getListaDepositos();

    }
}
