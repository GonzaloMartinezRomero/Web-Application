<%-- 
    Document   : Reparaciones
    Created on : 27-feb-2016, 17:42:11
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="WEB-INF/Layouts/encabezado.jspf" %>
    <body>
     
        <c:set var="titulo" value="Reparaciones"/>
        <%@include file="WEB-INF/Layouts/cabecera.jspf" %>
        <h1 class="alert-danger" >PARTE NO IMPLEMENTADA</h1>
        <main class="container">
            <c:if test="${empty param['texto']}">
                <form>
                <section>
               
                    <section class="form-group">
                        <h2>Selecciona el tipo de dispositivo</h2>
                         
                        <select class="form-control" id="sel1">
                          <option>Ordenador</option>
                          <option>Componentes</option>
                          <option>Smartphones</option>
                          <option>Otros</option>
                        </select>
                            
                                               
                    </section>
                   
                         
                        <section>
                                <section>
                                    <h2>Describe el problema</h2>                            
                                </section>               
                                <section class="form-group">

                                    <textarea class="form-control" rows="5" name="texto"></textarea>

                                </section>

                        </section>
                        <section>
                            <button type="submit" class="btn btn-primary">Enviar</button>                        
                        </section>
                   
                </section>
           </form>
            </c:if>
            
            <c:if test="${not empty param['texto']}">
                                
                 <c:if test="${empty param['idUsuario']}">
                     <section class="container">
                         
                        <h1>Para enviar solicitudes, debe logearse</h1>                        
                        <form action="Login.jsp">
                            <button type="submit" class="btn btn-primary"> Logearse </button>
                        </form>
                    </section>
                </c:if>
                <c:if test="${not empty param['idUsuario']}">

                    <h1 class="container">Usuario: ${param.idUsuario}, su peticion ha sido enviada</h1>


                </c:if>
                
            </c:if>
            
           
        </main>
        <%@include file="WEB-INF/Layouts/piePaginaArticulos.jspf" %>
        
    </body>
</html>
