package controller;

import controller.BD.ConexionBD;
import controller.DAO.DriverDAO;
import model.Driver;
import view.AddDriverView;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class AddDriverController {
    private final AddDriverView view;
    private final DriverDAO driverDAO;

    public AddDriverController(AddDriverView view){
        this.view=view;
        this.driverDAO=new DriverDAO();

        view.getBtnAdd().addActionListener(e -> confirmarGuardado());
        view.getBtnCancel().addActionListener(e -> view.dispose());
    }


    private void confirmarGuardado() {
        boolean guardado=false;

        Driver conductorInsert = new Driver();

        String DNum = view.getNumberDriver().getText().trim();
        String DName = view.getNameInput().getText().trim();
        String DSurname = view.getSurname().getText().trim();

        if (DNum.isEmpty()||DName.isEmpty()||DSurname.isEmpty()){
            JOptionPane.showMessageDialog(view, "Deben estar todos los campos completos.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        conductorInsert.setNombre(view.getNameInput().getText());
        conductorInsert.setApellido(view.getSurname().getText());

        try{
            int numDriver =Integer.parseInt(DNum);
            if (numDriver<0){
                JOptionPane.showMessageDialog(view, "El número debe ser positivo.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
            conductorInsert.setNumeroConductor(String.valueOf(Integer.parseInt(view.getNumberDriver().getText())));
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(view, "El número tiene que ser de un formato numérico válido", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(view, "¿Estás seguro que quieres guardar el conductor?", "Confirmar guardado", JOptionPane.YES_NO_OPTION);

        if (opcion != JOptionPane.YES_OPTION){
            view.dispose();
            return;
        }


        try{
            guardado = DriverDAO.insertarConductor(conductorInsert);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        if (guardado){
            JOptionPane.showMessageDialog(view, "Conductor guardado correctamente.", "Guardado", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(view, "Error al guardar el conductor. Intentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        view.dispose();
    }

}
