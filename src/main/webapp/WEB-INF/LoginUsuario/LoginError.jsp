<%-- 
    Document   : ErrorPage
    Created on : 29-abr-2016, 14:10:26
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include  file="../Layouts/encabezado.jspf" %>
    <body>
        <c:set var="titulo" value="Error En Login"/>
        <%@include file="../Layouts/cabecera.jspf" %>
      
            <main class="container">
                <section class="panel panel-default">
            
                <header class="panel-heading">
                    <h1 class="text-center">Se ha producido un error al autentificar al usuario</h1>                
                </header>

                </section>
             </section>
            </main>
         
        <%@include file="../Layouts/piePaginaArticulos.jspf" %>
         
    </body>
    
</html>
