<%-- 
    Document   : modificacionPassword
    Created on : 01-mar-2016, 20:37:04
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../Layouts/encabezado.jspf" %>
    <body>
        <main>
            <header>
                <h1>Modificacion de correo</h1>
                
            </header>
                
            <section>
                <form:form method="POST">

             
                
                    <section class="form-group">
                        <label for="pwd">Correo Nuevo:</label>  
                        <input type="email" class="form-control" name="correoNuevo">
                    </section>

                    <c:if test="${correoCambiado}">
                        <c:if test="${exitoCambioCorreo}">
                        <section>
                            <h1>Correo cambiado satisfactoriamente</h1>
                        </section>
                        </c:if>
                        <c:if test="${not exitoCambioCorreo}">
                         <section>
                            <h1 class="alert">Error al cambiar de correo</h1>
                        </section>
                        </c:if>
                    </c:if>
                     

                    <section>
                            <button type="submit" class="btn btn-info btn-lg">Aplicar</button>
                    </section>
                 
               </form:form> 
        </section>
        </main>
    </body>
</html>
