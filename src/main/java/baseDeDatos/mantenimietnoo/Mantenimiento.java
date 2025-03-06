package baseDeDatos.mantenimietnoo;

import baseDeDatos.conexion.Conexion;
import entidades.Categoria;
import entidades.Producto;
import entidades.Provedor;
import java.sql.*;
import java.util.*;


public class Mantenimiento implements ManteDao{
    public boolean registrarProducto(Producto producto, Categoria categoria, Provedor provedor){
        PreparedStatement ps;
        Connection conexion = Conexion.obtenerConexion();
        var statement = "INSERT INTO mydb.PRODUCTO (nombre,cantidad,und_medida,precio,cod_categoria,cod_provedor)VALUES(?,?,?,?,?,?)";
        try {
            ps = conexion.prepareStatement(statement);
            ps.setString(1,producto.getNombre());
            ps.setDouble(2,producto.getCantidad());
            ps.setString(3,producto.getUnidad());
            ps.setDouble(4,producto.getPrecio());
            ps.setInt(5,categoria.getCodCategoria());
            ps.setInt(6,provedor.getCodProvedor());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("ERROR AL AGREGAR DATOS"+e);
        }finally {
            try {
                conexion.close();
            }catch (Exception e){
                System.out.println("ERROR AL CERRAR CONEXIÓN "+e);
            }
        }
        return false;
    }
    public boolean registrarProvedor(Provedor provedor){
        PreparedStatement ps;
        Connection conexion = Conexion.obtenerConexion();
        var statement = "INSERT INTO mydb.provedor(cod_provedor,nom_provedor,ruc)VALUES(?,?,?)";
        try {
            ps = conexion.prepareStatement(statement);
            ps.setInt(1,provedor.getCodProvedor());
            ps.setString(2,provedor.getNomProvedor());
            ps.setString(3,provedor.getRuc());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("ERROR AL AGREGAR DATOS"+e);
        }finally {
            try {
                conexion.close();
            }catch (Exception e){
                System.out.println("ERROR AL CERRAR CONEXIÓN "+e);
            }
        }
        return false;
    }
    public boolean registrarCategoria(Categoria categoria){
        PreparedStatement ps;
        Connection conexion = Conexion.obtenerConexion();
        var statement = "INSERT INTO mydb.categoria(cod_categoria,nom_categoria)VALUES(?,?)";
        try {
            ps = conexion.prepareStatement(statement);
            ps.setInt(1,categoria.getCodCategoria());
            ps.setString(2,categoria.getNomCategoria());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("ERROR AL AGREGAR DATOS"+e);
        }finally {
            try {
                conexion.close();
            }catch (Exception e){
                System.out.println("ERROR AL CERRAR CONEXIÓN "+e);
            }
        }
        return false;
    }

    public ArrayList<Producto> listarProductos(){
        ArrayList <Producto> lista = new ArrayList<>();
        PreparedStatement ps;
        Connection conexion = Conexion.obtenerConexion();
        ResultSet rs;
        String statement = "SELECT * FROM mydb.producto";
        try {
            ps = conexion.prepareStatement(statement);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setCantidad(rs.getInt(3));
                producto.setUnidad(rs.getString(4));
                producto.setPrecio(rs.getDouble(5));
                producto.setFechaRegistro(rs.getDate(6));
                producto.setCategoria(rs.getString(7));
                producto.setProvedor(rs.getString(8));
                lista.add(producto);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR PRODUCTOS"+e);
        }
        finally {
            try {
                conexion.close();
            }catch (Exception e){
                System.out.println("ERROR AL CERRAR CONEXIÓN "+e);
            }
        }return lista;
    }
    public int obtenerCodCategoria(String codCategoria) {
        PreparedStatement ps;
        Connection conexion = Conexion.obtenerConexion();
        ResultSet rs;
        String statement = "SELECT COD_CATEGORIA FROM mydb.categoria WHERE NOM_CATEGORIA =?";
        int codigo = 0;
        try {
            ps = conexion.prepareStatement(statement);
            ps.setString(1, codCategoria);
            rs = ps.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL ENCONTRAR CÓDIGO"+e);
        }finally {
            try {
                conexion.close();
            }catch (Exception e){
                System.out.println("ERROR AL CERRAR CONEXIÓN "+e);
            }
        }return codigo;
    }
    public int obtenerCodProvedor(String codProvedor) {
        PreparedStatement ps;
        Connection conexion = Conexion.obtenerConexion();
        ResultSet rs;
        String statement = "SELECT COD_PROVEDOR FROM mydb.provedor WHERE NOM_PROVEDOR =?";
        int codigo = 0;
        try {
            ps = conexion.prepareStatement(statement);
            ps.setString(1, codProvedor);
            rs = ps.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL ENCONTRAR CÓDIGO"+e);
        }finally {
            try {
                conexion.close();
            }catch (Exception e){
                System.out.println("ERROR AL CERRAR CONEXIÓN "+e);
            }
        }return codigo;
    }
    public boolean convertirADouble(String string){
        try {
            Double.parseDouble(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean convertirAInt(String string){
        try {
            Integer.parseInt(string);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public ArrayList<Provedor> listarProvedores(){
        ArrayList <Provedor> lista = new ArrayList<>();
        PreparedStatement ps;
        Connection conexion = Conexion.obtenerConexion();
        ResultSet rs;
        String statement = "SELECT * FROM mydb.provedor";
        try {
            ps = conexion.prepareStatement(statement);
            rs = ps.executeQuery();
            while (rs.next()) {
                Provedor provedor = new Provedor();
                provedor.setCodProvedor(rs.getInt(1));
                provedor.setNomProvedor(rs.getString(2));
                provedor.setRuc(rs.getString(3));
                lista.add(provedor);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR PROVEDORES"+e);
        }
        finally {
            try {
                conexion.close();
            }catch (Exception e){
                System.out.println("ERROR AL CERRAR CONEXIÓN "+e);
            }
        }return lista;

    }
    public ArrayList<Categoria> listarCategorias(){
        ArrayList <Categoria> lista = new ArrayList<>();
        PreparedStatement ps;
        Connection conexion = Conexion.obtenerConexion();
        ResultSet rs;
        String statement = "SELECT * FROM mydb.categoria";
        try {
            ps = conexion.prepareStatement(statement);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setCodCategoria(rs.getInt(1));
                categoria.setNomCategoria(rs.getString(2));
                lista.add(categoria);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR CATEGORÍAS"+e);
        }
        finally {
            try {
                conexion.close();
            }catch (Exception e){
                System.out.println("ERROR AL CERRAR CONEXIÓN "+e);
            }
        }return lista;
    }
}
