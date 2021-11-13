package or.example.bbl.web.app;

import dataAccess.LibroDao;
import entityData.Libro;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sAddLibro", value = "/sAddLibro")
public class sAddLibro extends HttpServlet {
    Logger logger=Logger.getLogger(sAddLibro.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Libro objlibro = new Libro();
            objlibro.setNombre(request.getParameter("name"));
            objlibro.setCategoria(request.getParameter("categoria"));
            objlibro.setTomo(Integer.parseInt(request.getParameter("tomo")));
            logger.info("objeto registrando" + objlibro.getID());

            LibroDao.getInstance().Aniadir(objlibro);
                response.sendRedirect("sGestionarLibros");

        } catch (Exception e) {
            logger.error("error post sAddLibro" + e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("/bbl-web-app-view/GestionLibro/AddLibro.jsp");
        logger.info("redireccionando addLibro");
    }
}
