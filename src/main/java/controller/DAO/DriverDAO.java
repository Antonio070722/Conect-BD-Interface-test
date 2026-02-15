package controller.DAO;

import controller.BD.ConexionBD;
import model.Driver;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DriverDAO {

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

        String sql = "SELECT numeroConductor, nombre, apellidos from conductores";

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
