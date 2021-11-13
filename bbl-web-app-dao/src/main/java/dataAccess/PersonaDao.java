package dataAccess;

import Connection.Conexion;
import entityData.Persona;
import entityData.User;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;

public class PersonaDao {
    private static Logger logger=Logger.getLogger(PersonaDao.class);
    private static PersonaDao instance=null;
    private Conexion con=Conexion.getInstance();

    private PersonaDao(){}

    private static PersonaDao getInstance(){
        if (instance==null){
            instance=new PersonaDao();
        }
        return instance;
    }

    public Persona Consultar(int id){
        Persona objpersona=new Persona();
        try {
            String sql="{CALL sp_personaCONSLT}";
            CallableStatement cs =con.Conectar().prepareCall(sql);
            cs.setInt(1,id);
            ResultSet rs=cs.executeQuery();
            if (rs.next()){
                objpersona=new Persona(
                        rs.getInt("idPersona"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("birthday"),
                        rs.getString("email"),
                        rs.getDate("timestampRegister"),
                        rs.getDate("timestampUpdate"),
                        new User()
                );
            }
        }catch (Exception e){
            logger.error("error en sp_personaCONSLT");
        }

        return objpersona;
    }

}
