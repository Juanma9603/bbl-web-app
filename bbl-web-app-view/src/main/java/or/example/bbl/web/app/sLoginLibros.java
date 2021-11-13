package or.example.bbl.web.app;



import dataAccess.LibroDao;
import dataAccess.LoginDao;
import entityData.Login;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "sLoginLibros", value= "/sLoginLibros")
public class sLoginLibros extends HttpServlet {
    private static Logger logger=Logger.getLogger(sLoginLibros.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();
        String username = request.getParameter("login");
        String password = request.getParameter("password");
        if (username != null && password != null) {
            Login objlogin = new Login();
            objlogin.setUsername(username);
            objlogin.setPassword(password);
            logger.info(objlogin.toString());
            logger.info("antes de la consulta al DAO");
            objlogin = LoginDao.getInstance().Consultar(objlogin.getUsername(),objlogin.getPassword());
            session.setAttribute("objLogin",objlogin);
            logger.info(objlogin.getiD());
            if (objlogin.getiD()!=0){
                response.sendRedirect("GestionLibro/PerfilLogin.jsp");
            }
        }else{
            response.sendRedirect("../GestionLibro/Login.jsp");
        }
    }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

            try {
                /*<input type="submit" class="fadeIn fourth" value="Log In">*/

                response.sendRedirect("GestionLibro/Login.jsp");
                logger.info("redireccionnado a index");
            } catch (Exception e) {
                logger.error("error al redireccionar a index" + e);
            }

        }

}
