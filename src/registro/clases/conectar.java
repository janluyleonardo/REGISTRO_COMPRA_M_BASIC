package registro.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectar {

    Connection conectar = null;
    String db_user = "MORJAN";
//    String db_pwd = "";
    String db_pwd = "Moreno.880501";
    String db_name = "registro";
    String db_host = "localhost";
    String db_port = "3306";

    String db_conection ="jdbc:mysql://"+db_host+":"+db_port+"/"+db_name;
    
    public Connection conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(db_conection,db_user,db_pwd);
            System.out.print("conectado");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.print(e.toString());
            JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return conectar;
    }

}
