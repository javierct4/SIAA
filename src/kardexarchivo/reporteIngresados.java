/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * reporteIngresados.java
 *
 * Created on 18-ago-2013, 18:37:18
 */

package kardexarchivo;

import java.awt.Point;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author MEGASYSTEM
 */
public class reporteIngresados extends javax.swing.JDialog {
private Usuario user;
    /** Creates new form reporteIngresados */
    public reporteIngresados(java.awt.Frame parent, boolean modal, Usuario u ) {
    super(parent, modal);
    initComponents();
    setLocationRelativeTo(parent);

        Date date = new Date();
        //DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
user=u;
    	String convertido;
        //System.out.println(convertido);

// Obtenemos solamente la fecha pero usamos slash en lugar de guiones
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        convertido = fecha.format(date);
        System.out.println(convertido);
        this.txtDesde.setText(convertido);
        txtHasta.setText(convertido);

       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDesde = new javax.swing.JFormattedTextField();
        txtHasta = new javax.swing.JFormattedTextField();
        lblTip1 = new javax.swing.JLabel();
        lblTip2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(kardexarchivo.KardexArchivoApp.class).getContext().getResourceMap(reporteIngresados.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setName("Form"); // NOI18N
        setResizable(false);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        btnImprimir.setText(resourceMap.getString("btnImprimir.text")); // NOI18N
        btnImprimir.setName("btnImprimir"); // NOI18N
        btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImprimirMouseClicked(evt);
            }
        });

        btnSalir.setText(resourceMap.getString("btnSalir.text")); // NOI18N
        btnSalir.setName("btnSalir"); // NOI18N
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        txtDesde.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtDesde.setToolTipText(resourceMap.getString("txtDesde.toolTipText")); // NOI18N
        txtDesde.setName("txtDesde"); // NOI18N

        txtHasta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtHasta.setToolTipText(resourceMap.getString("txtHasta.toolTipText")); // NOI18N
        txtHasta.setName("txtHasta"); // NOI18N

        lblTip1.setText(resourceMap.getString("text")); // NOI18N
        lblTip1.setName(""); // NOI18N

        lblTip2.setText(resourceMap.getString("lblTip2.text")); // NOI18N
        lblTip2.setName("lblTip2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnImprimir)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtHasta))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTip1)
                            .addComponent(lblTip2))
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTip1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lblTip2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir)
                    .addComponent(btnSalir))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseClicked
         try{
                BaseDatos reporte = new BaseDatos("INVENTARIO");
                reporte.Conectar();

                Map map = new HashMap();
               java.lang.String fecha1 = txtDesde.getText();
               java.lang.String fecha2 = txtHasta.getText();
               //java.lang.String judid=user.jud_id;
               // System.out.println(fecha1);

                map.put("fecha1", fecha1);
                map.put("fecha2", fecha2);
               // map.put("jud_id", judid);

                String path=System.getProperty("user.dir");
                JasperReport masterReport= JasperCompileManager.compileReport(path+"\\report1.jrxml");
                JasperPrint print = JasperFillManager.fillReport(masterReport, map, reporte.conn);
                
                JasperViewer jReportsViewer = new JasperViewer(print,false);
                        
                jReportsViewer.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
                jReportsViewer.setVisible(true);
                //jReportsViewer.setDefaultCloseOperation( javax.swing.JFrame.DISPOSE_ON_CLOSE );
                  //  JasperPrint jasperPrinter = JasperFillManager.fillReport(jasperReport, m, new DataConnection().getConnection());
                 // this.add(jReportsViewer);
         }catch(Exception ex){
            System.out.println(ex);
         }
    }//GEN-LAST:event_btnImprimirMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                reporteIngresados dialog = new reporteIngresados(new javax.swing.JFrame(), true,new Usuario());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblTip1;
    private javax.swing.JLabel lblTip2;
    private javax.swing.JFormattedTextField txtDesde;
    private javax.swing.JFormattedTextField txtHasta;
    // End of variables declaration//GEN-END:variables

}
