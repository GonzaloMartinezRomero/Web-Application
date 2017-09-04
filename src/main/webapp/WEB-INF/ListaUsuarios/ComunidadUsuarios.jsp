<%-- 
    Document   : ComunidadUsuarios
    Created on : 16-mar-2016, 12:04:51
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="../Layouts/encabezado.jspf" %>
 
    <body>
        <c:set var="titulo" value="Comunidad De Usuarios"/>
        <%@include file="../Layouts/cabecera.jspf" %>
        
        <main>
         
            <section class="panel panel-default">
                <header class="panel-heading">
                    <h1>Usuarios Registrados Actualmente</h1>                        
                </header>
                <section class="panel-body">
                    <section class="container-fluid">

                        <table class="table">

                            <thead>
                                <tr>
                                  <th>Numero Socio</th>  
                                  <th>Nombre</th>
                                  <th>Nombre De Usuario</th>
                                  <th>Email</th>
                                  <th>Puntos</th>
                                 
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="i" items="${usuarios}">
                                    <tr>
                                        <td>${i.id}</td>                                         
                                        <td>${i.nombre}</td>
                                        <td>${i.nombre_usuario}</td>
                                        <td>${i.correoElectronico}</td>
                                        <td>${i.puntos}</td>                                      
                                    </tr>
                                </c:forEach>
                            </tbody>

                        </table>

                    </section>
            </section>

            </section>

        </main>
        
        <%@include file="../Layouts/piePaginaArticulos.jspf" %>
        
    </body>
</html>