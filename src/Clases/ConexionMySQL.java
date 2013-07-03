
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexionMySQL {
public String db = "gas";
public String url = "jdbc:mysql://localhost/"+db;
public String user = "root";
public String pass = "rock1";

    public ConexionMySQL()
    {
    }
    public Connection Conectar()
    {
        Connection link = null;
        try 
        {
        //Cargamos el Driver MySQL
        Class.forName("org.gjt.mm.mysql.Driver");
        //Creamos un enlace hacia la base de datos
        link = DriverManager.getConnection(this.url, this.user, this.pass);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
           return link;
    }
    
    public int CantidadDeRegistros() throws SQLException
    {
        int RegistroTotal;
        Connection link = DriverManager.getConnection(this.url, this.user, this.pass);
        Conectar();
        Statement stm = link.createStatement();
        ResultSet rs = stm.executeQuery("SELECT count(*) from datos");
        
        RegistroTotal = rs.getInt("count(*)");
        return RegistroTotal;
    }

   
}

