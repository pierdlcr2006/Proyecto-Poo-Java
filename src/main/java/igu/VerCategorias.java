package igu;

import baseDeDatos.mantenimietnoo.Mantenimiento;
import entidades.Categoria;
import entidades.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerCategorias extends JFrame{
    private JPanel principal;
    private JTable tablaCategoria;
    private JButton btnRegresar;
    private JButton btnActualizar;
    private DefaultTableModel tablaModelorCategorias;

    public VerCategorias(){
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
    private void createUIComponents() {
        tablaModelorCategorias = new DefaultTableModel(0,2);
        String [] cabeceros = {"Id","Nombre"};
        tablaModelorCategorias.setColumnIdentifiers(cabeceros);
        this.tablaCategoria =new JTable(tablaModelorCategorias);
        mostrarProductos();
    }

    private void mostrarProductos() {
        Mantenimiento mantenimiento = new Mantenimiento();
        tablaModelorCategorias.setRowCount(0);
        var cate = mantenimiento.listarCategorias();
        for (Categoria categoria : cate){
            Object [] list = {categoria.getCodCategoria(),categoria.getNomCategoria()};
            tablaModelorCategorias.addRow(list);
        }
    }
    public void inicializar(){
        setContentPane(principal);
        setSize(900,550);
        setLocationRelativeTo(null);
    }

}
