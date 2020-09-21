/*
 * KardexArchivoView.java
 */

package kardexarchivo;

//import com.mysql.jdbc.ResultSet;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import kardexarchivo.EntregaRecibe;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * The application's main frame.
 */
public class KardexArchivoView extends FrameView {
    private Usuario user;
    public KardexArchivoView(SingleFrameApplication app) {
        super(app);
        JFrame mainFrame = KardexArchivoApp.getApplication().getMainFrame();
        Login frmLogin = new Login(mainFrame,true);
        frmLogin.setLocationRelativeTo(mainFrame);
        KardexArchivoApp.getApplication().show(frmLogin);

        initComponents();
        
        user = frmLogin.getUser();
        this.statusMessageLabel.setText(user.toString());
        ActivarMenus();
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });     
     
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = KardexArchivoApp.getApplication().getMainFrame();
            aboutBox = new KardexArchivoAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        KardexArchivoApp.getApplication().show(aboutBox);
    }

    @Action
    public void showKardex() {
     if (Juicios == null) {
            JFrame mainFrame = KardexArchivoApp.getApplication().getMainFrame();
            Juicios = new Kardex(mainFrame,true,user);
     
            Juicios.setLocationRelativeTo(mainFrame);
        }
        KardexArchivoApp.getApplication().show(Juicios);
    }

     @Action
    public void RegistrarMovimiento() {
     if (Movimientos == null) {
            JFrame mainFrame = KardexArchivoApp.getApplication().getMainFrame();
            Movimientos = new EntregaRecibe(mainFrame,true,user);
     
            Movimientos.setLocationRelativeTo(mainFrame);
        }
        KardexArchivoApp.getApplication().show(Movimientos);
    }
     
     
     @Action
    public void showActualizarKardex() {
     if (ActualizarJuicios == null) {
            JFrame mainFrame = KardexArchivoApp.getApplication().getMainFrame();
            ActualizarJuicios = new ActualizarInformacion(mainFrame,true,user);
            ActualizarJuicios.setLocationRelativeTo(mainFrame);
        }
        KardexArchivoApp.getApplication().show(ActualizarJuicios);
    }

     public java.sql.Date DeStringADate(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = fecha;
        Date fechaDate = null;
        java.sql.Date frm_dte=null;
        try {
            fechaDate = formato.parse(strFecha);
                        System.out.println(fechaDate.toString());
             frm_dte = new java.sql.Date(fechaDate.getTime());
            return frm_dte;
        } catch (Exception ex) {
            ex.printStackTrace();
            return frm_dte;
        }
    }
 
     @Action
    public void showSolicitud() {
     if (Solicitudes == null) {
            JFrame mainFrame = KardexArchivoApp.getApplication().getMainFrame();
            Solicitudes = new frmSolicitud(mainFrame,true,user);
            Solicitudes.setLocationRelativeTo(mainFrame);
        }
        KardexArchivoApp.getApplication().show(Solicitudes);
    }
     
     @Action
 public void Reporte() {
     if (RepIngresados == null) {
            JFrame mainFrame = KardexArchivoApp.getApplication().getMainFrame();
            RepIngresados = new reporteIngresados(mainFrame,true,user);
            RepIngresados.setLocationRelativeTo(mainFrame);
        }

        KardexArchivoApp.getApplication().show(RepIngresados);
       }

     @Action
 public void ReporteEtiquetas() {
     if (reporteEtiquetas == null) {
            JFrame mainFrame = KardexArchivoApp.getApplication().getMainFrame();
            reporteEtiquetas = new reporteEtiquetas(mainFrame,true);
            reporteEtiquetas.setLocationRelativeTo(mainFrame);
        }

        KardexArchivoApp.getApplication().show(reporteEtiquetas);
       }
     public void ActivarMenus() {
           
        int rol=user.rol_id;
         switch (rol){
             case 1:
                this.MenuReportes.setEnabled(true);
                this.MenuMaestros.setEnabled(true);
                    this.SubmenuJuiciosIngresados.setEnabled(true);
                    this.MenuKardex.setEnabled(true);
                    this.SubmenuIngresos.setEnabled(true);
                    this.SubmenuRegistros.setEnabled(true);
                    this.SubmenuActualizaciones.setEnabled(true);
                    
                break;

             case 2:
                  this.MenuKardex.setEnabled(true);
                  this.SubmenuIngresos.setEnabled(true);
                
                 break;
             case 3:
                  this.MenuKardex.setEnabled(true);
                  this.SubmenuIngresos.setEnabled(true);
                  this.SubmenuRegistros.setEnabled(true);
                 break;
             case 4:
                 this.SubmenuActualizaciones.setEnabled(false);
                 break;
             default:
              
                 this.MenuKardex.setEnabled(false);
         }


       }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu MenuArchivo = new javax.swing.JMenu();
        javax.swing.JMenuItem SubmenuSalir = new javax.swing.JMenuItem();
        MenuMaestros = new javax.swing.JMenu();
        SubmenuUbicaciones = new javax.swing.JMenuItem();
        MenuKardex = new javax.swing.JMenu();
        SubmenuIngresos = new javax.swing.JMenuItem();
        SubmenuRegistros = new javax.swing.JMenuItem();
        SubmenuActualizaciones = new javax.swing.JMenuItem();
        mProtocolo = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        MenuReportes = new javax.swing.JMenu();
        SubmenuJuiciosIngresados = new javax.swing.JMenuItem();
        SubmenuKardex = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jFrame1 = new javax.swing.JFrame();

        mainPanel.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        mainPanel.setName("mainPanel"); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(kardexarchivo.KardexArchivoApp.class).getContext().getResourceMap(KardexArchivoView.class);
        jLabel1.setIcon(resourceMap.getIcon("label1.icon")); // NOI18N
        jLabel1.setText(resourceMap.getString("label1.text")); // NOI18N
        jLabel1.setName("label1"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        MenuArchivo.setText(resourceMap.getString("MenuArchivo.text")); // NOI18N
        MenuArchivo.setName("MenuArchivo"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(kardexarchivo.KardexArchivoApp.class).getContext().getActionMap(KardexArchivoView.class, this);
        SubmenuSalir.setAction(actionMap.get("quit")); // NOI18N
        SubmenuSalir.setText(resourceMap.getString("SubmenuSalir.text")); // NOI18N
        SubmenuSalir.setName("SubmenuSalir"); // NOI18N
        MenuArchivo.add(SubmenuSalir);

        menuBar.add(MenuArchivo);

        MenuMaestros.setText(resourceMap.getString("MenuMaestros.text")); // NOI18N
        MenuMaestros.setName("MenuMaestros"); // NOI18N

        SubmenuUbicaciones.setText(resourceMap.getString("SubmenuUbicaciones.text")); // NOI18N
        SubmenuUbicaciones.setName("SubmenuUbicaciones"); // NOI18N
        MenuMaestros.add(SubmenuUbicaciones);

        menuBar.add(MenuMaestros);

        MenuKardex.setText(resourceMap.getString("MenuKardex.text")); // NOI18N
        MenuKardex.setName("MenuKardex"); // NOI18N

        SubmenuIngresos.setAction(actionMap.get("showKardex")); // NOI18N
        SubmenuIngresos.setText(resourceMap.getString("SubmenuIngresos.text")); // NOI18N
        SubmenuIngresos.setEnabled(false);
        SubmenuIngresos.setName("SubmenuIngresos"); // NOI18N
        SubmenuIngresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubmenuIngresosMouseClicked(evt);
            }
        });
        MenuKardex.add(SubmenuIngresos);

        SubmenuRegistros.setAction(actionMap.get("RegistrarMovimiento")); // NOI18N
        SubmenuRegistros.setText(resourceMap.getString("SubmenuRegistros.text")); // NOI18N
        SubmenuRegistros.setActionCommand(resourceMap.getString("SubmenuRegistros.actionCommand")); // NOI18N
        SubmenuRegistros.setEnabled(false);
        SubmenuRegistros.setName("SubmenuRegistros"); // NOI18N
        MenuKardex.add(SubmenuRegistros);

        SubmenuActualizaciones.setAction(actionMap.get("showActualizarKardex")); // NOI18N
        SubmenuActualizaciones.setText(resourceMap.getString("SubmenuActualizaciones.text")); // NOI18N
        SubmenuActualizaciones.setEnabled(false);
        SubmenuActualizaciones.setName("SubmenuActualizaciones"); // NOI18N
        MenuKardex.add(SubmenuActualizaciones);

        menuBar.add(MenuKardex);

        mProtocolo.setText(resourceMap.getString("mProtocolo.text")); // NOI18N
        mProtocolo.setName("mProtocolo"); // NOI18N

        jMenuItem4.setAction(actionMap.get("showSolicitud")); // NOI18N
        jMenuItem4.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        mProtocolo.add(jMenuItem4);

        jMenuItem5.setText(resourceMap.getString("jMenuItem5.text")); // NOI18N
        jMenuItem5.setName("jMenuItem5"); // NOI18N
        mProtocolo.add(jMenuItem5);

        menuBar.add(mProtocolo);

        MenuReportes.setAction(actionMap.get("Reporte")); // NOI18N
        MenuReportes.setText(resourceMap.getString("MenuReportes.text")); // NOI18N
        MenuReportes.setName("MenuReportes"); // NOI18N

        SubmenuJuiciosIngresados.setAction(actionMap.get("Reporte")); // NOI18N
        SubmenuJuiciosIngresados.setText(resourceMap.getString("SubmenuJuiciosIngresados.text")); // NOI18N
        SubmenuJuiciosIngresados.setName("SubmenuJuiciosIngresados"); // NOI18N
        MenuReportes.add(SubmenuJuiciosIngresados);

        SubmenuKardex.setText(resourceMap.getString("SubmenuKardex.text")); // NOI18N
        SubmenuKardex.setName("SubmenuKardex"); // NOI18N
        MenuReportes.add(SubmenuKardex);

        jMenuItem1.setAction(actionMap.get("ReporteEtiquetas")); // NOI18N
        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        MenuReportes.add(jMenuItem1);

        menuBar.add(MenuReportes);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setText(resourceMap.getString("statusMessageLabel.text")); // NOI18N
        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setText(resourceMap.getString("statusAnimationLabel.text")); // NOI18N
        statusAnimationLabel.setToolTipText(resourceMap.getString("statusAnimationLabel.toolTipText")); // NOI18N
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 660, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jFrame1.setName("jFrame1"); // NOI18N

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void SubmenuIngresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmenuIngresosMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SubmenuIngresosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuKardex;
    private javax.swing.JMenu MenuMaestros;
    private javax.swing.JMenu MenuReportes;
    private javax.swing.JMenuItem SubmenuActualizaciones;
    private javax.swing.JMenuItem SubmenuIngresos;
    private javax.swing.JMenuItem SubmenuJuiciosIngresados;
    private javax.swing.JMenuItem SubmenuKardex;
    private javax.swing.JMenuItem SubmenuRegistros;
    private javax.swing.JMenuItem SubmenuUbicaciones;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenu mProtocolo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
    private JDialog Juicios;
    private JDialog ActualizarJuicios;
    private JDialog RepIngresados;
    private JDialog reporteEtiquetas;
     private JDialog Solicitudes;
     private JDialog Movimientos;
    //private JDialog Login;
     

}
