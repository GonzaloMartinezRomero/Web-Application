<%-- 
    Document   : modificacionPassword
    Created on : 01-mar-2016, 20:37:04
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../Layouts/encabezado.jspf" %>
    <body>
        <main>
            <header>
                <h1>Modificacion de password</h1>
                
            </header>
                
            <section>
                <form:form method="POST">
                    
                    <section class="form-group">
                        
                     <label>Password Actual:</label>
                     <input required="" type="password" name="passwordAntigua" class="form-control">
                     <c:if test="${passwordAntiguaErr}">                         
                         <h3 class="danger"> Contraseña no valida</h3>
                     </c:if>
                    
                    </section>

                    <section class="form-group">
                     <label>Password Nueva:</label>
                     <input required="" type="password" name="passwordNueva1" class="form-control">
                    </section>

                    <section class="form-group">
                     <label>Volver a introducir Password Nueva:</label>
                     <input required="" type="password" class="form-control" name="passwordNueva2">
                      <c:if test="${password2Err}">
                           <h3 class="danger"> La contraseña nueva no coincide</h3>                         
                     </c:if>
                    </section>

                    <section>
                        <button type="submit" class="btn btn-info btn-lg">Aplicar</button>
                    </section>
                    
                    <c:if test="${exitoCambioPassword}">     
                        <section>                                
                            <h2 class="success">Contraseña cambiada con exito</h2>
                        </section>
                    </c:if>
                
                </form:form> 
            </section>
        </main>
    </body>
</html>
