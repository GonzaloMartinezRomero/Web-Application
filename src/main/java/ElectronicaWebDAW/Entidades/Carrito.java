/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectronicaWebDAW.Entidades;

/**
 *
 * @author Drebin
 */
public class Carrito {
    
    private int id;
    private int id_articulo;
    private String nombre_usuario;       
    private String fecha;
    
    public Carrito(){
        this.id=-1;
        this.id_articulo=-1;
        this.nombre_usuario="Vacio";      
        this.fecha="Vacio";        
    
    }
    
    public Carrito(int _id,int _id_articulo,String _nombre_usuario,String _fecha){
    
        this.id=_id;
        this.id_articulo=_id_articulo;
        this.nombre_usuario=_nombre_usuario;
        this.fecha=_fecha;        
    
    }
    
    public Carrito(Carrito c){
        
        this.id=c.id;
        this.id_articulo=c.id_articulo;
        this.nombre_usuario=c.nombre_usuario;  
        this.fecha=c.fecha; 
        
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
     * @return the id_articulo
     */
    public int getId_articulo() {
        return id_articulo;
    }

    /**
     * @param id_articulo the id_articulo to set
     */
    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
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

    

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
