package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Andu on 12.05.2017.
 */
@WebServlet(value = "/Logout", name = "Logout")
public class Logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("student")!=null) {
            session.removeAttribute("student");
            session.removeAttribute("lista");
        }
        if(session.getAttribute("student")!=null)
        {
            session.removeAttribute("profesor");
            session.removeAttribute("listaStudenti");
            session.removeAttribute("listaNote");
        }


        session.invalidate();
        response.sendRedirect("index.jsp");
    }
}
