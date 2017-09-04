/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package ElectronicaWebDAW.ServletUsuarios;

import ElectronicaWebDAW.modeloDAO.UsuarioDAOJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/ListaUsuarios")
public class ListasUsuariosSPRING {
    
    @Autowired
    @Qualifier("UsuarioJDBC")
    private UsuarioDAOJDBC usuarioDAO;
    
    public ListasUsuariosSPRING(){}
    
    @RequestMapping(value="/ComunidadUsuarios",method=RequestMethod.GET)
    public String cargarVista(ModelMap model){
       
        model.addAttribute("usuarios",usuarioDAO.buscaTodos());
        
        return "ListaUsuarios/ComunidadUsuarios";
    }
    
    
    
}
