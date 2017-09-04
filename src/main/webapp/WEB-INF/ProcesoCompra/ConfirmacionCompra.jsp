<%-- 
    Document   : confirmacionCompra
    Created on : 29-feb-2016, 16:32:18
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../Layouts/encabezado.jspf" %>
    <c:set var="titulo" value="Confirmación De Compra"/>
    
    <%@include file="../Layouts/cabecera.jspf" %>
    <body>
    
    <main class="row ">
        <section class="col-md-4 col-md-offset-4">
            <section class="credit-card-div">
                <section class="panel panel-default">
                    <section class="panel-heading">
                        <form name="formularioTarjeta" method="POST">
                            <section class="row ">
                                  <section class="col-md-12">
                                      <input type="text" name="numeroTarjeta" id="numeroTarjeta"  class="form-control" placeholder="Introduce numero de la tarjeta">
                                      <p>  </p>
                                      <input type="submit" class="btn btn-warning btn-block" value="Verificar Cuenta">
                                  </section>
                            </section>
                        </form>
                    <article class="row ">
                        <form name="formularioFecha" method="POST" >
                            <article class="col-md-3 col-sm-3 col-xs-3">
                              <span class="help-block text-muted small-font"> Mes</span>
                              <input type="text" class="form-control" placeholder="MM" id="mes">
                            </article>

                            <article class="col-md-3 col-sm-3 col-xs-3">
                              <span class="help-block text-muted small-font"> Año</span>
                              <input type="text" class="form-control" placeholder="YYYY" id="anio">
                              <p>  </p>
                            </article>
                            <input type="submit" class="btn btn-warning btn-block" value="Verificar Fecha">
                             
                           
                           
                        </form>        
                        <form name="formularioCVV" method="POST">
                            <article class="col-md-3 col-sm-3 col-xs-3">
                                <span class="help-block text-muted small-font">CCV</span>
                                <input type="text" class="form-control" placeholder="CVV" id="cvv" >
                                <p>  </p>
                                <input type="submit" class="btn btn-warning btn-block" value="Verificar CVV">
                            </article>
                        </form>

                    </article>
                    <section class="row ">
                          <section class="col-md-12 pad-adjust">
                            <input type="text" class="form-control" placeholder="Nombre Del Propietario">
                          </section>
                    </section>
                    <section class="col-md-12 pad-adjust">
                        <article class="checkbox">
                            <label>
                                <input type="checkbox" checked="" class="text-muted"><p> Guardar datos para futuras compras</p>
                            </label>
                        </article>
                    </section>
                   <section class="row ">
                        <section class="col-md-6 col-sm-6 col-xs-6 pad-adjust">
                            
                              <input type="submit" class="btn btn-danger" value="CANCELAR">
                            
                        </section>
                        <section class="col-md-6 col-sm-6 col-xs-6 pad-adjust">
                           
                              <input type="submit" class="btn btn-warning btn-block" value="REALIZAR PAGO">
                             
                        </section>
                    </section>

                    </section>
                   
                </section>
            </section>
        </section>
    </main>
   
    <script src='//code.jquery.com/jquery-1.12.3.min.js'></script>
    <script src="<c:url value='/js/CompraArticulo.js'/>" ></script>
    
    </body>
    <c:set var="direccionURL" value="Carrito"/>
    <%@include file="../Layouts/piePaginaArticulos.jspf" %>

</html>
