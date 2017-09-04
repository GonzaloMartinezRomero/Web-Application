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
public class Articulo {
    
    private int id;
    private String nombre;
    private float precio;
    private String descripcion;
    private String imagen;
    private String categoria;
    private int numeroUnidades;
    
    
    public Articulo(){
    
        this.id=-1;
        this.nombre=null;
        this.precio=-1;
        this.descripcion=null;
        this.imagen=null;
        this.categoria=null;
        this.numeroUnidades=0;
    }
    public Articulo(int _id,String _nombre,float _precio,String _descripcion,String _imagen,String _categoria,int _numeroUnidades){
        
        this.id=_id;
        this.nombre=_nombre;
        this.precio=_precio;
        this.descripcion=_descripcion;
        this.imagen=_imagen;
        this.categoria=_categoria;
        this.numeroUnidades=_numeroUnidades;
    }
    public Articulo(Articulo a){
        
        this.id=a.id;
        this.nombre=a.nombre;
        this.precio=a.precio;
        this.descripcion=a.descripcion;
        this.imagen=a.imagen;
        this.categoria=a.categoria;
        this.numeroUnidades=a.numeroUnidades;
        
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
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the numeroUnidades
     */
    public int getNumeroUnidades() {
        return numeroUnidades;
    }

    /**
     * @param numeroUnidades the numeroUnidades to set
     */
    public void setNumeroUnidades(int numeroUnidades) {
        this.numeroUnidades = numeroUnidades;
    }

    
}
