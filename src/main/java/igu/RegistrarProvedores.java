package igu;

import baseDeDatos.mantenimietnoo.Mantenimiento;
import entidades.Provedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarProvedores extends JFrame {
    private JPanel Principal;
    private JTextField txtCod;
    private JTextField txtNom;
    private JTextField txtRuc;
    private JButton btnRegistrar;
    private JButton btmLimpiar;
    private JButton btnRegresar;

    public RegistrarProvedores(){
        inicializar();
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Principal principal = new Principal();
                principal.setDefaultCloseOperation(EXIT_ON_CLOSE);
                principal.setVisible(true);
                dispose();
            }
        });
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mantenimiento mantenimiento = new Mantenimiento();
                String codigo = "",nombre ="",ruc = "";
                int cod = 0;
                double nuevoRuc = 0;
                if (txtNom.getText().equals("") && txtRuc.getText().equals("")&& txtCod.getText().equals("")){
                    String mensaje = "REGISTRE UN PROVEDOR";
                    JOptionPane.showMessageDialog(null,mensaje);
                }else {
                    if (txtCod.getText().equals("")){
                        String mensaje = "AGREGUE UN CODIGO";
                        JOptionPane.showMessageDialog(null,mensaje);
                    }else {
                        codigo = txtCod.getText();
                        var comprobar = mantenimiento.convertirAInt(codigo);
                        if (comprobar){
                            cod = Integer.parseInt(codigo);
                        }else {
                            String mensaje = "CÓDIGO INVÁLIDO";
                            JOptionPane.showMessageDialog(null,mensaje);
                        }
                    }if (txtNom.getText().equals("")){
                        String mensaje = "AGREGUE UN NOMBRE";
                        JOptionPane.showMessageDialog(null,mensaje);
                    }else {
                        nombre = txtNom.getText().toUpperCase();
                    }if (txtRuc.getText().equals("")){
                        String mensaje = "AGREGUE UN RUC";
                        JOptionPane.showMessageDialog(null,mensaje);
                    }else {
                        ruc = txtRuc.getText();
                        var comprobar = mantenimiento.convertirADouble(ruc);
                        if (comprobar){
                            ruc = txtRuc.getText();
                            nuevoRuc = Double.parseDouble(ruc);
                        }else {
                            String mensaje = "RUC INVÁLIDO";
                            JOptionPane.showMessageDialog(null,mensaje);
                        }
                    }if (cod !=0 && !nombre.equals("")&& nuevoRuc !=0){
                        Provedor provedor = new Provedor(cod,nombre,ruc);
                        var comprobar = mantenimiento.registrarProvedor(provedor);
                        if (comprobar){
                            String mensaje = "PROVEDOR REGISTRADO";
                            JOptionPane.showMessageDialog(null,mensaje);
                            txtCod.setText("");
                            txtNom.setText("");
                            txtRuc.setText("");
                        }else {
                            String mensaje = "PROVEDOR NO REGISTRADO";
                            JOptionPane.showMessageDialog(null,mensaje);
                        }

                    }

                }
            }
        });
        btmLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCod.setText("");
                txtNom.setText("");
                txtRuc.setText("");
            }
        });
    }
    public void inicializar(){
        setContentPane(Principal);
        setSize(700,400);
        setLocationRelativeTo(null);
    }
}
