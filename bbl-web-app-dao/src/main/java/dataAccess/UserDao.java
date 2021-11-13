package dataAccess;

import Connection.Conexion;
import entityData.Persona;
import entityData.User;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;


import java.sql.ResultSet;
import java.util.Date;


public class UserDao {
    private static Logger logger=Logger.getLogger(UserDao.class);
    private static UserDao instance=null;
    private Conexion con= Conexion.getInstance();

    private UserDao(){}

    public static UserDao getInstance(){
        if (instance==null){
            instance=new UserDao();
        }
        return instance;
    }

    public Persona autenticar(User user){
        Persona objPersona=new Persona();
        try {
            String sql="{CALL sp_autenticacion(?,?)}";
            CallableStatement cs=con.Conectar().prepareCall(sql);
            cs.setString(1,user.getUsername());
            cs.setString(2,user.getPassword());
            ResultSet rs=cs.executeQuery();
            if (rs.next()){
                objPersona=new Persona(
                        rs.getInt("idPersona"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        "",
                        rs.getString("email"),
                        new Date(),
                        new Date(),
                        new User(
                                rs.getInt("idUser"),
                                rs.getString("username"),
                                "",
                                new Date(),
                                new Date()
                        )
                );

            }

        }catch (Exception e){
            logger.error("error sp_autenticacion"+e);
        }

        return objPersona;
    }

    public Persona Registrar(Persona objPersona){
        try {
            String sql="{CALL sp_registrarusuarioNEW(?,?,?,?,?,?)}";
            CallableStatement cs=con.Conectar().prepareCall(sql);
            cs.setString(1,objPersona.getObjUser().getUsername());
            cs.setString(2,objPersona.getObjUser().getPassword());
            cs.setString(3,objPersona.getFirstname());
            cs.setString(4,objPersona.getLastname());
            cs.setString(5,objPersona.getBirthday());
            cs.setString(6,objPersona.getEmail());
            cs.execute();
        }catch (Exception e){
            logger.info("registrando una nueva cuenta");
        }

        return objPersona;
    }

}
