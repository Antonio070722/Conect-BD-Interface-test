package view;

import javax.swing.*;
import java.awt.*;

public class AddDriverView extends JFrame{
    private JButton btnAdd = new JButton("Añadir");
    private JButton btnCancel = new JButton("Cancelar");

    private JTextField numberDriver = new JTextField(3);
    private JTextField nameInput = new JTextField(10);
    private JTextField surname = new JTextField(10);

    public AddDriverView() {
        this.setTitle("Añadir conductor");
        setSize(300,200);
        setLocationRelativeTo(null);
        //Panel para los datos del nuevo conductor, he usado grid porque para formularios es lo mas indicado
        //En los parentesis, los números: primero: filas(numDriver, nombre y apellido), segundo: columnas(label y textField),
        //tercero y cuarto: espaciado vertical y horizontal
        JPanel Driverform = new JPanel(new GridLayout(3, 2, 10, 10));
        //Los botones los he metido en otro panel con flowLayout el cual alinea los elementos uno despues del otro
        // y los he centrado
        JPanel BtnAddCancel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        //Labels(etiquetas) y su correspondiente textField(input)
        Driverform.add(new JLabel("Nº de conductor"));
        Driverform.add(numberDriver);
        Driverform.add(new JLabel("Nombre del conductor"));
        Driverform.add(nameInput);
        Driverform.add(new JLabel("Apellidos del conductor"));
        Driverform.add(surname);
        //Añadimos primero el panel del formulario y lo ponemos en la parte central de la ventana
        this.add(Driverform, BorderLayout.CENTER);

        //Botón añadir y cancelar
        BtnAddCancel.add(btnAdd);
        BtnAddCancel.add(btnCancel);
        //Y añadimos este panel, ubicandolo en el sur de la ventana
        this.add(BtnAddCancel, BorderLayout.SOUTH);

        //Evidentemente hacemos visible la ventana
        setVisible(true);
    }


    public JButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JTextField getNumberDriver() {
        return numberDriver;
    }

    public void setNumberDriver(JTextField numberDriver) {
        this.numberDriver = numberDriver;
    }

    public JTextField getNameInput() {
        return nameInput;
    }

    public void setNameInput(JTextField nameInput) {
        this.nameInput = nameInput;
    }

    public JTextField getSurname() {
        return surname;
    }

    public void setSurname(JTextField surname) {
        this.surname = surname;
    }

}
