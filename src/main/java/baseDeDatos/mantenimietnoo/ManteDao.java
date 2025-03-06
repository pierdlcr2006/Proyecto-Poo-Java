package baseDeDatos.mantenimietnoo;

import entidades.Categoria;
import entidades.Producto;
import entidades.Provedor;

import java.util.ArrayList;

public interface ManteDao {
    boolean registrarProducto(Producto producto, Categoria categoria, Provedor provedor);
    ArrayList <Producto> listarProductos();
    int obtenerCodCategoria(String codCategoria);
    int obtenerCodProvedor(String codProvedor);
    boolean convertirADouble(String string);
}
