/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GuardarKardex.java
 *
 * Created on 05-ago-2013, 12:01:31
 */

package kardexarchivo;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.ResultSet;
/**
 *
 * @author edwin.cevallost
 */
public class ActualizarGuardarKardex extends javax.swing.JDialog {
    private String _idjuicio;
    public Usuario user;
    public Registro actregistro ;
    /** Creates new form GuardarKardex */
    public ActualizarGuardarKardex(java.awt.Frame parent, boolean modal, String idjuicio, Usuario u, int _kar_id) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        user=u;
        //this.setMaximumSize(new Dimension(1024,800));
        this._idjuicio=idjuicio;
        actregistro = new Registro();
        actregistro.CargarRegistrosActualizar(_kar_id);
        this.txtEntrega.setText(actregistro.kar_resp_entrega);
        this.txtRecibe.setText(actregistro.kar_resp_recibe);
        this.txtProposito.setText(actregistro.kar_proposito);
        this.txtFecha.setText(actregistro.kar_fecha);
        this.txtHora.setText(actregistro.kar_hora);
        DefaultComboBoxModel cmbTipos = new DefaultComboBoxModel(CargarTipo());
        this.cmbTipo.setModel(cmbTipos);
        DefaultComboBoxModel cmbUbicaciones = new DefaultComboBoxModel(CargarUbicacion());
        this.cmbUbicacion.setModel(cmbUbicaciones);
        Tipo tip = new Tipo(actregistro.tip_id,null,actregistro.tipo);
        cmbTipo.setEditable(true);
        cmbTipo.setSelectedItem(tip);
        cmbTipo.setEditable(false);
        Ubicacion ubi = new Ubicacion(actregistro.ubi_id,actregistro.ubicacion);
        cmbUbicacion.setEditable(true);
        cmbUbicacion.setSelectedItem(ubi);
        cmbUbicacion.setEditable(false);
    }
   public static Vector<Tipo> CargarTipo(){
        Vector<Tipo> tipos = new Vector<Tipo>();
        Tipo tp= null;
        ResultSet rs = null;
        BaseDatos bdd= new BaseDatos("INVENTARIO");
        bdd.Conectar();
        bdd.CrearStoreProcedure("exec proc_select_tipos");
        rs=bdd.EjecutarComando();
        try{
            while(rs.next()){
                tp= new Tipo(rs.getInt("tip_id"),rs.getString("tip_sigla"),rs.getString("tip_detalle"));
                tipos.add(tp);
            }
            rs.close();
        }catch(SQLException ex){
          System.out.println(ex);
        }
        return tipos;

    }

    public static Vector<Ubicacion> CargarUbicacion(){
        Vector<Ubicacion> ubicaciones = new Vector<Ubicacion>();
        Ubicacion ub= null;
        ResultSet rs = null;
        BaseDatos bdd= new BaseDatos("INVENTARIO");
        bdd.Conectar();
        bdd.CrearStoreProcedure("exec proc_select_ubicaciones");
        rs=bdd.EjecutarComando();
        try{
            while(rs.next()){
                ub= new Ubicacion(rs.getInt("ubi_id"),rs.getString("ubi_descripcion"));
                ubicaciones.add(ub);
            }
            rs.close();
        }catch(SQLException ex){
          System.out.println(ex);
        }
        return ubicaciones;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        txtEntrega = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtRecibe = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cmbUbicacion = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtProposito = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jCancelar = new javax.swing.JButton();
        txtFecha = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHora = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N
        setResizable(false);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(kardexarchivo.KardexArchivoApp.class).getContext().getResourceMap(ActualizarGuardarKardex.class);
        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        txtEntrega.setName("txtEntrega"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        txtRecibe.setName("txtRecibe"); // NOI18N

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipo.setName("cmbTipo"); // NOI18N

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        cmbUbicacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbUbicacion.setName("cmbUbicacion"); // NOI18N

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        txtProposito.setName("txtProposito"); // NOI18N

        btnGuardar.setText(resourceMap.getString("btnGuardar.text")); // NOI18N
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        jCancelar.setText(resourceMap.getString("jCancelar.text")); // NOI18N
        jCancelar.setName("jCancelar"); // NOI18N
        jCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCancelarMouseClicked(evt);
            }
        });

        txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/MM/yyyy"))));
        txtFecha.setText(resourceMap.getString("txtFecha.text")); // NOI18N
        txtFecha.setName("txtFecha"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.MEDIUM))));
        txtHora.setName("txtHora"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProposito, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(93, 93, 93)
                        .addComponent(jCancelar)
                        .addGap(164, 164, 164))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtRecibe, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtRecibe, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(cmbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProposito, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(jCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        Tipo tp;
        tp=(Tipo)this.cmbTipo.getSelectedItem();
        Ubicacion ubi;
        ubi=(Ubicacion)this.cmbUbicacion.getSelectedItem();
        Registro registro = new Registro(actregistro.kar_id,_idjuicio,txtEntrega.getText(),txtRecibe.getText(),tp.getTip_id(),ubi.getUbi_id(),txtProposito.getText(),user.usu_id,txtFecha.getText(),txtHora.getText());
        registro.ActualizarRegistro();
        dispose();
      
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void jCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelarMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jCancelarMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ActualizarGuardarKardex dialog = new ActualizarGuardarKardex(new javax.swing.JFrame(), true,"", new Usuario(),0);
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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JComboBox cmbUbicacion;
    private javax.swing.JButton jCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtEntrega;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtProposito;
    private javax.swing.JTextField txtRecibe;
    // End of variables declaration//GEN-END:variables

}
