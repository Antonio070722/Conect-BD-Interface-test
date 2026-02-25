package controller;

import controller.DAO.DriverDAO;
import model.Driver;
import view.AddDriverView;
import view.AucorsaView;
import view.DeleteDriverView;

import javax.swing.*;
import java.util.ArrayList;

public class AucorsaController {

    private AucorsaView view;
    ArrayList<Driver> conductores = new ArrayList<>();

    public AucorsaController(AucorsaView view){
        this.view = view;
        //He añadido un escuchador al botón de añadir, para que llame la metodo addDriver.
        view.getBtnadd().addActionListener(e -> addDriver());
        view.getBtnrefres().addActionListener(e -> refrescarTabla());
        view.getBtndelt().addActionListener(e -> borrarDriver());


    }

    public void refrescarTabla() {
        try{
            conductores = DriverDAO.cargarDrivers();
            if (conductores.isEmpty()){
                JOptionPane.showMessageDialog(view, "No hay nada que mostrar", "Información", JOptionPane.INFORMATION_MESSAGE);
            }else{
                view.getTablaDrivers().setRowCount(0);
                view.cargarTablaDrivers(view.getTablaDrivers(), view.getVistaTablaDrivers());
            }
        } catch (Exception e) {
            System.out.println("Error al refrescar la tabla");
        }
    }

    //Este método crea un panel adddriverview y llama a AddDriverController pasandole el panel, que es le encargado de
    // realizar acciones de añadir conductores
    public static void addDriver(){
        AddDriverView panel = new AddDriverView();
        new AddDriverController(panel);
    }

    public static void borrarDriver(){
        DeleteDriverView panel = new DeleteDriverView();
        new DeleteDriverController(panel);
    }
}
