package baseDeDatos.conexion;
import java.sql.*;
public class Conexion {
    public static Connection obtenerConexion(){
        Connection conexion= null;
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "Pdlc2006_";
        try {
            conexion = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            System.out.println("ERROR AL CONECTAR BASE DE DATOS "+e);
        }return conexion;
    }
    public static void main(String[] args) {
        var comprobar =Conexion.obtenerConexion();
        if (comprobar !=null){
            System.out.println("CONEXIÓN CORRECTA");
        }
    }

}
