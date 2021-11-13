package or.example.bbl.web.app;

import dataAccess.PersonaDao;
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

@WebServlet(name = "sCrearCuenta", value = "/sCreateAccount")
public class sCreateAccount extends HttpServlet {
    private static Logger logger=Logger.getLogger(sCreateAccount.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String username=request.getParameter("user");
        String password=request.getParameter("password");
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String birthday=request.getParameter("birthday");
        String email=request.getParameter("email");
        if (username != null && password !=null && username!="" && password!="") {
            Persona objPersona = new Persona();

            objPersona = UserDao.getInstance().Registrar(new Persona(0, firstname, lastname, birthday, email, new Date(), new Date(), new User(0, username, password, new Date(), new Date())));
            session.setAttribute("objPersona", objPersona);
            logger.info("no mames lo logramos, revisa bien ");
            logger.info(objPersona);
            response.sendRedirect("GestionLibro/Login.jsp");
        }else{
            response.sendRedirect("GestionLibro/NewAccount.jsp");
        }

        logger.info("nose que paso,no recolectamos nada wey y aun asi cambiamos de pagina");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("GestionLibro/NewAccount.jsp");
        logger.info("vamonos al new account jsp");

    }
}
