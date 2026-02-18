package controller;

import controller.DAO.DriverDAO;
import view.AucorsaView;
import view.DeleteDriverView;

import javax.swing.*;

public class DeleteDriverController {
    DeleteDriverView view;
    DriverDAO driverDAO;

    public DeleteDriverController(DeleteDriverView view){
        this.view = view;
        this.driverDAO = new DriverDAO();

        view.getBtnBorrar().addActionListener(e -> confirmarBorrado());
        view.getBtnCancelar().addActionListener(e -> view.dispose());
    }

    private void confirmarBorrado() {
        boolean borrado=false;

        String numDriverDelete = view.getTxtNumDriver().getText().trim();
        String nombreDelete = view.getTxtName().getText().trim();
        String apellidoDelete = view.getTxtSurname().getText().trim();

        if (numDriverDelete.isEmpty() || nombreDelete.isEmpty() || apellidoDelete.isEmpty()){
            JOptionPane.showMessageDialog(view, "Complete todos los campos requeridos", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int numDriver=0;
        try {
            numDriver = Integer.parseInt(numDriverDelete);
            if (numDriver < 0) {
                JOptionPane.showMessageDialog(view, "El número de conductor no puede ser negativo", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(view, "El número de conductor tiene que ser de formato numérico");
            return;
        }

        int opcion = 0;
        opcion = JOptionPane.showConfirmDialog(view, "¿Seguro que desea borrar el conductor introducido?", "Borrar", JOptionPane.YES_NO_OPTION);

        if (opcion != JOptionPane.YES_OPTION){
            view.dispose();
            return;
        }

        try {
            borrado = DriverDAO.borrarConductor(numDriver, nombreDelete, apellidoDelete, view);
        } catch (Exception e) {
            System.out.println("La llamada al método borrarConductor en el DriverDAO ha fallado"+e);
        }

        if (borrado){
            JOptionPane.showMessageDialog(view, "Conductor borrado correctamente", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(view, "Conductor no borrado, revise los datos", "No borrado", JOptionPane.ERROR_MESSAGE);
        }

    }

}
