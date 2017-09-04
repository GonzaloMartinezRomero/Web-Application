/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectronicaWebDAW.modeloDAO;

import ElectronicaWebDAW.Entidades.Articulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Drebin
 */
@Repository("ArticuloJDBC")
public class ArticuloDAOJDBC implements ArticuloDAO{
    
    private static final String connPoolName="java:comp/env/BaseDatos"; // java:comp/env/(Nombre base de datos)
    private static final String[] autoField={"id"}; 
   
    @Autowired
    private DataSource ds=null;
    
    //------Sentencias SQL-----
    private static final String SQL_BUSCA_ID="SELECT * FROM Articulos where ID=?";
    private static final String SQL_BUSCA_NOMBRE="SELECT * FROM Articulos where CATEGORIA=? and NOMBRE=?";
    private static final String SQL_BUSCA_CATEGORIA="SELECT * FROM Articulos where CATEGORIA=?";
    private static final String SQL_ACTUALIZA="UPDATE Articulos set NOMBRE=?, PRECIO=?, DESCRIPCION=?,IMAGEN=?,CATEGORIA=?,NUMERO_UNIDADES=? where id=?";
    private static final String SQL_BORRA_ID="DELETE FROM Articulos where ID=?";
    private static final String SQL_BUSCATODOS="SELECT * FROM Articulos";
    private static final String SQL_INSERTAR="INSERT INTO Articulos (NOMBRE,PRECIO,DESCRIPCION,IMAGEN,CATEGORIA,NUMERO_UNIDADES) values (?,?,?,?,?,?)";
    private static final String SQL_ORDENAR_PRECIO="SELECT * FROM Articulos where CATEGORIA=? order by PRECIO";
    private static final String SQL_ORDENAR_NOMBRE="SELECT * FROM Articulos where CATEGORIA=? order by NOMBRE";
    
    //Tipos de articulos disponibles
    private final String tiposArticulos[];
    
    public ArticuloDAOJDBC(){
       
//         if (ds==null) {
//            try {
//                Context context = new InitialContext();
//                ds = (DataSource) context.lookup(connPoolName);
//                
//            } catch (NamingException ex) {
//                Logger.getLogger(UsuarioDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
//            }
//        }
        tiposArticulos=new String[3];
        tiposArticulos[0]="Componentes";
        tiposArticulos[1]="Ordenadores";
        tiposArticulos[2]="Smartphones";
         
    }
     private static Articulo clienteMapper(ResultSet rs) throws SQLException {
       
         
        Articulo articulo=new Articulo(   rs.getInt("ID"),
                                    rs.getString("NOMBRE"),
                                    rs.getFloat("PRECIO"),
                                    rs.getString("DESCRIPCION"),
                                    rs.getString("IMAGEN"),
                                    rs.getString("CATEGORIA"),
                                    rs.getInt("NUMERO_UNIDADES"));
       
        return articulo;
    }  
    
    

