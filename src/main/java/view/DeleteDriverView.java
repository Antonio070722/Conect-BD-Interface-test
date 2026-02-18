package view;

import javax.swing.*;
import java.awt.*;

public class DeleteDriverView extends JFrame {
    JButton btnBorrar = new JButton("Borrar");
    JButton btnCancelar = new JButton("Cancelar");

    JTextField txtNumDriver = new JTextField();
    JTextField txtName = new JTextField();
    JTextField txtSurname = new JTextField();

    public DeleteDriverView() {
        this.setTitle("Borrar conductor");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel formDatos = new  JPanel(new GridLayout(3, 2, 10, 10));

        JPanel btns = new  JPanel(new FlowLayout(FlowLayout.CENTER));

        btns.add(btnBorrar);
        btns.add(btnCancelar);

        formDatos.add(new JLabel("Nº de conductor: "));
        formDatos.add(txtNumDriver);
        formDatos.add(new JLabel("Nombre:"));
        formDatos.add(txtName);
        formDatos.add(new JLabel("Apellido"));
        formDatos.add(txtSurname);

        this.add(btns, BorderLayout.SOUTH);
        this.add(formDatos, BorderLayout.NORTH);

        setVisible(true);
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JTextField getTxtNumDriver() {
        return txtNumDriver;
    }

    public void setTxtNumDriver(JTextField txtNumDriver) {
        this.txtNumDriver = txtNumDriver;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField getTxtSurname() {
        return txtSurname;
    }

    public void setTxtSurname(JTextField txtSurname) {
        this.txtSurname = txtSurname;
    }
}
