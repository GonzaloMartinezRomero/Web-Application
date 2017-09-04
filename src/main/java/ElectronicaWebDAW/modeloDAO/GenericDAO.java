package ElectronicaWebDAW.modeloDAO;

import java.util.ArrayList;

public interface GenericDAO<T,K> {
    
    public T busca(K id);    
    public ArrayList<T> buscaTodos();
    public boolean insertar(T c);
    public boolean actualizar(T c);    
    public boolean borra(K id);
}
