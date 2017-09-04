<%-- 
    Document   : Desconectar
    Created on : 16-mar-2016, 18:51:00
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../Layouts/encabezado.jspf" %>
    <body>
        <main>
            <h1>Desconectar al usuario</h1>
            
            <section>
                <form:form method="POST">
                    <section>
                            <button type="submit" class="btn btn-info btn-lg" data-toggle="modal">Desconectar</button>
                    </section>
                </form:form>
            </section>
        </main>
    </body>
</html>

