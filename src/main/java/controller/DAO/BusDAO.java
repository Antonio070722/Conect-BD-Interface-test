package controller.DAO;

import controller.BD.ConexionBD;
import model.Bus;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BusDAO {

    public static ArrayList<Bus> cargarBuses(){
        ArrayList<Bus> buses = new ArrayList<>();

        String sql = "SELECT * FROM BUSES";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String Registro = rs.getString("Registro");
                String Tipo = rs.getString("Tipo");
                String Licencia = rs.getString("Licencia");


                Bus b = new Bus(Registro, Tipo, Licencia);
                buses.add(b);

            }
        }catch (Exception e){
            System.out.println("Error en el acceso a la BDD para cargar la tabla\n"+e);
        }

        return buses;
    }

}
