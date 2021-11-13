package dataAccess;

import Connection.Conexion;
import entityData.Login;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.ResultSet;

public class LoginDao {
    private Conexion con = Conexion.getInstance();
    private static LoginDao Instance=null;
    private static Logger logger=Logger.getLogger(LoginDao.class);

    private LoginDao(){

    }

    public static LoginDao getInstance() {
        if (Instance==null){
            Instance=new LoginDao();
        }
        return Instance;
    }

    public Login Consultar(String username, String password){
        Login objlogin=new Login();
        try {
            String sql="{CALL sp_loginCONSLT(?,?)}";

            CallableStatement cs=con.Conectar().prepareCall(sql);
            cs.setString(1,username);
            cs.setString(2, password);
            ResultSet rs=cs.executeQuery();
            if (rs.next()){
                objlogin=new Login(
                        rs.getInt("id_login"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                logger.info("obteniendo login");
            }

            logger.info(objlogin.toString());
        }catch (Exception e){
            logger.error("error en call sp_loginCONSLT"+e);
        }
        return objlogin;
    }
}
