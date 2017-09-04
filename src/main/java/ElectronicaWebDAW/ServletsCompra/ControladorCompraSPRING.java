/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectronicaWebDAW.ServletsCompra;

import ElectronicaWebDAW.Entidades.Articulo;
import ElectronicaWebDAW.Entidades.Carrito;
import ElectronicaWebDAW.Entidades.Usuario;
import ElectronicaWebDAW.ServletUsuarios.LoginUsuarioSPRING;
import ElectronicaWebDAW.modeloDAO.ArticuloDAOJDBC;
import ElectronicaWebDAW.modeloDAO.CarritoDAOJDBC;
import ElectronicaWebDAW.modeloDAO.UsuarioDAOJDBC;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/ProcesoCompra")
@SessionAttributes("usuario")
@WebServlet(name = "ControladorCompraSPRING", urlPatterns = {"/Carrito"})
public class ControladorCompraSPRING {
    
    @Autowired
    @Qualifier("CarritoJDBC")
    private CarritoDAOJDBC carritoDAO;
    
    @Autowired
    @Qualifier("ArticuloJDBC")
    private ArticuloDAOJDBC articuloDAO;
    
    @Autowired
    @Qualifier("UsuarioJDBC")
    private UsuarioDAOJDBC usuarioDAO;
    
    
     @RequestMapping(value = "/ConfirmacionCompra",method = RequestMethod.GET)
     public String cargarVistaConfCompra(){
         return "ProcesoCompra/ConfirmacionCompra";
     }
    
    
    @RequestMapping(value = "/Carrito",method = RequestMethod.GET)
    public String cargarVistaCarrito(ModelMap model,HttpServletRequest request){
        
         if(!model.containsAttribute("usuario")){
            Usuario usuario=usuarioDAO.buscaNombre(request.getRemoteUser());
            model.addAttribute("usuario",usuario);            
        }
            
        //Cargamos en la lista todas las filas de la tabla carrito asociadas al usuario conectado
        ArrayList<Carrito> lista=carritoDAO.elementosComprados((Usuario)model.get("usuario"));      

        //De cada fila, guardamos los articulos en otra lista para asociarlos al bean
        ArrayList<Articulo> listaArticulos=new ArrayList<>();

        float precioTotal=0.0f;
        float IVA=1.20f; 
        float descuentos=0.0f;

        for(int i=0;i<lista.size();++i){

            listaArticulos.add(articuloDAO.busca(lista.get(i).getId_articulo()));
            precioTotal+=listaArticulos.get(i).getPrecio();
        }

        model.addAttribute("usuarioConectado",true);
        model.addAttribute("articulosComprados",listaArticulos);
        model.addAttribute("precioSinIVA",precioTotal);
        model.addAttribute("descuentos",precioTotal-descuentos);
        model.addAttribute("precioTotalIVA",precioTotal*IVA);
        
        
        
        return "ProcesoCompra/Carrito";
    }
    
    @RequestMapping(value = "/Carrito",method = RequestMethod.POST)
    public String vistaCarritoPOST(@ModelAttribute ("btnEliminarProducto") String idBoton,ModelMap model){
        
        if(model.containsAttribute("usuario")){

            //Eliminamos el producto de la cesta asociada al usuario
            carritoDAO.borraProducto(Integer.parseInt(idBoton),(Usuario)model.get("usuario"));

            //Despues volvemos a cargarla

            //Cargamos en la lista todas las filas de la tabla carrito asociadas al usuario conectado
            ArrayList<Carrito> lista=carritoDAO.elementosComprados((Usuario)model.get("usuario"));      

            //De cada fila, guardamos los articulos en otra lista para asociarlos al bean
            ArrayList<Articulo> listaArticulos=new ArrayList<>();

            float precioTotal=0.0f;
            float IVA=1.20f; 
            float descuentos=0.0f;

            for(int i=0;i<lista.size();++i){

                listaArticulos.add(articuloDAO.busca(lista.get(i).getId_articulo()));
                precioTotal+=listaArticulos.get(i).getPrecio();
            }

            model.addAttribute("usuarioConectado",true);
            model.addAttribute("articulosComprados",listaArticulos);
            model.addAttribute("precioSinIVA",precioTotal);
            model.addAttribute("descuentos",precioTotal-descuentos);
            model.addAttribute("precioTotalIVA",precioTotal*IVA);


        }else{
              model.addAttribute("usuarioConectado",false);
        }
          
        return "ProcesoCompra/Carrito";
    }
    
    
    
}
