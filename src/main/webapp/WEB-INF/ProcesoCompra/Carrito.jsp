<%-- 
    Document   : Carrito
    Created on : 27-feb-2016, 16:42:57
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="../Layouts/encabezado.jspf" %>
 
    <body>
        <c:set var="titulo" value="Carrito"/>
        <%@include file="../Layouts/cabecera.jspf" %>
        
        <main>
                        
            <section class="panel panel-default">
                <header class="panel-heading">
                    <h1>Lista De Pedidos</h1>                        
                </header>
                <section class="panel-body">
                    <section class="container-fluid">

                        <table class="table">

                            <thead>
                                <tr>
                                  <th>ID</th>  
                                  <th>Nombre</th>
                                  <th>Precio</th>                                                                          

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="i" items="${articulosComprados}">
                                    <tr>
                                        <td>${i.id}</td>  
                                        <td>${i.nombre}</td>
                                        <td>${i.precio}</td>    

                                        <td>                                 
                                            <form:form method="POST">
                                                <button type="submit" name="btnEliminarProducto" value="${i.id}" class="btn-warning">Eliminar</button>  
                                            </form:form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>

                        </table>

                    </section>
            </section>

            </section>

            <section class="panel-default">
                <header class="panel-heading">
                    <h1>Precio Total</h1>

                </header>
                <section class="panel-body">
                    <section class="container-fluid">
                         <table class="table">
                            <thead>
                                <tr>
                                  <th>Total sin IVA</th>
                                  <th>Con Descuentos  </th>
                                  <th></th>
                                  <th class="text-danger">
                                    <h1>Precio Final ( 20% IVA )</h1>
                                  </th>
                                  <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                  <td>${precioSinIVA}€ </td>
                                  <td>${descuentos}€ </td>
                                  <td> </td>
                                  <td class="text-danger">
                                      <h1>${precioTotalIVA}€</h1>
                                  </td>        
                                  <td >      

                                  </td>
                                </tr>
                            </tbody>

                        </table>


                </section>

              </section>  
            </section>
          <section class="panel-default">
                <header class="panel-heading">
                    <h1>Opciones De Compra</h1>
                </header>
                <section class="panel-body">
                    <table class="table">
                         <thead>
                                <tr>
                                  <th> <a href="ConfirmacionCompra"><button class="btn-success">Realizar Compra</button></a>    </th>
                                  <th>   <a href="<c:url value='/index.jsp'/>"><button class="btn-success">Seguir Comprando</button></a></th>

                                </tr>
                            </thead>

                    </table>

                </section>
          </section>
            
        </main>
        
        
     
        
    </body>
</html>