package igu;

import baseDeDatos.mantenimietnoo.Mantenimiento;
import entidades.Provedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerProvedores extends JFrame{
    private JButton btnRegresar;
    private JTable tablaProvedores;
    private JButton actualizarButton;
    private JPanel principal;
    private JScrollPane scrollPane1;
    private DefaultTableModel tablaModeloProvedores;

    public VerProvedores(){
        incializar();
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Principal principal1 = new Principal();
                principal1.setVisible(true);
                dispose();
            }
        });
    }

    private void incializar() {
        setContentPane(principal);
        setSize(900,550);
        setLocationRelativeTo(null);
    }
    private void createUIComponents() {
        tablaModeloProvedores = new DefaultTableModel(0,3);
        String [] cabeceros = {"ID","Nombre","RUC"};
        tablaModeloProvedores.setColumnIdentifiers(cabeceros);
        tablaProvedores = new JTable(tablaModeloProvedores);
        mostrarProvedores();
    }

    public void mostrarProvedores(){
        Mantenimiento mantenimiento = new Mantenimiento();
        tablaModeloProvedores.setRowCount(0);
        var prove = mantenimiento.listarProvedores();
        for (Provedor provedor : prove){
            Object [] list = {provedor.getCodProvedor(),provedor.getNomProvedor(),provedor.getRuc()};
            tablaModeloProvedores.addRow(list);
        }
    }


}
