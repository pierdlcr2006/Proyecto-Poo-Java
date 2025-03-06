package entidades;
import java.util.*;
public class Producto {
    private int codProducto;
    private String nombre;
    private String categoria;
    private double cantidad;
    private String unidad;
    private double precio;
    private String moneda;
    private String provedor;
    private Date fechaRegistro;
    public Producto(){

    }
    public Producto(int codProducto){

    }
    public Producto(int codProducto,String nombre,String categoria, int cantidad,String unidad,
                    double precio,Date fechaRegistro,String moneda, String provedor){
        this(codProducto);
        this.nombre=nombre;
        this.categoria =categoria;
        this.cantidad =cantidad;
        this.fechaRegistro = fechaRegistro;
        this.unidad = unidad;
        this.precio= precio;
        this.moneda = moneda;
        this.provedor = provedor;
    }
    public Producto(String nombre,String categoria, double cantidad,String unidad,double precio,
                    String moneda, String provedor){
        this.nombre=nombre;
        this.categoria =categoria;
        this.cantidad =cantidad;
        this.unidad = unidad;
        this.precio= precio;
        this.moneda = moneda;
        this.provedor = provedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Producto producto = (Producto) object;
        return codProducto == producto.codProducto && cantidad == producto.cantidad && Double.compare(precio,
                producto.precio) == 0 && Objects.equals(nombre, producto.nombre) && Objects.equals(categoria,
                producto.categoria) && Objects.equals(unidad, producto.unidad) && Objects.equals(moneda,
                producto.moneda) && Objects.equals(provedor, producto.provedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codProducto, nombre, categoria, cantidad, unidad, precio, moneda, provedor);
    }
}