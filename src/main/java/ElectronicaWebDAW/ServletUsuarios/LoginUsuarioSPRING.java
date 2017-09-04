/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectronicaWebDAW.ServletUsuarios;

import ElectronicaWebDAW.Entidades.Usuario;
import ElectronicaWebDAW.modeloDAO.UsuarioDAOJDBC;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/LoginUsuario")
@SessionAttributes("usuario")
@WebServlet(name = "LoginUsuarioSPRING", urlPatterns = {"/LoginUsuario"})
public class LoginUsuarioSPRING {
    
    @Autowired
    @Qualifier("UsuarioJDBC")
    private UsuarioDAOJDBC usuarioDAO;
    
    //Este atributo global se tiene que cambiar
    //Se deben establecer atributos de sesion
   // public static Usuario usuarioPublic=null;
   
    
    @RequestMapping(value = "/Login",method = RequestMethod.GET)
    public String cargarVista(ModelMap model,HttpServletRequest request){
       
        if(!model.containsAttribute("usuario")){
            Usuario usuario=usuarioDAO.buscaNombre(request.getRemoteUser());
            model.addAttribute("usuario",usuario);
            
        }
        model.addAttribute("nombreUsuario",((Usuario)model.get("usuario")).getNombre());  
        model.addAttribute("usuarioConectado", true);  
                 
        return "LoginUsuario/Login";        
    }
    
    /*
    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public String validarLogin(@ModelAttribute("nombre_usuario") String nombre_usuario, 
                               @ModelAttribute("password") String password, 
                                ModelMap model){    
        
        Usuario usuarioTemp=usuarioDAO.buscaNombre(nombre_usuario);
        if(usuarioTemp!=null){
            
            if(usuarioTemp.getPassword().equals(password)){
                //Confirmas que el usario es el correcto
                
                model.addAttribute("usuarioConectado",true);               
                model.addAttribute("nombreUsuario",usuarioTemp.getNombre());
                usuarioTemp.setConectado(true);
                
                //-------------------------------               
                //usuarioPublic=usuarioTemp;
                //-------------------------------
                System.out.println("Asociando a usuario el bean");
                model.addAttribute("usuario",usuarioTemp);
                //-------------------------------
                
            }else{
                model.addAttribute("errorPassword",true);
            }
            
        }else{
            model.addAttribute("errorLogin",true);
        }
        
        
        return "LoginUsuario/Login";
    }
    */
    
    //----Metodos utilizados para usar el bean en el index.jsp
//    public Usuario usuario(){
//        return usuarioPublic;
//    }
//    
//    public boolean usuarioConectado(){
//        
//        return usuarioPublic!=null;
//    }
  
}
