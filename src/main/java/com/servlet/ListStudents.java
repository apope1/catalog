package com.servlet;

import com.repository.RepositoryStudent;
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
@WebServlet(value = "/ListStudents", name = "ListStudents")
public class ListStudents extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RepositoryStudent repositoryStudent = new RepositoryStudent();
        ServiceStudent serviceStudent = new ServiceStudent(repositoryStudent);

        HttpSession session = request.getSession();
        List studenti = serviceStudent.getAll();
        session.setAttribute("listaStudenti", studenti);
        response.sendRedirect("listaStudenti.jsp");
    }
}
