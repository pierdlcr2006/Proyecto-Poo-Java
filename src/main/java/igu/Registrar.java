package igu;
import baseDeDatos.mantenimietnoo.Mantenimiento;
import entidades.Categoria;
import entidades.Producto;
import entidades.Provedor;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registrar extends  JFrame{
    private JTextField txtNombre;
    private JTextField txtStock;
    private JComboBox cmdCategoria;
    private JComboBox cmdProvedor;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JPanel registrar;
    private JTextField txtPrecio;
    private JComboBox cmdUnidad;
    private JComboBox cmdMoneda;
    private JButton btnRegresar;
    private JLabel txtMoneda;

    public Registrar(){
        inicializar();
        mostrarProvedores();
        mostrarCategorias();
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText("");
                txtStock.setText("");
                txtPrecio.setText("");
                cmdCategoria.setSelectedIndex(0);
                cmdProvedor.setSelectedIndex(0);
                cmdUnidad.setSelectedIndex(0);
                cmdMoneda.setSelectedIndex(0);
            }
        });
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Principal principal = new Principal();
                principal.setVisible(true);
                dispose();
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mantenimiento mantenimiento = new Mantenimiento();
                String nombre= "",categoria = "",provedor="",unidad="",moneda="";
                double stock= 0,precio = 0;

                if (txtNombre.getText().equals("") && cmdProvedor.getSelectedIndex()==0 && cmdMoneda.getSelectedIndex() ==0 && txtStock.getText().equals("")
                        && txtPrecio.getText().equals("") && cmdUnidad.getSelectedIndex()==0
                        && cmdCategoria.getSelectedIndex()==0){
                    var mensaje = "POR FAVOR REGISTRE UN PRODUCTO";
                    JOptionPane.showMessageDialog(null,mensaje);
                }
                else {
                    if (txtNombre.getText().equals("")) {
                        var mensaje = "POR FAVOR AGREGUE UN NOMBRE";
                        JOptionPane.showMessageDialog(null, mensaje);
                    }else {
                        nombre = txtNombre.getText().toUpperCase();
                    }if (txtPrecio.getText().equals("")){
                        var mensaje ="POR FAVOR AGREGUE UN PRECIO";
                        JOptionPane.showMessageDialog(null,mensaje);
                    }else {
                        var comprobar = mantenimiento.convertirADouble(txtPrecio.getText());
                        if (comprobar){
                            precio =Double.parseDouble(txtPrecio.getText());
                        }else {
                            var mensaje = "POR FAVOR AGREGUE UN PRECIO VÁLIDO";
                            JOptionPane.showMessageDialog(null,mensaje);
                        }
                    }if (txtStock.equals("")){
                        var mensaje ="POR FAVOR AGREGUE UN STOCK";
                        JOptionPane.showMessageDialog(null,mensaje);
                    }else {
                        var comprobar = mantenimiento.convertirADouble(txtStock.getText());
                        if (comprobar){
                            stock = Double.parseDouble(txtStock.getText());
                        }else {
                            var mensaje = "POR FAVOR DIGITE CANTIDAD NUMÉRICA";
                            JOptionPane.showMessageDialog(null,mensaje);
                        }
                    }
                    if (cmdCategoria.getSelectedIndex() == 0){
                        var mensaje ="POR FAVOR AGREGUE UNA CATEGORIA";
                        JOptionPane.showMessageDialog(null,mensaje);
                    }else{
                        categoria = cmdCategoria.getSelectedItem().toString();
                    }
                    if (cmdProvedor.getSelectedIndex() == 0){
                        var mensaje ="POR FAVOR AGREGUE UN PROVEDOR";
                        JOptionPane.showMessageDialog(null,mensaje);
                    }else{
                        provedor = cmdProvedor.getSelectedItem().toString();
                    }
                    if (cmdUnidad.getSelectedIndex() == 0){
                        var mensaje ="POR FAVOR AGREGUE UNA UNIDAD";
                        JOptionPane.showMessageDialog(null,mensaje);
                    }else{
                        unidad = cmdUnidad.getSelectedItem().toString();
                    }
                    if (cmdMoneda.getSelectedIndex() == 0){
                        var mensaje ="POR FAVOR AGREGUE UNA MONEDA";
                        JOptionPane.showMessageDialog(null,mensaje);
                    }
                    else {
                        moneda = cmdMoneda.getSelectedItem().toString();
                    }
                }
                if (!nombre.equals("") && precio !=0 && stock !=0 && !categoria.equals("") && !provedor.equals("") && !unidad.equals("") && !moneda.equals("")){
                    Categoria categoria1 = new Categoria();
                    Provedor provedor1 = new Provedor();
                    Producto producto = new Producto(nombre,categoria,stock,unidad,precio,moneda,provedor);
                    provedor1.setCodProvedor(mantenimiento.obtenerCodProvedor(provedor));
                    categoria1.setCodCategoria(mantenimiento.obtenerCodCategoria(categoria));
                    var comprobar = mantenimiento.registrarProducto(producto,categoria1,provedor1);
                    if (comprobar){
                        var mensaje = "PRODUCTO AGREGADO";
                        JOptionPane.showMessageDialog(null,mensaje);
                        txtNombre.setText("");
                        txtStock.setText("");
                        txtPrecio.setText("");
                        cmdCategoria.setSelectedIndex(0);
                        cmdProvedor.setSelectedIndex(0);
                        cmdUnidad.setSelectedIndex(0);
                        cmdMoneda.setSelectedIndex(0);
                    }else {
                        var mensaje = "PRODUCTOS NO AGREGADO";
                        JOptionPane.showMessageDialog(null,mensaje);
                    }
                }


            }});
    }
    public void mostrarProvedores(){
        cmdProvedor.removeAllItems();
        cmdProvedor.addItem("");
        Mantenimiento mantenimiento = new Mantenimiento();
        var lista = mantenimiento.listarProvedores();
        for (Provedor provedor:lista){
            cmdProvedor.addItem(provedor.getNomProvedor());
        }
    }
    public void mostrarCategorias(){
        cmdCategoria.removeAllItems();
        cmdCategoria.addItem("");
        Mantenimiento mantenimiento = new Mantenimiento();
        var lista = mantenimiento.listarCategorias();
        for (Categoria categoria: lista){
            cmdCategoria.addItem(categoria.getNomCategoria());
        }
    }
    public void inicializar(){
        setContentPane(registrar);
        setSize(700,500);
        setLocationRelativeTo(null);
    }
}
