<%-- 
    Document   : FormasPago
    Created on : 04-mar-2016, 11:36:01
    Author     : Drebin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="WEB-INF/Layouts/encabezado.jspf" %>
    <c:set var="titulo" value="Formas De Pago"/>
    <%@include file="WEB-INF/Layouts/cabecera.jspf" %>
    <body>
        <main>

        <section class="bs-callout bs-callout-danger">
          <h1>Pago Mediante Transferencia Bancaria</h1>
            <ul class="list-group">
                
                <li>
                  <a class="list-group-item inactive-link">
                  <h3 class="list-group-item-heading">
                    Transferencia expres
                  </h3>
                  <p class="list-group-item-text">
                      Con esta forma de pago recibimos una confirmación
                      instantánea de tu transferencia y podemos enviarte tu pedido antes que con la transferencia convencional.
                  </p>
                  </a>
                </li>
                
                <li>
                  <a class="list-group-item inactive-link">
                  <h3 class="list-group-item-heading">
                    Tarjeta
                  </h3>
                  <p class="list-group-item-text">
                    Podrás hacer el pago escribiendo los datos de tu tarjeta. 
                    Es la forma más rápida.
                  </p>
                  </a>
                </li>
                
                <li>
                  <a class="list-group-item inactive-link">
                  <h3 class="list-group-item-heading">
                    Transferencia Expres
                  </h3>
                  <p class="list-group-item-text">
                   SOFORT Banking es totalmente seguro, fácil de usar, no necesitas registrarse en SOFORT para llevar a cabo un pago. Es compatible con la mayoría de bancos y sólo necesitas tener una cuenta bancaria con banca online y habilitada para realizar transferencias por Internet.
                   El importe máximo que puedes pagar por SOFORT Banking es de 2.000 €.
                  </p>
                  </a>
                </li>
                
                <li>
                  <a class="list-group-item inactive-link">
                  <h3 class="list-group-item-heading">
                    PayPal
                  </h3>
                  <p class="list-group-item-text">
                  Está disponible para pedidos que enviamos a todos los países. Esta forma de pago conlleva unos gastos de gestión del 1% sobre el importe de tu compra con una cuantía mínima de 0,90 €. Consulta los consejos de pago por Paypal.
                  El pago por Paypal requiere algunos minutos en ser procesado y confirmado.   </p>
                  </a>
                </li>
            </ul>
        </section>
    </main>     
         

    </body>
    <%@include file="WEB-INF/Layouts/piePaginaArticulos.jspf" %>
</html>
