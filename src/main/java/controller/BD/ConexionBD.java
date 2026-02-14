package controller.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    public static String USER = "root";
    public static String PASS = "1234";
    public static String URL = "jdbc:mysql://127.0.0.1:3306/Aucorsa";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
