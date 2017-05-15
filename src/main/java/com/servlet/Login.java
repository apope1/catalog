package com.servlet;

import com.repository.RepositoryProfesor;
import com.repository.RepositoryStudent;
import com.service.ServiceProfesor;
import com.service.ServiceStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andu on 12.05.2017.
 */
@WebServlet(value = "/Login",name = "Login")
public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RepositoryStudent repositoryStudent = new RepositoryStudent();
        ServiceStudent serviceStudent = new ServiceStudent(repositoryStudent);

        RepositoryProfesor repositoryProfesor = new RepositoryProfesor();
        ServiceProfesor serviceProfesor = new ServiceProfesor(repositoryProfesor);

        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

        if (serviceStudent.getStudent(uname, pass) != null) {
            HttpSession session = request.getSession();
            session.setAttribute("student", serviceStudent.getStudent(uname, pass));
            List listaNote = serviceStudent.getNoteStudent(serviceStudent.getStudent(uname,pass).getNumarMatricol());
            session.setAttribute("lista",listaNote);
            response.sendRedirect("studentMain.jsp");
        } else {
            if (serviceProfesor.getProfesor(uname, pass) != null) {
                HttpSession session = request.getSession();
                session.setAttribute("profesor", serviceProfesor.getProfesor(uname, pass));
                List listaNote = serviceProfesor.getNoteProfesor(serviceProfesor.getProfesor(uname,pass).getIdProfesor());
                session.setAttribute("listaNote",listaNote);
                response.sendRedirect("profesorMain.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        }
    }
}
