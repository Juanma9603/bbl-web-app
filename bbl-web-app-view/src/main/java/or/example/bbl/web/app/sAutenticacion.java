package or.example.bbl.web.app;

import dataAccess.UserDao;
import entityData.Persona;
import entityData.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "sAutenticacion", value = "/sAutenticacion")
public class sAutenticacion extends HttpServlet {
    private static Logger logger=Logger.getLogger(sAutenticacion.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String username=request.getParameter("user");
        String password=request.getParameter("password");

        if (username != null && password !=null && username!="" && password!=""){
            Persona objPersona=new Persona();

            objPersona = UserDao.getInstance().autenticar(new User(0,username,password,new Date(), new Date()));
            session.setAttribute("objPersona",objPersona);
            logger.info(objPersona.toString());
            logger.info(objPersona.getObjUser().getPassword().toString());
            if (objPersona.getObjUser().getUsername()!=""){
                response.sendRedirect("GestionLibro/PerfilLogin.jsp");
            }else {
                response.sendRedirect("GestionLibro/Login.jsp");
            }

        }else {
            response.sendRedirect("GestionLibro/Login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("GestionLibro/Login.jsp");
    }
}
