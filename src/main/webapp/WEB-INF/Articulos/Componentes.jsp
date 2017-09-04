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
    <body>
        <c:set var="titulo" value="Componentes"/>
        <%@include file="../Layouts/cabecera.jspf" %>
        
        <%@include file="../Layouts/barraNavegacionArticulos.jspf" %>
        
        <main>            
            <%@include file="../Layouts/categoriasArticulos.jspf" %>
        </main>
            
              
        <%@include file="../Layouts/piePaginaArticulos.jspf" %>
        
      
    </body>
</html>
