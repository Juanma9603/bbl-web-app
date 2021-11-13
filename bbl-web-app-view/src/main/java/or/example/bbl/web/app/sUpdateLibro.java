package or.example.bbl.web.app;

import dataAccess.LibroDao;
import entityData.Libro;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "sUpdateLibro", value = "/sUpdateLibro")
public class sUpdateLibro extends HttpServlet {
    Logger logger =Logger.getLogger(sUpdateLibro.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                Libro objLibro=new Libro();
                objLibro.setID(Integer.parseInt(request.getParameter("ID")));
                objLibro.setNombre(request.getParameter("name"));
                objLibro.setCategoria(request.getParameter("categoria"));
                objLibro.setTomo(Integer.parseInt(request.getParameter("tomo")));
                LibroDao.getInstance().Modificar(objLibro);
                    logger.info("modificando objeto");
                    response.sendRedirect("sGestionarLibros");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();

        try {

            String action="";
            action=request.getParameter("action")+"";
            if (action.equals("detalle")) {
                logger.info("entrando a detalle");

                Libro objLibro = LibroDao.getInstance().Consultar(Integer.parseInt(request.getParameter("idlibro")));
                session.setAttribute("objLibro",
                        objLibro
                        );
                logger.info(objLibro.toString());


            }
        }catch (Exception e){
            logger.error("error con Post sUpdateLibro"+e);
        }



        response.sendRedirect("/bbl-web-app-view/GestionLibro/UpdateLibro.jsp");
        logger.info("redireccionnado a update");
    }
}
