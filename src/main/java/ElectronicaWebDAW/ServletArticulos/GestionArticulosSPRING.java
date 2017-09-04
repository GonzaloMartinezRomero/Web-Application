/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectronicaWebDAW.ServletArticulos;


import ElectronicaWebDAW.Entidades.Carrito;
import ElectronicaWebDAW.Entidades.Usuario;
import ElectronicaWebDAW.modeloDAO.ArticuloDAOJDBC;
import ElectronicaWebDAW.modeloDAO.CarritoDAOJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Articulos")
@SessionAttributes("usuario")

public class GestionArticulosSPRING {
    
    @Autowired
    @Qualifier("ArticuloJDBC")
    private ArticuloDAOJDBC articulosDAO;
    
    @Autowired
    @Qualifier("CarritoJDBC")
    private CarritoDAOJDBC carritoJDBC;
    
    public GestionArticulosSPRING(){}
    
    @RequestMapping(value="/Componentes",method = RequestMethod.GET)
    public String cargarVistasComponentesGET(ModelMap model){
      
        model.addAttribute("articulos",  articulosDAO.buscaCategoria("Componentes"));
        model.addAttribute("usuarioConectado",model.containsAttribute("usuario"));
        return "Articulos/Componentes";
    }
    
    @RequestMapping(value="/Componentes",method = RequestMethod.POST)
    public ModelAndView cargarVistasComponentesPOST(@ModelAttribute("botonBusqueda") String value,
                                              @ModelAttribute("navegadorBusqueda") String nombreArticulo,
                                              @ModelAttribute("botonCompra") String botonCompra,
                                              ModelMap model){
        
        
        if(value.equals("buscarTodos")){        
            model.addAttribute("articulos",articulosDAO.buscaCategoria("Componentes"));            
        }else{
            if(value.equals("ordenarPrecio")){
                model.addAttribute("articulos",articulosDAO.ordenarPrecio("Componentes"));
            }else{
                if(value.equals("ordenarAlfabeticamente")){
                    model.addAttribute("articulos",articulosDAO.ordenarNombre("Componentes"));
                }else{
                    if(!nombreArticulo.isEmpty()){
                         model.addAttribute("articulos",articulosDAO.busquedaNombre("Componentes", nombreArticulo));
                    }
                }
            }
        }        
        if(!botonCompra.isEmpty()){
           
            /*
                Para que el usuario pueda hacer uso del boton, tiene que estar
                forzosamente conectado,por lo que nos saltamos la comprobacion
             */
             Carrito carrito=new Carrito();
             carrito.setId_articulo(Integer.parseInt(botonCompra));
             carrito.setNombre_usuario(((Usuario)model.get("usuario")).getNombre_usuario());              
             carritoJDBC.insertar(carrito);
             return new ModelAndView("redirect:/main/ProcesoCompra/Carrito");
       
        }        
        return new ModelAndView ("Articulos/Componentes");
    }
    
    
    
    @RequestMapping(value="/Ordenadores",method = RequestMethod.GET)
    public String cargarVistasOrdenadoresGET(ModelMap model){
        
        model.addAttribute("articulos",  articulosDAO.buscaCategoria("Ordenadores"));
         model.addAttribute("usuarioConectado",model.containsAttribute("usuario"));
        return "Articulos/Ordenadores";
    }
    
    @RequestMapping(value="/Ordenadores",method = RequestMethod.POST)
    public ModelAndView cargarVistasOrdenadoresPOST(@ModelAttribute("botonBusqueda") String value,
                                              @ModelAttribute("navegadorBusqueda") String nombreArticulo,
                                               @ModelAttribute("botonCompra") String botonCompra,
                                              ModelMap model){
        
        if(value.equals("buscarTodos")){        
            model.addAttribute("articulos",articulosDAO.buscaCategoria("Ordenadores"));            
        }else{
            if(value.equals("ordenarPrecio")){
                model.addAttribute("articulos",articulosDAO.ordenarPrecio("Ordenadores"));
            }else{
                if(value.equals("ordenarAlfabeticamente")){
                    model.addAttribute("articulos",articulosDAO.ordenarNombre("Ordenadores"));
                }else{
                    if(!nombreArticulo.isEmpty()){
                         model.addAttribute("articulos",articulosDAO.busquedaNombre("Ordenadores", nombreArticulo));
                    }
                }
            }
        }
         if(!botonCompra.isEmpty()){
            

            /*
                Para que el usuario pueda hacer uso del boton, tiene que estar
                forzosamente conectado,por lo que nos saltamos la comprobacion
             */
             Carrito carrito=new Carrito();
             carrito.setId_articulo(Integer.parseInt(botonCompra));
             carrito.setNombre_usuario(((Usuario)model.get("usuario")).getNombre_usuario());                        
             carritoJDBC.insertar(carrito);
             return new ModelAndView("redirect:/main/ProcesoCompra/Carrito");
        }
        
        return new ModelAndView ("Articulos/Ordenadores");
    }
    
    
    @RequestMapping(value="/Smartphones",method = RequestMethod.GET)
    public String cargarVistasSmartphonesGET(ModelMap model){
        model.addAttribute("articulos",  articulosDAO.buscaCategoria("Smartphones"));
         model.addAttribute("usuarioConectado",model.containsAttribute("usuario"));
        return "Articulos/Smartphones";
    }
    
    @RequestMapping(value="/Smartphones",method = RequestMethod.POST)
    public ModelAndView cargarVistasSmartphonesPOST(@ModelAttribute("botonBusqueda") String value,
                                              @ModelAttribute("navegadorBusqueda") String nombreArticulo,
                                              @ModelAttribute("botonCompra") String botonCompra,
                                              ModelMap model){
        
        if(value.equals("buscarTodos")){        
            model.addAttribute("articulos",articulosDAO.buscaCategoria("Smartphones"));            
        }else{
            if(value.equals("ordenarPrecio")){
                model.addAttribute("articulos",articulosDAO.ordenarPrecio("Smartphones"));
            }else{
                if(value.equals("ordenarAlfabeticamente")){
                    model.addAttribute("articulos",articulosDAO.ordenarNombre("Smartphones"));
                }else{
                    if(!nombreArticulo.isEmpty()){
                         model.addAttribute("articulos",articulosDAO.busquedaNombre("Smartphones", nombreArticulo));
                    }
                }
            }
        }       
         if(!botonCompra.isEmpty()){
            

            /*
                Para que el usuario pueda hacer uso del boton, tiene que estar
                forzosamente conectado,por lo que nos saltamos la comprobacion
             */
            Carrito carrito=new Carrito();
            carrito.setId_articulo(Integer.parseInt(botonCompra));
            carrito.setNombre_usuario(((Usuario)model.get("usuario")).getNombre_usuario());                        
            carritoJDBC.insertar(carrito);
            return new ModelAndView("redirect:/main/ProcesoCompra/Carrito");
        }
         return new ModelAndView ("Articulos/Smartphones");
       
    }
    
}
