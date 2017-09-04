<%-- 
    Document   : index
    Created on : 27-feb-2016, 13:42:26
    Author     : Drebin
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
    <%@include file="WEB-INF/Layouts/encabezado.jspf" %>   
    <c:set var="titulo" value="Electronica Web"/>
    <%@include file="WEB-INF/Layouts/cabecera.jspf" %>
    
    <body>
                
       
        
        <%@include file="/WEB-INF/Layouts/barraNavegacionPrincipal.jspf" %>
        
        <main class="row">
            
            <section class="col-md-8">
                <c:set var="numElementos" value="3"/>
                <c:set var="direccionIMG" value="images/Ordenador_Imagen.JPG"/>
                <%@include file="WEB-INF/Layouts/novedades.jspf" %>
            </section>
            
            <aside class="col-md-4">               
                <%@include file="WEB-INF/Layouts/datosUsuario.jspf" %>              
            </aside>
            
        </main>
    </body>
    
   <footer class="Pie-Pagina" class="row">
        <header>  
            <h1>Comparte</h1>
        </header>    
      
        <aside class="col-sm-2 sidenav">
            <section class="row content">
                <header><h1>Otros Elementos</h1></header>
                <ul class="nav nav-pills nav-stacked">
                    <li>
                        <h2><a href="FormasPago.jsp">Formas De Pago</a></h2>
                    </li>
                    <li>
                        <h2><a href="#">Preguntas Frecuentes</a></h2>
                    </li>
                    <li>
                        <h2><a href="#">Servicio De Transporte</a></h2>
                    </li>
                     <li>
                         <h2><a href="main/ListaUsuarios/ComunidadUsuarios">Comunidad De Usuarios</a></h2>
                    </li>
                    
                </ul>
                 
            </section>
        </aside>
     
       
       
        <section class="container">

            <article class="col-md-3">
                 <a title="Facebook" href="http://www.facebook.com"><img src="images/facebook.JPG" class="img-thumbnail" alt="Facebook" width="150" height="200"/></a> 
            </article>
             <article class="col-md-3">
                 <a title="FacebookLike" href="http://www.facebook.com"><img src="images/facebookLike.JPG" class="img-thumbnail" alt="FacebookLike" width="200" height="200"/></a> 
            </article>
             <article class="col-md-3">
                 <a title="Twitter" href="http://www.twitter.com"><img src="images/twitter.JPG" class="img-thumbnail" alt="Twitter" width="200" height="200"/></a>                    

            </article>
            <article class="col-md-3">
                <a title="Youtube" href="http://www.youtube.com"><img src="images/youtube.JPG" class="img-thumbnail" alt="Youtube" width="200" height="200"/></a>

            </article>
            
        </section>    
          
    </footer>

    
</html>
