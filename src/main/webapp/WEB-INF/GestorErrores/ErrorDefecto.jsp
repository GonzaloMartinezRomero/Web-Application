<%-- 
    Document   : ErrorDefecto
    Created on : 23-mar-2016, 12:14:50
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../Layouts/encabezado.jspf" %>
<!DOCTYPE html>
<html>
    <c:set var="titulo" value="Se ha producido un error"/>
    <%@include file="../Layouts/cabecera.jspf" %>
    <main>
        <section class="bs-callout bs-callout-danger">
            <ul class="list-group">
                <li>
                    <h1 class="alert">Acaba de ocurrir un error inesperado</h1>
                    <h1 >Intenta acceder más tarde</h1>
                </li>
                    
            </ul>
            
        </section>
    
    </main>
</html>
