package controller;

import view.AddDriverView;
import view.AucorsaView;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AucorsaController {

    private AucorsaView view;

    public AucorsaController(AucorsaView view){
        this.view = view;
        //He añadido un escuchador al botón de añadir, para que llame la metodo addDriver.
        view.getBtnadd().addActionListener(e -> addDriver());
    }
    //Este método crea un panel adddriverview y llama a AddDriverController pasandole el panel, que es le encargado de
    // realizar acciones de añadir conductores
    public static void addDriver(){
        AddDriverView panel = new AddDriverView();
        new AddDriverController(panel);
    }
}
