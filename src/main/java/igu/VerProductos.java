package igu;

import baseDeDatos.mantenimietnoo.Mantenimiento;
import entidades.Producto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerProductos extends JFrame{

    private JPanel principal;
    private JScrollPane ProductoTabla;
    private JTable tablaProducto;
    private JButton btnRegresar;
    private JButton btnActualizar;
    private JButton ELIMINARButton;
    private DefaultTableModel tablaModeloProductos;

    public  VerProductos(){
        inicializar();
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Principal principal1 = new Principal();
                principal1.setVisible(true);
                principal1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                dispose();
            }
        });

    }
    public void inicializar(){
        setContentPane(principal);
        setSize(900,550);
        setLocationRelativeTo(null);

    }

    private void createUIComponents() {
        tablaModeloProductos = new DefaultTableModel(0,8);
        String [] cabeceros = {"Id","Nombre","Cantidad","Unidad","Precio","Fecha_Registro","Cod_Categoría","Cod_Provedor"};
        tablaModeloProductos.setColumnIdentifiers(cabeceros);
        this.tablaProducto =new JTable(tablaModeloProductos);
        mostrarProductos();
    }

    private void mostrarProductos() {
        Mantenimiento mantenimiento = new Mantenimiento();
        tablaModeloProductos.setRowCount(0);
        var produc = mantenimiento.listarProductos();
        for (Producto producto : produc){
            Object [] list = {producto.getCodProducto(),producto.getNombre(),producto.getCantidad(),producto.getUnidad(),producto.getPrecio(),
            producto.getFechaRegistro(),producto.getCategoria(),producto.getProvedor()};
            tablaModeloProductos.addRow(list);
        }
    }
}
