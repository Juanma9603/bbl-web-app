package Connection;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion Instance=null;
    private Logger logger=Logger.getLogger(Conexion.class);

    private Conexion(){ }

    public static Conexion getInstance(){
        if (Instance==null){
            Instance=new Conexion();
        }
        return Instance;
    }

    public Connection Conectar(){
        PropertyConfigurator.configure("/src/log4j.properties");
        Connection c=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://172.17.0.3:3306/biblioteca", "root", "pass");
            logger.info("Conectado");
        }catch (SQLException e){
            logger.error("Error al conectar");
        }catch (Exception er){
            logger.error("Error exception conexion");
        }
        return c;
    }
}
