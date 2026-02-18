package controller.DAO;

import controller.BD.ConexionBD;
import model.Driver;
import view.DeleteDriverView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DriverDAO {

    public static boolean borrarConductor(int numDriver, String nombre, String apellido, DeleteDriverView view){
        String sql = "DELETE FROM CONDUCTORES WHERE numeroConductor = ? AND nombre = ? AND apellidos = ?";

        try(Connection con = ConexionBD.getConexion();
        PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, numDriver);
            ps.setString(2, nombre);
            ps.setString(3, apellido);

            int filasAfect = ps.executeUpdate();

            if (filasAfect > 0){
                return true;
            } else {
                System.out.println("FALSE: ninguna fila actualizada");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al acceder a la BBDD" + e);
            JOptionPane.showMessageDialog(view, "Ha ocurrido un error. Consulte al administrador", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static boolean insertarConductor(Driver conductorInsert){
        String sql="INSERT INTO CONDUCTORES VALUES(?,?,?)";
        try(Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, conductorInsert.getNumeroConductor());
            ps.setString(2, conductorInsert.getNombre());
            ps.setString(3, conductorInsert.getApellido());

            int rowMods=ps.executeUpdate();

            if (rowMods >0){
                System.out.println("Inserción exitosa");
                return true;
            }else {
                System.out.println("No insertado");
                return false;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        return false;
    }

    public static ArrayList<Driver> cargarDrivers(){
        ArrayList<Driver> conductores = new ArrayList<>();

        String sql = "SELECT numeroConductor, nombre, apellidos from CONDUCTORES";

        try(Connection con = ConexionBD.getConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                int numConductor = rs.getInt("numeroConductor");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                Driver c = new Driver(String.valueOf(numConductor), nombre, apellidos);
                conductores.add(c);

            }
        } catch (Exception e) {
            System.out.println("Error al consultar BDD para la carga de la tabla");
        }

        return conductores;

    }

}
