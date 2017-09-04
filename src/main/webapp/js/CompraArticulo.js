/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global CompraArticulo */

$( function (){
    CompraArticulo.init();    
});

var expRegTarjeta=/^\d{16}$/; //Numero de 16 cifras sin otros caracteres
var expRegCVV=/^\d{3}$/;

var CompraArticulo={
    
    config:{
        formularioTarjeta:"[name=formularioTarjeta]",
        formularioFecha:"[name=formularioFecha]",
        formularioCVV:"[name=formularioCVV]"
    },
    init: function(){
        var self=this;
       
                
        $(this.config.formularioTarjeta).on('submit',function(event){
            if(self.comprobarNumTarjeta()===null){
                alert("NUMERO DE TARJETA NO VALIDO");                
            }else{
                 alert("TARJETA VALIDA");
            }
             event.preventDefault(); 
        });
        
        $(this.config.formularioFecha).on('submit',function(event){
            if(self.comprobarFecha()){
                alert("FECHA CORRECTA");
            }else{
                alert("FECHA NO ES CORRECTA");
            }
             event.preventDefault();
        });
         $(this.config.formularioCVV).on('submit',function(event){
              
            if(self.comprobarCVV()===null){
                alert("CVV NO ES CORRECTO");
            }else{
                alert("CVV CORRECTO");
            }
             event.preventDefault();
        });
        
       
    },
    comprobarNumTarjeta: function(){
        
        var numTarjeta=document.getElementById('numeroTarjeta');
        var estado=(numTarjeta.value).match(expRegTarjeta);       
        return estado;        
    },
    comprobarFecha:function(){
        var mes=document.getElementById('mes');
        var anio=document.getElementById('anio');
        var anioActual=new Date().getFullYear(); 
        
        if((mes.value)<=12 && (mes.value)>=1){
            if((anio.value)>=anioActual){
                return true;
            }
        }
        return false;    
        
    },
    comprobarCVV:function(){
        var cvv=document.getElementById('cvv');
        var estado=(cvv.value).match(expRegCVV);   
        return estado;
    }
    
    
    
}