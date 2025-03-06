package igu;

import baseDeDatos.mantenimietnoo.Mantenimiento;
import entidades.Categoria;
import entidades.Provedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarCategoria extends JFrame{
    private JPanel principal;
    private JTextField txtCod;
    private JTextField txtNom;
    private JButton registrarButton;
    private JButton limpiarButton;
    private JButton btnRegresar;
    public RegistrarCategoria(){
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
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCod.setText("");
                txtNom.setText("");
            }
        });
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mantenimiento mantenimiento = new Mantenimiento();
                String codigo = "",nombre ="";
                int cod = 0;
                if (txtNom.getText().equals("") && txtCod.getText().equals("")){
                    String mensaje = "REGISTRE UN CATEGORÍA";
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
                    }if (cod !=0 && !nombre.equals("")){
                        Categoria categoria = new Categoria(cod,nombre);
                        var comprobar = mantenimiento.registrarCategoria(categoria);
                        if (comprobar){
                            String mensaje = "CATEGORÍA REGISTRADA";
                            JOptionPane.showMessageDialog(null,mensaje);
                            txtCod.setText("");
                            txtNom.setText("");
                        }else {
                            String mensaje = "NO SE REGISTRÓ LA CATEGORÍA";
                            JOptionPane.showMessageDialog(null,mensaje);
                        }

                    }

                }
            }
        });
    }

    private void inicializar() {
        setContentPane(principal);
        setSize(700,400);
        setLocationRelativeTo(null);
    }
}
