<%--
  Created by IntelliJ IDEA.
  User: Andu
  Date: 12.05.2017
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${profesor.getNumeProfesor()}&nbsp;${profesor.getPrenumeProfesor()}</title>
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

        #out {
            float: right;
        }

        #lst {
            float: left;
        }

        input[type=submit] {
            padding:5px 15px;
            background:#ccc;
            border:0 none;
            cursor:pointer;
            -webkit-border-radius: 5px;
            border-radius: 5px;
        }

    </style>
</head>
<body>

<%
    if (session.getAttribute("profesor") == null) {
        response.sendRedirect("servlet.jsp");
    }
%>

<div class="main">

    <form id="lst" action="ListStudents" target="_blank">
        <input type="submit" value="Lista studenti">
    </form>

    <form id="out" action="Logout">
        <input type="submit" value="Logout">
    </form>


    <form action="Notare" method="POST">
        <table>
            <thead>
            <th colspan="2">Adaugati nota student</th>
            </thead>
            <tbody>
            <tr>
                <td>Numar matricol</td>
                <td><input type="text" name="numarMatricol"/></td>
            </tr>
            <tr>
                <td>Nota</td>
                <td><input type="text" name="valoareNota"/></td>
            </tr>
            <tr>
                <td>Comentariu</td>
                <td><input type="text" name="comentariu"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Adauga nota"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form>

    <table>
        <thead>
        <th>Nume</th>
        <th>Prenume</th>
        <th>Nota</th>
        <th>Materie</th>
        </thead>
        <tbody>
        <c:forEach items="${listaNote}" var="prof">
            <tr>
                <td>${(prof.split("[|]"))[0]}</td>
                <td>${(prof.split("[|]"))[1]}</td>
                <td>${(prof.split("[|]"))[2]}</td>
                <td>${(prof.split("[|]"))[3]}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>



</div>
</body>
</html>
