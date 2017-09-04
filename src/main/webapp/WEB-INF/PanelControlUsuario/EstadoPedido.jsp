<%-- 
    Document   : EstadoPedido
    Created on : 03-mar-2016, 17:41:36
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <main class="panel panel-default">
        <header class="panel-heading">
            <h1>
                Estado actual de los elementos de la cesta    
            </h1>
        
        </header>
            <section class="panel panel-default">
                    
                    <section class="panel-body">
                        <section class="container-fluid">

                             <table class="table">
                               
                                <thead>
                                    <tr>
                                      <th>ID</th>  
                                      <th>Nombre</th>
                                      <th>Precio</th>                                                                           
                                      <th>                       </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="i" items="${articulosComprados}">
                                        <tr>
                                            <td>${i.id}</td>  
                                            <td>${i.nombre}</td>
                                            <td>${i.precio}</td>                                                                                 
                                            
                                        </tr>
                                    </c:forEach>
                                </tbody>

                            </table>

                        </section>
                </section>

                </section>
      </main>
    </body>
</html>
