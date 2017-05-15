package com.login;

import com.domain.Profesor;
import com.repository.RepositoryNotare;
import com.repository.RepositoryProfesor;
import com.service.ServiceNotare;
import com.service.ServiceProfesor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andu on 13.05.2017.
 */
@WebServlet(value = "/Notare", name = "Notare")
public class Notare extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RepositoryNotare repositoryNotare = new RepositoryNotare();
        ServiceNotare serviceNotare = new ServiceNotare(repositoryNotare);

        RepositoryProfesor repositoryProfesor = new RepositoryProfesor();
        ServiceProfesor serviceProfesor = new ServiceProfesor(repositoryProfesor);

        HttpSession session = request.getSession();

        Integer numarMatricol = null;
        Integer valoareNota = null;
        String comentariu = null;
        Integer idProfesor = null;

        try {
            numarMatricol = Integer.parseInt(request.getParameter("numarMatricol"));
            valoareNota = Integer.parseInt(request.getParameter("valoareNota"));
            comentariu = request.getParameter("comentariu");
            idProfesor = ((Profesor) session.getAttribute("profesor")).getIdProfesor();

            if(valoareNota > 10)
            {
                throw new Exception("Nota prea mare");
            }

            com.domain.Notare notare = new com.domain.Notare();
            notare.setIdProfesor(idProfesor);
            notare.setValoareNota(valoareNota);
            notare.setNumarMatricol(numarMatricol);
            notare.setComentariu(comentariu);
            serviceNotare.addNotare(notare);
            List listaNote = serviceProfesor.getNoteProfesor(idProfesor);
            session.setAttribute("listaNote", listaNote);

            response.sendRedirect("profesorMain.jsp");

        } catch (Exception ignored) {
            response.sendRedirect("profesorMain.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
