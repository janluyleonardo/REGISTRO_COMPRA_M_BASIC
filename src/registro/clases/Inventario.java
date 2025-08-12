package registro.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inventario extends javax.swing.JFrame {

    public static String user;
    public Inventario() {
        initComponents();
        this.setLocationRelativeTo(this);
        jp_principal.setVisible(true);
        jp_factura.setVisible(false);
        txtnombre.setText(user);
//        mostrardatos("");
    }

    void mostrardatos(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        DefaultTableModel modelo1 = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Telefono");
        modelo.addColumn("Cédula");
        tblreg.setModel(modelo);

        modelo1.addColumn("Codigo");
        modelo1.addColumn("Nombre P");
        modelo1.addColumn("Marca");
        modelo1.addColumn("Valor");
        modelo1.addColumn("Cantidad");
        tblreg1.setModel(modelo1);

        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM clientes";
        } else {
            // sql = "SELECT * FROM clientes WHERE  Nombre=+valor";
        }
        String[] datos = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);

        }
        String sql1 = "";
        if (valor.equals("")) {
            sql1 = "SELECT * FROM productos";
        } else {
            sql1 = "SELECT * FROM productos WHERE  Nombre=+valor";
        }
        String[] datos1 = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            while (rs.next()) {

                datos1[0] = rs.getString(1);
                datos1[1] = rs.getString(2);
                datos1[2] = rs.getString(3);
                datos1[3] = rs.getString(4);
                datos1[4] = rs.getString(5);

                modelo1.addRow(datos1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_principal = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btncomprar = new javax.swing.JButton();
        jp_tablas = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblreg = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblreg1 = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        jp_datos_cliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jp_datos_producto = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtnombre1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtmarca = new javax.swing.JTextField();
        txtvalor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxcantidad = new javax.swing.JComboBox<>();
        lbl_titulo_1 = new javax.swing.JLabel();
        btn_salir1 = new javax.swing.JButton();
        btn_minimizar = new javax.swing.JButton();
        lbl_fondo_1 = new javax.swing.JLabel();
        jp_factura = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_comprador = new javax.swing.JLabel();
        lbl_cedula = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_telefono = new javax.swing.JLabel();
        lbl_producto = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblvalor = new javax.swing.JLabel();
        lbl_cantidad = new javax.swing.JLabel();
        lbl_subtotal = new javax.swing.JLabel();
        lbl_descuento = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        btn_volver = new javax.swing.JButton();
        btn_salir2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_principal.setBackground(new java.awt.Color(51, 153, 255));
        jp_principal.setPreferredSize(new java.awt.Dimension(630, 490));
        jp_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnguardar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnguardar.setText("GUARDAR DATOS");
        btnguardar.setPreferredSize(new java.awt.Dimension(131, 36));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jp_principal.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 230, -1));

        btncomprar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btncomprar.setText("GENERAR COMPRA");
        btncomprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncomprarActionPerformed(evt);
            }
        });
        jp_principal.add(btncomprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 620, -1, -1));

        jp_tablas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblreg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblreg);

        jp_tablas.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 230));

        tblreg1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblreg1);

        jp_tablas.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 0, -1, 230));

        jp_principal.add(jp_tablas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 900, 230));

        btneliminar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btneliminar.setText("ELIMINAR DATOS");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jp_principal.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 320, 210, -1));

        btneditar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btneditar.setText("EDITAR DATOS");
        btneditar.setPreferredSize(new java.awt.Dimension(131, 36));
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });
        jp_principal.add(btneditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 180, -1));

        jp_datos_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "DATOS CLIENTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N
        jp_datos_cliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setText("Nombre:");
        jp_datos_cliente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));
        jp_datos_cliente.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 230, 25));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setText("Apellido:");
        jp_datos_cliente.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));
        jp_datos_cliente.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 230, 25));
        jp_datos_cliente.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 230, 25));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setText("Telefono:");
        jp_datos_cliente.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setText("Cedula:");
        jp_datos_cliente.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));
        jp_datos_cliente.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 230, 25));

        jp_principal.add(jp_datos_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 410, 240));

        jp_datos_producto.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "DATOS PRODUCTO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N
        jp_datos_producto.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jp_datos_producto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setText("Nombre:");
        jp_datos_producto.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));
        jp_datos_producto.add(txtnombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 230, 25));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel6.setText("Marca:");
        jp_datos_producto.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));
        jp_datos_producto.add(txtmarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 230, 25));
        jp_datos_producto.add(txtvalor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 230, 25));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel7.setText("Valor:");
        jp_datos_producto.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel8.setText("Cantidad:");
        jp_datos_producto.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        cbxcantidad.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbxcantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "     ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        jp_datos_producto.add(cbxcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 230, -1));

        jp_principal.add(jp_datos_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 440, 240));

        lbl_titulo_1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lbl_titulo_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo_1.setText("Facturación M & M");
        jp_principal.add(lbl_titulo_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 890, -1));

        btn_salir1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btn_salir1.setText("SALIR");
        btn_salir1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_salir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir1ActionPerformed(evt);
            }
        });
        jp_principal.add(btn_salir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 620, 120, -1));

        btn_minimizar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btn_minimizar.setText("MINIMIZAR");
        btn_minimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minimizarActionPerformed(evt);
            }
        });
        jp_principal.add(btn_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, -1, -1));

        lbl_fondo_1.setBackground(new java.awt.Color(0, 102, 255));
        lbl_fondo_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jp_principal.add(lbl_fondo_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 670));

        getContentPane().add(jp_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 670));

        jp_factura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel9.setText("factura generada");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Comprador :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        lbl_comprador.setBackground(new java.awt.Color(204, 204, 204));
        lbl_comprador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_comprador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_comprador, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 230, 20));

        lbl_cedula.setBackground(new java.awt.Color(204, 204, 204));
        lbl_cedula.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_cedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 230, 20));

        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Producto :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jLabel16.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Valor :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Total a pagar:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, -1, -1));

        jLabel18.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Subtotal :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jLabel19.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Descuento :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, -1, -1));

        jLabel20.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Cédula :");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 100, -1));

        jLabel21.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Teléfono :");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        lbl_telefono.setBackground(new java.awt.Color(255, 255, 255));
        lbl_telefono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_telefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 230, 20));

        lbl_producto.setBackground(new java.awt.Color(255, 255, 255));
        lbl_producto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_producto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 270, 20));

        jLabel24.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Cantidad :");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, -1, -1));

        lblvalor.setBackground(new java.awt.Color(255, 255, 255));
        lblvalor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblvalor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblvalor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 130, 20));

        lbl_cantidad.setBackground(new java.awt.Color(255, 255, 255));
        lbl_cantidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_cantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 130, 20));

        lbl_subtotal.setBackground(new java.awt.Color(255, 255, 255));
        lbl_subtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_subtotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 130, 20));

        lbl_descuento.setBackground(new java.awt.Color(255, 255, 255));
        lbl_descuento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_descuento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 130, 20));

        lbl_total.setBackground(new java.awt.Color(255, 255, 255));
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 130, 20));

        jp_factura.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 520, 540));

        btn_volver.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btn_volver.setText("VOLVER");
        btn_volver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });
        jp_factura.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 620, 140, -1));

        btn_salir2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btn_salir2.setText("SALIR");
        btn_salir2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_salir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir2ActionPerformed(evt);
            }
        });
        jp_factura.add(btn_salir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 620, 120, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jp_factura.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 670));

        getContentPane().add(jp_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        int fila = tblreg.getSelectedRow();
        if (fila >= 0) {
            txtnombre.setText(tblreg.getValueAt(fila, 1).toString());
            txtapellido.setText(tblreg.getValueAt(fila, 2).toString());
            txttelefono.setText(tblreg.getValueAt(fila, 3).toString());
            txtcedula.setText(tblreg.getValueAt(fila, 4).toString());
        } else {
            System.out.println("Fila no seleccionada !!!");
            JOptionPane.showMessageDialog(null, "No selecciono fila para eliminar !!!");
        }
        String cod = "";
        cod = tblreg.getValueAt(fila, 0).toString();
        try {
            PreparedStatement pst = cn.prepareStatement("DELETE FROM clientes WEHERE codigo ='" + cod + "'");
            pst.executeUpdate();
            mostrardatos("");
        } catch (Exception e) {

        }
        int fila1 = tblreg1.getSelectedRow();
        if (fila1 >= 0) {
            txtnombre1.setText(tblreg1.getValueAt(fila1, 1).toString());
            txtmarca.setText(tblreg1.getValueAt(fila1, 2).toString());
            txtvalor.setText(tblreg1.getValueAt(fila1, 3).toString());
            cbxcantidad.setSelectedItem(tblreg1.getValueAt(fila1, 4));
        } else {
            System.out.println("Fila no seleccionada !!!");
            JOptionPane.showMessageDialog(null, "No selecciono fila para eliminar !!!");
        }
        String cod1 = "";
        cod1 = tblreg1.getValueAt(fila1, 0).toString();
        try {
            PreparedStatement pst = cn.prepareStatement("DELETE FROM productos WEHERE codigo ='" + cod1 + "'");
            pst.executeUpdate();
            mostrardatos("");
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        int fila = tblreg.getSelectedRow();
        System.out.println("aca es fila-> "+fila);
        if (fila >= 0) {
            txtnombre.setText(tblreg.getValueAt(fila, 1).toString());
            txtapellido.setText(tblreg.getValueAt(fila, 2).toString());
            txttelefono.setText(tblreg.getValueAt(fila, 3).toString());
            txtcedula.setText(tblreg.getValueAt(fila, 4).toString());
        } else {
            System.out.println("Fila no seleccionada !!!");
            JOptionPane.showMessageDialog(null, "No selecciono fila para eliminar !!!");
        }
        String cod = "";
        cod = tblreg.getValueAt(fila, 0).toString();
        System.out.println("cod-> "+cod);
        try {
            PreparedStatement pst = cn.prepareStatement("DELETE FROM clientes WHERE Codigo = ' " + cod + "'");
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Eliminado !!!");
            pst.executeUpdate();
            mostrardatos("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro el registro !!!");
        }
        int fila1 = tblreg1.getSelectedRow();
        if (fila1 >= 0) {
            txtnombre.setText(tblreg1.getValueAt(fila1, 1).toString());
            txtmarca.setText(tblreg1.getValueAt(fila1, 2).toString());
            txtvalor.setText(tblreg1.getValueAt(fila1, 3).toString());
            cbxcantidad.setSelectedItem(tblreg1.getValueAt(fila1, 4));
        } else {
            System.out.println("Fila no seleccionada !!!");
            JOptionPane.showMessageDialog(null, "No selecciono fila para eliminar !!!");
        }
        String cod1 = "";
        cod1 = tblreg1.getValueAt(fila, 0).toString();
        try {
            PreparedStatement pst = cn.prepareStatement("DELETE FROM productos WHERE Codigo = ' " + cod1 + "'");
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Eliminado !!!");
            pst.executeUpdate();
            mostrardatos("");
            txtnombre.setText("");
            txtapellido.setText("");
            txtcedula.setText("");
            txttelefono.setText("");
            txtnombre1.setText("");
            txtmarca.setText("");
            txtvalor.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro el registro !!!");
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO clientes( Codigo,Nombre,Apellido,Telefono,Cedula)values(?,?,?,?,?)");
            int n = 0;
            pst.setInt(1, n);
            pst.setString(2, txtnombre.getText());
            pst.setString(3, txtapellido.getText());
            pst.setString(4, txttelefono.getText());
            pst.setString(5, txtcedula.getText());
            pst.executeUpdate();
            mostrardatos("");

            PreparedStatement pst1 = cn.prepareStatement("INSERT INTO productos( Codigo,Nombre,Marca,Valor,Cantidad)values(?,?,?,?,?)");
            int C = 0;
            pst1.setInt(1, C);
            pst1.setString(2, txtnombre1.getText());
            pst1.setString(3, txtmarca.getText());
            pst1.setString(4, txtvalor.getText());
            pst1.setString(5, cbxcantidad.getSelectedItem().toString());
            pst1.executeUpdate();
            mostrardatos("");

            JOptionPane.showMessageDialog(null,"Registro Almacenado !!!","Exito!",JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR 584!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncomprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncomprarActionPerformed
        if (txtnombre.getText().equals("") || txtapellido.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "No hay datos registrados para generar factura !!!");
        } else {
            jp_principal.setVisible(false);
            jp_factura.setVisible(true);
            lbl_comprador.setText(txtnombre.getText() +" "+ txtapellido.getText());
            lbl_cedula.setText(txtcedula.getText());
            lbl_telefono.setText(txttelefono.getText());
            lbl_producto.setText(txtnombre1.getText());
            lblvalor.setText(txtvalor.getText());
            lbl_cantidad.setText(cbxcantidad.getSelectedItem().toString());
            int valor = Integer.parseInt(txtvalor.getText());
            int cantidad = Integer.parseInt(cbxcantidad.getSelectedItem().toString());
            int subtotal = valor * cantidad;
            lbl_subtotal.setText(Integer.toString(subtotal));
            if (100000 < valor) {
                int descuento = subtotal * 15 / 100;
                lbl_descuento.setText(Integer.toString(descuento));
            } else {
                lbl_descuento.setText("%000000%");
            }if(100000 > valor){
              int total = subtotal;
            lbl_total.setText(Integer.toString(total));
            }else{
                int descuento = subtotal * 15 / 100;
                lbl_total.setText(Integer.toString(descuento));
            }
        }
    }//GEN-LAST:event_btncomprarActionPerformed

    private void btn_salir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir2ActionPerformed
        dispose();
    }//GEN-LAST:event_btn_salir2ActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        jp_factura.setVisible(false);
        jp_principal.setVisible(true);
        txtnombre.setText("");
        txtapellido.setText("");
        txtcedula.setText("");
        txttelefono.setText("");
        txtnombre1.setText("");
        txtmarca.setText("");
        txtvalor.setText("");
        cbxcantidad.setCursor(getCursor());
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_salir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir1ActionPerformed
        dispose();
    }//GEN-LAST:event_btn_salir1ActionPerformed

    private void btn_minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btn_minimizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_minimizar;
    private javax.swing.JButton btn_salir1;
    private javax.swing.JButton btn_salir2;
    private javax.swing.JButton btn_volver;
    private javax.swing.JButton btncomprar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> cbxcantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jp_datos_cliente;
    private javax.swing.JPanel jp_datos_producto;
    private javax.swing.JPanel jp_factura;
    private javax.swing.JPanel jp_principal;
    private javax.swing.JPanel jp_tablas;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_cedula;
    private javax.swing.JLabel lbl_comprador;
    private javax.swing.JLabel lbl_descuento;
    private javax.swing.JLabel lbl_fondo_1;
    private javax.swing.JLabel lbl_producto;
    private javax.swing.JLabel lbl_subtotal;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JLabel lbl_titulo_1;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lblvalor;
    private javax.swing.JTable tblreg;
    private javax.swing.JTable tblreg1;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtmarca;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombre1;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables
conectar cc = new conectar();
    Connection cn = cc.conexion();
}
