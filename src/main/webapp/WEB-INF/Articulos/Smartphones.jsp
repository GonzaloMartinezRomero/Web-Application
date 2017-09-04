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
    
        <c:set var="titulo" value="Smartphones"/>
        <%@include file="../Layouts/cabecera.jspf" %>
        
        <%@include file="../Layouts/barraNavegacionArticulos.jspf" %>
        
        
        <main>
            <c:set var="nombreArticulo" value="Samsung"/>
            <c:set var="direccionImagen" value="images/Movil.JPG "/>
            <c:set var="descripcionArticulo" value="Smartphone de 4GB de RAM.... etc"/>
            <c:set var="numComentarios" value="2"/>   
            <c:set var="numArticulos" value="2"/>   
            <c:set var="precioArticulo" value="112.2€"/> 
            <c:set var="estadoArticulo" value="Stock"/> 
            <%@include file="../Layouts/categoriasArticulos.jspf" %>
            
            
        </main>
            
          <c:set var="numPaginas" value="1"/>       
        <%@include file="../Layouts/piePaginaArticulos.jspf" %>
        
      
    </body>
</html>