    @Override
    public Articulo busca(Integer id) {
        
        Articulo articulo=null;
        try (Connection conn=ds.getConnection();
                
            PreparedStatement stmn=conn.prepareStatement(SQL_BUSCA_ID)) {
            stmn.setInt(1,id);
            
            try( ResultSet rs=stmn.executeQuery()) {
                //Como la consulta se genera antes de la primera linea, para obtener la buscada
                //se tiene que avanzar al siguiente
                rs.next();
                articulo=clienteMapper(rs);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
       
        return articulo;   
    }

    @Override
    public ArrayList<Articulo> buscaTodos() {
        
        ArrayList<Articulo> l=new ArrayList<>();
        
        try (Connection conn=ds.getConnection();
            Statement stmn=conn.createStatement();
            ResultSet rs=stmn.executeQuery(SQL_BUSCATODOS);
        ){
            /*Va guardando todas las ocurrencias en la lista*/
            while (rs.next()) {
                l.add(clienteMapper(rs));
            }                
        } catch (Exception ex) {
            Logger.getLogger(ArticuloDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return l;    
    }

   
     public ArrayList<Articulo> buscaCategoria(String categoria){
         
        ArrayList<Articulo> l=new ArrayList<>();
        
        try (Connection conn=ds.getConnection();
                
            PreparedStatement stmn=conn.prepareStatement(SQL_BUSCA_CATEGORIA)) {
            stmn.setString(1,categoria);
          
            try( ResultSet rs=stmn.executeQuery()) {
                while(rs.next()){
                   l.add(clienteMapper(rs));
               }
                          
            }catch(SQLException ex){                
                 Logger.getLogger(ArticuloDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                
            }
        } catch (SQLException ex) {             
            Logger.getLogger(ArticuloDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return l;    
        
    }
    
    @Override
    public boolean insertar(Articulo a) {
   boolean result=false;
        try (Connection conn=ds.getConnection();
            PreparedStatement stmn=conn.prepareStatement(SQL_INSERTAR,autoField);
        ){           
            
            stmn.setString(1,a.getNombre());
            stmn.setFloat(2,a.getPrecio());
            stmn.setString(3,a.getDescripcion());
            stmn.setString(4, a.getImagen());
            stmn.setString(5,a.getCategoria());
            stmn.setInt(6,a.getNumeroUnidades());
           
            result=(stmn.executeUpdate()==1);
           
            try(ResultSet rs=stmn.getGeneratedKeys()){
                if (rs!=null && rs.next()) {
                    int nuevoId=rs.getInt(1); 
                    a.setId(nuevoId);
                }
            }catch(Exception ex){
                Logger.getLogger(ArticuloDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }          
        } catch (Exception ex) {
            Logger.getLogger(ArticuloDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return result;
    }

    @Override
    public boolean actualizar(Articulo a) {
   boolean result=false;
        try (Connection conn=ds.getConnection();
            PreparedStatement stmn=conn.prepareStatement(SQL_ACTUALIZA);
        ){
            stmn.setString(1,a.getNombre());
            stmn.setFloat(2,a.getPrecio());
            stmn.setString(3, a.getDescripcion());
            stmn.setString(4, a.getImagen());
            stmn.setString(5, a.getCategoria());
            stmn.setInt(6,a.getNumeroUnidades());
            stmn.setInt(7, a.getId());
            
            result=(stmn.executeUpdate()==1);
            
        } catch (Exception ex) {
            Logger.getLogger(ArticuloDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        
        return result;
    
    }

    @Override
    public boolean borra(Integer id) {
 
        boolean result=false;
        try (Connection conn=ds.getConnection();
            PreparedStatement stmn=conn.prepareStatement(SQL_BORRA_ID);
        ){
            stmn.setInt(1,id);
            result=(stmn.executeUpdate()==1);
        } catch (Exception ex) {
            Logger.getLogger(ArticuloDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }         
        return result;
    
    }
    
    /*
        Devuelve los articulos de la categoria indicada, ordenados por precio
        Los resultados son de menor a mayor
    */
    public ArrayList<Articulo> ordenarPrecio(String categoria){
        
         ArrayList<Articulo> l=new ArrayList<>();
        
        try (Connection conn=ds.getConnection();
                
            PreparedStatement stmn=conn.prepareStatement(SQL_ORDENAR_PRECIO)) {
            stmn.setString(1,categoria);
          
            try( ResultSet rs=stmn.executeQuery()) {
                while(rs.next()){
                   l.add(clienteMapper(rs));
               }
                          
            }catch(SQLException ex){                
                 Logger.getLogger(ArticuloDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                
            }
        } catch (SQLException ex) {             
            Logger.getLogger(ArticuloDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return l;    
        
        
        
    } 
    
    /*
        Devuelve los articulos de la categoria indicada, ordenados por nombre
        Ordenados alfabeticamente
    */
    public ArrayList<Articulo> ordenarNombre(String categoria){
        
        ArrayList<Articulo> l=new ArrayList<>();
        
        try (Connection conn=ds.getConnection();
                
            PreparedStatement stmn=conn.prepareStatement(SQL_ORDENAR_NOMBRE)) {
            stmn.setString(1,categoria);
          
            try( ResultSet rs=stmn.executeQuery()) {
                while(rs.next()){
                   l.add(clienteMapper(rs));
               }
                          
            }catch(SQLException ex){                
                 Logger.getLogger(ArticuloDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                
            }
        } catch (SQLException ex) {             
            Logger.getLogger(ArticuloDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return l;    
        
        
    }
    
    /*
        Devuelve los articulos de la categoria indicada, que coincidan con el nombre
    */
    public ArrayList<Articulo> busquedaNombre(String categoria,String nombreArticulo){
         
        ArrayList<Articulo> l=new ArrayList<>();
        
        try (Connection conn=ds.getConnection();
                
            PreparedStatement stmn=conn.prepareStatement(SQL_BUSCA_NOMBRE)) {
            stmn.setString(1,categoria);
            stmn.setString(2,nombreArticulo);
          
            try( ResultSet rs=stmn.executeQuery()) {
                while(rs.next()){
                   l.add(clienteMapper(rs));
               }
                          
            }catch(SQLException ex){                
                 Logger.getLogger(ArticuloDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                
            }
        } catch (SQLException ex) {             
            Logger.getLogger(ArticuloDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return l;   
    }
    
    public String[] getTiposArticulos(){
        return this.tiposArticulos;
        
    }
    
}
