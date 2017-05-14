<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Andu
  Date: 12.05.2017
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista studentilor facultatii</title>
    <style>


        @import url(http://fonts.googleapis.com/css?family=Patua+One|Open+Sans);

        * {
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
        }

        body {
            width: 95%;
            height: 80%;
            font-family: 'Open Sans', sans-serif;
            background: #092756;
        }

        table {
            border-collapse: separate;
            background: #fff;
            border-radius: 5px;
            margin: 50px auto;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
        }

        thead {
            border-radius: 5px;
        }

        thead th {
            font-family: 'Patua One', cursive;
            font-size: 16px;
            font-weight: 400;
            color: #fff;
            text-shadow: 1px 1px 0px rgba(0, 0, 0, 0.5);
            text-align: left;
            padding: 20px;
            background-image: linear-gradient(#646f7f, #4a5564);
            border-top: 1px solid #858d99;
        }

        thead th:first-child {
            border-top-left-radius: 5px;
        }

        thead th:last-child {
            border-top-right-radius: 5px;
        }

        tbody tr td {
            font-family: 'Open Sans', sans-serif;
            font-weight: 400;
            color: #5f6062;
            font-size: 13px;
            padding: 20px 20px 20px 20px;
            border-bottom: 1px solid #e0e0e0;

        }

        tbody tr:nth-child(2n) {
            background: #f0f3f5;
        }

        tbody tr:last-child td {
            border-bottom: none;
        }

        tbody tr:last-child td:first-child {
            border-bottom-left-radius: 5px;
        }

        tbody tr:last-child td:last-child {
            border-bottom-right-radius: 5px;
        }

        tbody:hover > tr td {
            opacity: 0.5;

            /* uncomment for blur effect */
            /* color:transparent;
            @include text-shadow(0px 0px 2px rgba(0,0,0,0.8));*/
        }

        tbody:hover > tr:hover td {
            text-shadow: none;
            color: #2d2d2d;
            opacity: 1.0;
        }
    </style>
</head>
<body>
<%
    if (session.getAttribute("listaStudenti") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<table>
    <thead>
    <th>Numar Matricol</th>
    <th>Nume</th>
    <th>Prenume</th>
    </thead>
    <tbody>
    <c:forEach items="${listaStudenti}" var="student">
        <tr>
            <td>${(student.getNumarMatricol())}</td>
            <td>${(student.getNumeStudent())}</td>
            <td>${(student.getPrenumeStudent())}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
