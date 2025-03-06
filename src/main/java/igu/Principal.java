package igu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Principal extends JFrame{
    private JButton btnRegistProduc;
    private JButton btnVerPro;
    private JPanel principal;
    private JButton btnVerProvedores;
    private JButton btnRegistProvedores;
    private JButton btnRegisCatego;
    private JButton btnVerCatego;
    private JButton btnSalir;

    public Principal() {
        inicializar();
        btnRegistProduc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registrar registrar = new Registrar();
                registrar.setVisible(true);
                registrar.setDefaultCloseOperation(EXIT_ON_CLOSE);
                dispose();
            }
        });

        btnVerPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VerProductos verProductos = new VerProductos();
                verProductos.setVisible(true);
                verProductos.setDefaultCloseOperation(EXIT_ON_CLOSE);
                dispose();
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Principal principal = new Principal();
                principal.setDefaultCloseOperation(EXIT_ON_CLOSE);
                dispose();


            }
        });
        btnRegistProvedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarProvedores regProv = new RegistrarProvedores();
                regProv.setVisible(true);
                regProv.setDefaultCloseOperation(EXIT_ON_CLOSE);
                dispose();
            }
        });

        btnVerProvedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VerProvedores verProv = new VerProvedores();
                verProv.setVisible(true);
                verProv.setDefaultCloseOperation(EXIT_ON_CLOSE);
                dispose();
            }
        });
        btnRegisCatego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarCategoria regCat = new RegistrarCategoria();
                regCat.setVisible(true);
                regCat.setDefaultCloseOperation(EXIT_ON_CLOSE);
                dispose();

            }
        });
        btnVerCatego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VerCategorias verCate = new VerCategorias();
                verCate.setVisible(true);
                verCate.setDefaultCloseOperation(EXIT_ON_CLOSE);
                dispose();
            }
        });
    }
    public void inicializar(){
        setContentPane(principal);
        setSize(1050,550);
        setLocationRelativeTo(null);
    }
}
