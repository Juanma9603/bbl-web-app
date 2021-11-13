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
import java.util.ArrayList;

@WebServlet(name = "sGestionarLibros", value="/sGestionarLibros")
public class sGestionarLibros extends HttpServlet {
    private static Logger logger=Logger.getLogger(sGestionarLibros.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session= request.getSession();
        try {


            String action="";
                    action=request.getParameter("action")+"";/*
            if (action.equals("consultar")) {
                logger.info("entrando a consultar");
                    session.setAttribute("objLibro",
                            LibroDao.Consultar(Integer.parseInt(request.getParameter("idlibro"))));
                    logger.info(response.toString());
                    response.sendRedirect("l.jsp");
                    logger.info("");

            }*/

            if (action.equals("listar")){

            }
            if (action.equals("eliminar")){
                logger.info("opcion de elmininar");
                int idlibro= Integer.parseInt(request.getParameter("idlibro"));
                LibroDao.getInstance().Eliminar(idlibro);
                logger.info("libro eliminado"+idlibro);
                response.sendRedirect("GestionLibro/ListLibros.jsp");

                }
            logger.info("listando libros");
            ArrayList<Libro> Libros=new ArrayList<>();
            Libros=LibroDao.getInstance().list();
            session.setAttribute("listLibros",Libros);


            response.sendRedirect("GestionLibro/ListLibros.jsp");



        }catch (Exception e){
            logger.error("error case"+e);

        }


    }
}
