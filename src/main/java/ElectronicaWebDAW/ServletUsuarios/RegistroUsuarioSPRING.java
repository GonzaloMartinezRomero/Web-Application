/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectronicaWebDAW.ServletUsuarios;

import ElectronicaWebDAW.Entidades.Usuario;
import ElectronicaWebDAW.modeloDAO.UsuarioDAOJDBC;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/RegistroUsuario")


public class RegistroUsuarioSPRING {
    
    @Autowired
    @Qualifier("UsuarioJDBC")
    private UsuarioDAOJDBC usuarioDAO;
    
    public RegistroUsuarioSPRING(){}   
    
    
    @RequestMapping(value="/Registrarse",method = RequestMethod.GET)
    public String cargarVista(ModelMap model){
        model.addAttribute("usuario",new Usuario());
        model.addAttribute("errorDAO",false);      
        model.addAttribute("estadoRegistro",false);
        return "RegistroUsuario/Registrarse";    
    }
    
   
    @RequestMapping(value="/Registrarse",method = RequestMethod.POST)
    public String registrarUsuario(@ModelAttribute("usuario") @Valid Usuario usuario, BindingResult result,ModelMap model){
       
        if(!result.hasErrors()){
            if(usuarioDAO.insertar(usuario)){
                model.addAttribute("estadoRegistro",true);               
            }else{
                model.addAttribute("errorDAO",true);
                String mensajeError="Error al insertar en la BD";
                model.addAttribute("mensajeErrorDAO",mensajeError);
            }                
        }  
        
        return "/RegistroUsuario/Registrarse";
        
    }
    
    
}
