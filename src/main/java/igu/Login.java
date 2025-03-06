package igu;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;


public class Login extends JFrame{
    private JPanel login;
    private JLabel txtSesion;
    private JPasswordField txtContra;
    private JFormattedTextField txtUsuario;
    private JButton btnIniciar;

    public Login(){
        inicializar();
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validar();
            }
        });
    }
    public void inicializar(){
        setContentPane(login);
        setSize(600,400);
        setLocationRelativeTo(null);
    }
    public void validar(){
        var usuario = txtUsuario.getText();
        var password = new String(txtContra.getPassword());
        if ("admin".equals(usuario) && "admin".equals(password)){
            var mensaje = "BIENVENIDO";
            JOptionPane.showMessageDialog(this,mensaje);
            Principal principal = new Principal();
            principal.setVisible(true);
            principal.setDefaultCloseOperation(EXIT_ON_CLOSE);
            dispose();
        }else {
            var mensaje = "datos incorrectos";
            JOptionPane.showMessageDialog(this,mensaje);
        }
    }
    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        Login login = new Login();
        login.setDefaultCloseOperation(EXIT_ON_CLOSE);
        login.setVisible(true);

    }
}
