package controller.DAO;

import controller.BD.ConexionBD;
import model.Driver;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

}
