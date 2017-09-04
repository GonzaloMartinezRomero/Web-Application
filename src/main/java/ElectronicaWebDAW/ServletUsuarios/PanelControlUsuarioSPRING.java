/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectronicaWebDAW.ServletUsuarios;

import ElectronicaWebDAW.Entidades.Articulo;
import ElectronicaWebDAW.Entidades.Carrito;
import ElectronicaWebDAW.Entidades.Usuario;
import ElectronicaWebDAW.modeloDAO.ArticuloDAOJDBC;
import ElectronicaWebDAW.modeloDAO.CarritoDAOJDBC;
import ElectronicaWebDAW.modeloDAO.UsuarioDAOJDBC;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/PanelControlUsuario")
@SessionAttributes("usuario")

 
@WebServlet(name = "PanelControlUsuarioSPRING", urlPatterns = {"/PanelControlUsuario"})
public class PanelControlUsuarioSPRING {
    
    @Autowired
    @Qualifier("UsuarioJDBC")
    private UsuarioDAOJDBC usuarioDAO;
    
    @Autowired
    @Qualifier("CarritoJDBC")
    private CarritoDAOJDBC carritoDAO;
    
    @Autowired
    @Qualifier("ArticuloJDBC")
    private ArticuloDAOJDBC articuloDAO;
    
    public PanelControlUsuarioSPRING(){
        
    }
    
    @RequestMapping(value = "/CuentaUsuario",method = RequestMethod.GET)
    public String cargarVistaGeneral(ModelMap model,HttpSession session,HttpServletRequest request){
      
        if(!model.containsAttribute("usuario")){
            System.out.println("Voy a buscar a "+request.getRemoteUser());
            Usuario usuario=usuarioDAO.buscaNombre(request.getRemoteUser());
            model.addAttribute("usuario",usuario);
        }
        
       
        //Cargamos en la lista todas las filas de la tabla carrito asociadas al usuario conectado
        ArrayList<Carrito> lista=carritoDAO.elementosComprados((Usuario)model.get("usuario"));      
         
        
        //De cada fila, guardamos los articulos en otra lista para asociarlos al bean
        ArrayList<Articulo> listaArticulos=new ArrayList<>();


        for(int i=0;i<lista.size();++i){
            listaArticulos.add(articuloDAO.busca(lista.get(i).getId_articulo())); 
        }

        model.addAttribute("articulosComprados",listaArticulos);
        
        model.addAttribute("errorIdentificarUsuario",false);
      
        model.addAttribute("nombre",((Usuario)model.get("usuario")).getNombre());
        
        
               
        return "PanelControlUsuario/CuentaUsuario";
    }
    
   
    @RequestMapping(value = "/CuentaUsuario",method = RequestMethod.POST)
    public String accionUsuario(HttpServletRequest request,ModelMap model,HttpSession session,
                                @ModelAttribute("passwordAntigua") String passwordAntigua,
                                @ModelAttribute("passwordNueva1") String passwordNueva1,
                                @ModelAttribute("passwordNueva2") String passwordNueva2,
                                @ModelAttribute("correoNuevo") String correoNuevo) throws ServletException{
            
        String opcion=request.getQueryString();
        String URL="PanelControlUsuario/CuentaUsuario";
        
        Usuario userAux=(Usuario)model.get("usuario");
        
        
        switch(opcion){
            
            //Modificacion de password
            case "opcionMenu=1":
                
                //Comprobar que la passoword inicial es correcta
                if(userAux.getPassword().equals(passwordAntigua)){
                    
                    model.addAttribute("passwordAntiguaErr",false);
                   
                     //Comprobar que la doble verificacion es correcta
                     if(passwordNueva1.equals(passwordNueva2)){
                         
                         model.addAttribute("password2Err",false);
                         //Actualizarlo en la BD
                         userAux.setPassword(passwordNueva1);
                         if(usuarioDAO.actualizar(userAux)){
                             model.addAttribute("exitoCambioPassword",true);                         
                         }else
                         {
                              model.addAttribute("exitoCambioPassword",false);
                         }
                         
                     }else{
                     
                     model.addAttribute("password2Err",true);
                     }
                    
                }else{
                    model.addAttribute("passwordAntiguaErr",true);
                }
                
                break;
                
            //Cambiar correo electronico
            case "opcionMenu=2":
                
               userAux.setCorreoElectronico(correoNuevo);
                model.addAttribute("correoCambiado",true);
                if(usuarioDAO.actualizar(userAux)){
                    model.addAttribute("exitoCambioCorreo",true);
                }else{
                    model.addAttribute("exitoCambioCorreo",false);
                }                
                
                break;
                
            case "opcionMenu=3":
                break;
                
                
                
            //Desconectar al usuario
            case "opcionMenu=4":
              
                model.remove("usuario");
               // session.removeAttribute("usuario");//No bastaría con solo hacer el model.remove??
                request.getSession().invalidate();
                request.logout();
               
                URL="redirect:/index.jsp";
                
                break;
            
            //Borrar cuenta    
            case "opcionMenu=5":
                   
                if(usuarioDAO.borrarNombre(userAux.getNombre_usuario())){
                    
                    model.remove("usuario");
                    //session.removeAttribute("usuario");
                    request.getSession().invalidate();
                    request.logout();
                    model.addAttribute("errorBorrarUsuario",false);
                    URL="redirect:/index.jsp";
                }else{
                    model.addAttribute("errorBorrarUsuario",true);
                    
                }
                
                               
                break;
                
                
            default:
                break;
            
        }
        return URL;
    }
    
}
