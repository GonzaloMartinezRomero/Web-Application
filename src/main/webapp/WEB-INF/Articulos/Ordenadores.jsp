<%-- 
    Document   : Ordenadores
    Created on : 27-feb-2016, 17:44:53
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@include file="../Layouts/encabezado.jspf" %>
    <c:set var="titulo" value="Ordenadores"/>
    <%@include file="../Layouts/cabecera.jspf" %>
    <body>        
        <nav>
             <%@include file="../Layouts/barraNavegacionArticulos.jspf" %>        
        </nav>
       
        <main>        
            <%@include file="../Layouts/categoriasArticulos.jspf" %>            
        </main>
            
        <c:set var="numPaginas" value="1"/>       
        <%@include file="../Layouts/piePaginaArticulos.jspf" %>
      
    </body>
</html>
