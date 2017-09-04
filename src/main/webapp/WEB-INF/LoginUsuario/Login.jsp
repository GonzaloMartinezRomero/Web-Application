<%-- 
    Document   : Login
    Created on : 27-feb-2016, 16:09:59
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include  file="../Layouts/encabezado.jspf" %>
    <body>
        <c:set var="titulo" value="Login"/>
        <%@include file="../Layouts/cabecera.jspf" %>
      
            <main class="container">
                <section class="panel panel-default">
            
                <header class="panel-heading">
                    <h1 class="text-center">Introducir Los Datos De La Cuenta</h1>                
                </header>

                <section class="panel-body">

                <section class="container">
                   <c:if test="${not usuarioConectado}">                                            
                       <form action="j_security_check" method="POST">
                            <section class="form-group">
                              <label for="email">Nombre usuario</label>
                              <input type="text" name="j_username" class="form-control input-lg"/>
                            </section>

                            <section class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" name="j_password" class="form-control input-lg"/>                               
                            </section>

                            <section>
                                <button type="submit" value="Enviar" class="btn btn-default">Loguearse</button>                                                          
                            </section>                                
                       </form>
                    </c:if>  
                    
                    <c:if test="${usuarioConectado}">
                           <h1>Bienvenido, ${usuario.nombre}</h1>                           
                    </c:if>    
                                              
                  </section>

                </section>
             </section>
            </main>
         
        <%@include file="../Layouts/piePaginaArticulos.jspf" %>
         
    </body>
    
</html>
