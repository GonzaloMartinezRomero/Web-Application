<%-- 
    Document   : Registro
    Created on : 03-mar-2016, 17:09:42
    Author     : Drebin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <%@include file="../Layouts/encabezado.jspf" %>
    <c:set var="titulo" value="Registrarse"/>        
    <%@include file="../Layouts/cabecera.jspf" %>
     <body>
             
        <main class="container">
            <section class="panel panel-default">
                
            <c:if test="${not estadoRegistro}">    
            <header class="panel-heading">
           
                <h1 class="text-center">Introducir Datos Cuenta Nueva</h1>                
            </header>

            <section class="panel-body">
                
            <section class="container">             
               
                <form:form method="POST" modelAttribute="usuario" >
                   
                    <section class="form-group">
                      <label for="text">Nombre(Nombre de la persona)</label>
                      <form:input path="nombre" cssClass="form-control input-lg" placeholder="Nombre"/>                 
                      <h2 class="alert-warning"><form:errors path="nombre"/></h2>
                    </section>
                    
                    <section class="form-group">
                      <label for="text">Nombre de usuario(Necesario para el login)</label>
                      <form:input path="Nombre_usuario" cssClass="form-control input-lg" placeholder="Nombre de usuario"/>
                      <h2 class="alert-warning"><form:errors path="nombre_usuario"/></h2>
                    </section>
                     
                    <section class="form-group">
                      <label for="email">Correo electrónico</label>
                      <form:input path="correoElectronico" cssClass="form-control input-lg" placeholder="Correo Electronico"/>
                      <h2 class="alert-warning"><form:errors path="correoElectronico"/></h2>
                    </section>

                    <section class="form-group">
                        <label for="pwd">Password:</label>
                        <form:input path="password" required="" type="password" cssClass="form-control input-lg" placeholder="Password"/>   
                        <h2 class="alert-warning"><form:errors path="password"/></h2>
                    </section>

                    <section>
                        <button type="submit" class="btn btn-default" name="boton">Registrarse</button>                                                          
                    </section>
                    
                </form:form>

                             
                <c:if test="${errorDAO}">
                    <h2 class="alert-warning"> ${mensajeErrorDAO} </h2>                           
                </c:if>

                
              </section>

            </section>
            </c:if>
            <c:if test="${estadoRegistro}">
                
                <section class="panel-body">
                    
                    <h1>La cuenta ha sido creada!!</h1>
                    
                </section>
                              
            </c:if>        
         </section>
        </main>
         
       
    </body>
    <%@include file="../Layouts/piePaginaArticulos.jspf" %>
    
</html>
