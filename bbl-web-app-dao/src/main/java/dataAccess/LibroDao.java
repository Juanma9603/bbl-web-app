package dataAccess;

import entityData.Libro;
import Connection.Conexion;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;
import java.util.ArrayList;

public class LibroDao {
    private Conexion con= Conexion.getInstance();
    private static LibroDao Instance=null;
    private static Logger logger=Logger.getLogger(LibroDao.class);

    private LibroDao(){

    }

    public static LibroDao getInstance(){
        if (Instance==null){
            Instance=new LibroDao();
        }
        return Instance;
    }


    public void Aniadir(Libro objLibro){
        try {
            String sql="{CALL sp_libroINSERT(?,?,?)}";
            CallableStatement cs=con.Conectar().prepareCall(sql);
            cs.setString(1,objLibro.getNombre());
            cs.setString(2,objLibro.getCategoria());
            cs.setInt(3,objLibro.getTomo());
            cs.execute();
        }catch (SQLException e){
            logger.error("error sp_libro Insert"+e);
        }
    }

    public void Modificar(Libro objLibro){
        try {
            String sql="{CALL sp_libroUPDATE(?,?,?,?)}";
            CallableStatement cs = con.Conectar().prepareCall(sql);
            cs.setInt(1,objLibro.getID());
            cs.setString(2,objLibro.getNombre());
            cs.setString(3,objLibro.getCategoria());
            cs.setInt(4,objLibro.getTomo());
            cs.execute();
        }catch (Exception e){
            logger.error("error call sp_libroUpdate"+e);
        }
    }

    public  ArrayList<Libro> list(){
        ArrayList<Libro> listalibros=new ArrayList<>();
        PropertyConfigurator.configure("/src/log4j.properties");

        try {
            CallableStatement stm=con.Conectar().prepareCall("{CALL sp_libroLIST()}");
            ResultSet rs=stm.executeQuery();
            while (rs.next()){
                Libro objlibro =new Libro(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5)
                );
                listalibros.add(objlibro);
                logger.info("correcto call sp_libroLIST");
            }
        }catch (SQLException err){
            logger.error("incorrecto sp_libroLIST"+ err);
        }catch (Exception e){
            logger.error("incorrecto call sp_libroLIST"+e);
        }
        return listalibros;
    }

    public  Libro Consultar(int ID){
        Libro objLibro=new Libro();

        try {
            String sql="{CALL sp_libroCONSLT(?)}";
            CallableStatement cs=con.Conectar().prepareCall(sql);
            cs.setInt(1,ID);
            ResultSet rs=cs.executeQuery();
            logger.info("realizando query");
            if (rs.next()){
                objLibro=new Libro(
                        rs.getInt("Id_libro"),
                        rs.getString("Nombre"),
                        rs.getString("Categoria"),
                        rs.getInt("Tomo"),
                        rs.getDate("Registro")
                );
                logger.info("correcto call sp_libroCONSLT");
            }
        }catch (Exception e){
            logger.error("incorrecto call sp_libroCONSLT"+e);
        }
        return objLibro;
    }

    public void Eliminar(int ID){
        try {
            String sql ="{CALL sp_libroDELETE(?)}";
            CallableStatement cs=con.Conectar().prepareCall(sql);
            cs.setInt(1,ID);
            cs.execute();
            logger.info("realizando query");

        }catch (Exception e){
            logger.error("incorrecto call sp_libroDELETE");
        }
    }
}
