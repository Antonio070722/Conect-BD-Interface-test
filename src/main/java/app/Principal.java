package app;

import controller.AucorsaController;
import view.AucorsaView;

public class Principal {
    static void main(String[] args) {
        AucorsaView vistaPrincipal = new AucorsaView();
        new AucorsaController(vistaPrincipal);
    }
}
