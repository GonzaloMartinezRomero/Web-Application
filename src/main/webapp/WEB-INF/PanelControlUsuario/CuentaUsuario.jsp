<%-- 
    Document   : cuentaUsuario
    Created on : 01-mar-2016, 11:59:11
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
    <%@include file="../Layouts/encabezado.jspf" %>
    <c:set var="titulo" value="Panel De Control De Usuario"/>
    <%@include file="../Layouts/cabecera.jspf" %>
    <body>
     
<main class="container-fluid">
      
    <c:if test="${not errorIdentificarUsuario}">
        
        <section class="row content">
            <aside class="col-sm-3 sidenav">
              <h2>Panel de control </h2>

              <ul class="nav nav-pills nav-stacked">
                <li class="active">
                    <a href="#">${nombre}</a>
                </li>
                <li>                   
                    <a href='CuentaUsuario?opcionMenu=1'>Modificar Contraseña</a>

                </li>
                <li>
                    <a href='CuentaUsuario?opcionMenu=2'>Modificar Correo</a>

                </li>
                <li>
                    <a href='CuentaUsuario?opcionMenu=3'>Estado Pedido</a>

                </li>
                <li>
                    <a href='CuentaUsuario?opcionMenu=4'>Desconectar</a>

                </li>
                <li>
                    <a href='CuentaUsuario?opcionMenu=5'>Borrar Cuenta</a>
                </li>
                <li>
                    <a href='CuentaUsuario?opcionMenu=6'>Informacion Cuenta</a>
                </li>

              </ul>

            </aside>

            <section class="col-sm-9">
                <c:choose>
                    <c:when test="${param.opcionMenu==1}">
                        <%@include file="modificacionPassword.jsp" %>
                    </c:when>
                    <c:when test="${param.opcionMenu==2}">
                        <%@include file="modificacionCorreo.jsp" %>
                    </c:when>
                    <c:when test="${param.opcionMenu==3}">
                        <%@include file="EstadoPedido.jsp" %>
                    </c:when>
                    <c:when test="${param.opcionMenu==4}">
                        <%@include file="Desconectar.jsp" %>
                    </c:when>     
                    <c:when test="${param.opcionMenu==5}">
                        <%@include file="BorrarCuenta.jsp" %>
                    </c:when>   
                    <c:when test="${param.opcionMenu==6}">
                        <%@include file="InformacionCuenta.jsp" %>
                    </c:when>   
                    <c:otherwise>
                        <h1>Selecciona una opcion del panel</h1>
                    </c:otherwise>
                </c:choose>

            </section>
        </section>
    </c:if>
    <c:if test="${errorIdentificarUsuario}">
        
        <h1 class="alert-danger">ERROR AL ACCEDER AL PANEL DE CONTROL DEL USUARIO</h1>
        
    </c:if>
</main>

        
    </body>
    
    <%@include file="../Layouts/piePaginaArticulos.jspf" %>
    
</html>
