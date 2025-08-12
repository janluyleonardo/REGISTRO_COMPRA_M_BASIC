package registro.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    PreparedStatement ps;
    ResultSet rs;
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(this);
        jp_principal.setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_principal = new javax.swing.JPanel();
        jp_datos_sesion = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txpPwd = new javax.swing.JPasswordField();
        btnInicioSesion = new javax.swing.JButton();
        btn_salir1 = new javax.swing.JButton();
        lbl_fondo_1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jp_principal.setBackground(new java.awt.Color(51, 153, 255));
        jp_principal.setPreferredSize(new java.awt.Dimension(630, 490));
        jp_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_datos_sesion.setBackground(new java.awt.Color(51, 153, 255));
        jp_datos_sesion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos de sesión", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N
        jp_datos_sesion.setForeground(new java.awt.Color(0, 0, 0));
        jp_datos_sesion.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jp_datos_sesion.setMaximumSize(new java.awt.Dimension(380, 221));
        jp_datos_sesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setText("Usuario:");
        jp_datos_sesion.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));
        jp_datos_sesion.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 75, 370, 40));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel6.setText("Contraseña");
        jp_datos_sesion.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        txpPwd.setMinimumSize(new java.awt.Dimension(15, 24));
        txpPwd.setPreferredSize(new java.awt.Dimension(15, 24));
        jp_datos_sesion.add(txpPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 370, 40));

        jp_principal.add(jp_datos_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 440, 240));
        jp_datos_sesion.getAccessibleContext().setAccessibleName("Ingrese datos");

        btnInicioSesion.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnInicioSesion.setText("Ingresar");
        btnInicioSesion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioSesionActionPerformed(evt);
            }
        });
        jp_principal.add(btnInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 210, -1));

        btn_salir1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btn_salir1.setText("Salir");
        btn_salir1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_salir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir1ActionPerformed(evt);
            }
        });
        jp_principal.add(btn_salir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, 120, -1));

        lbl_fondo_1.setBackground(new java.awt.Color(0, 102, 255));
        lbl_fondo_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jp_principal.add(lbl_fondo_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_principal, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_principal, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioSesionActionPerformed
        String user ="",pwd="",sqlUser="",userLogged=""; 
        user = txtUser.getText();
        pwd = txpPwd.getText();
        sqlUser = "SELECT * FROM usuarios WHERE email = ? AND password = ? AND status = 1";
        
        if (user.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar el usuario, el campo es obligatorio", "Señor usuario", JOptionPane.ERROR_MESSAGE);
            txtUser.requestFocus();
        } else if (pwd.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar la contrsaeña, el campo es obligatorio", "Señor usuario", JOptionPane.ERROR_MESSAGE);
            txpPwd.requestFocus();
        }else{
            try {
                ps = cn.prepareStatement(sqlUser);
                ps.setString(1, user);
                ps.setString(2, pwd);

                rs = ps.executeQuery();
                if (rs.next()) {
                    userLogged = rs.getString("email");
                    Inventario.user = userLogged;
                    Inventario Inv = new Inventario();
                    Inv.setVisible(true);
                    this.setVisible(false);
                    System.out.println("\nentro en true");
                }else{
                    System.out.println("no encontre alumno con ese correo en la tabla de estudiantes");
                    JOptionPane.showMessageDialog(rootPane, "No te encuentras registrado dentro del sistema como alumno habilitado,\n comunicate con tu profesor para que te registre", "Señor estudiante", JOptionPane.ERROR_MESSAGE);
    //                System.exit(0);
    //                jPEstudiante.setVisible(false);
    //                jPDocente.setVisible(false);
    //                jPLogin.setVisible(true);
                }
            } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Error: "+e.getMessage(), "Señor estudiante", JOptionPane.ERROR_MESSAGE);                
            }            
        }
    }//GEN-LAST:event_btnInicioSesionActionPerformed

    private void btn_salir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir1ActionPerformed
        dispose();
    }//GEN-LAST:event_btn_salir1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicioSesion;
    private javax.swing.JButton btn_salir1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jp_datos_sesion;
    private javax.swing.JPanel jp_principal;
    private javax.swing.JLabel lbl_fondo_1;
    private javax.swing.JPasswordField txpPwd;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
conectar cc = new conectar();
    Connection cn = cc.conexion();
}
