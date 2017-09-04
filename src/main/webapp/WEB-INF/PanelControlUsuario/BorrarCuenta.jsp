<%-- 
    Document   : BorrarCuenta
    Created on : 16-mar-2016, 18:51:07
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../Layouts/encabezado.jspf" %>
    <body>
        <main>
           <h1>¿Desea eliminar la cuenta?</h1>
            <section>
                <form:form method="POST">
                    <section>
                            <button type="submit" class="btn btn-info btn-lg" data-toggle="modal">Eliminar Cuenta</button>
                    </section>
                </form:form>
                <section>
                    <h3 class="alert">Su cuenta va a ser eliminada de forma permantente y sus datos no podran ser recuperados</h3>
                </section>
                <c:if test="${errorBorrarUsuario}">
                    <section>
                        <h3 class="alert">Error al intentar borrar al usuario</h3>
                    </section>
                </c:if>
            </section>
        </main>
    </body>
</html>

