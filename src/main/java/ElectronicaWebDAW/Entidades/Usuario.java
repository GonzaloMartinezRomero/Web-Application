/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectronicaWebDAW.Entidades;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 *
 * @author Drebin
 */

public class Usuario {
    
    private int id;
    @Size (min=3,max=50, message="Longitud debe estar entre 3 y 50")
    private String nombre;
    @Size (min=3,max=50, message="Longitud nombre debe estar entre 3 y 50")
    private String nombre_usuario;
    @Size (min=3,max=50, message="Longitud del correo debe estar entre 3 y 50")
    private String correoElectronico;
    private int puntos;
    @Size (min=4,message="Password debe tener longitud minima de 4")
    //@Pattern(regexp="", message="La password no es valida")
    private String password;
    private boolean conectado;
    
    public Usuario(){
       
        this.id=-1;
        this.nombre=null;
        this.correoElectronico=null;
        this.puntos=0;
        this.password=null; 
        this.conectado=false;
        this.nombre_usuario=null;
    }
    public Usuario(int _id,String _nombre,String _correoElectronico,
                    int _puntos,String _password,boolean _conectado,String _nombre_usuario){
    
        this.id=_id;
        this.nombre=_nombre;
        this.correoElectronico=_correoElectronico;
        this.puntos=_puntos;
        this.password=_password;
        this.conectado=_conectado;
        this.nombre_usuario=_nombre_usuario;
    }
    public Usuario(Usuario u){
        
        this.id=u.id;
        this.nombre=u.nombre;
        this.correoElectronico=u.correoElectronico;
        this.puntos=u.puntos;
        this.password=u.password;
        this.conectado=u.conectado;
        this.nombre_usuario=u.nombre_usuario;
    
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return the puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the conectado
     */
    public boolean isConectado() {
        return conectado;
    }

    /**
     * @param conectado the conectado to set
     */
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    /**
     * @return the nombre_usuario
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    /**
     * @param nombre_usuario the nombre_usuario to set
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    
    
    
    
}
