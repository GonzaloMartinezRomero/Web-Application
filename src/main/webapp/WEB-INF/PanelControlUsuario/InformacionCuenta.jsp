<%-- 
    Document   : InformacionCuenta
    Created on : 26-mar-2016, 19:23:44
    Author     : Drebin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
    <%@include file="../Layouts/encabezado.jspf" %>
    
    <body>
        <main>
           
           <h1>Informacion De Cuenta</h1>
           
               <section class="bs-example">
                    <section class="panel panel-default">
                        <article class="panel-heading">ID</article>
                        <article class="panel-body">${usuario.id}</article>                       
                    </section>
                    
                    <section class="panel panel-default">
                        <article class="panel-heading">Nombre</article>
                        <article class="panel-body">${usuario.nombre}</article>                       
                    </section>
                    <section class="panel panel-default">
                        <article class="panel-heading">Nombre De Usuario</article>
                        <article class="panel-body">${usuario.nombre_usuario}</article>                       
                    </section>
                     <section class="panel panel-default">
                        <article class="panel-heading">Correo Electronico</article>
                        <article class="panel-body">${usuario.correoElectronico}</article>                       
                    </section>
                    <section class="panel panel-default">
                        <article class="panel-heading">Puntos</article>
                        <article class="panel-body">${usuario.puntos}</article>                       
                    </section>
                    <section class="panel panel-default">
                        <article class="panel-heading">Password</article>
                        <article class="panel-body">${usuario.password}</article>                       
                    </section>
                    
                </section>
             
            
        </main>
    </body>
</html>
