package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AucorsaView extends JFrame {
    JPanel panelBtns = new JPanel();
    JButton btnadd = new JButton("Añadir");
    JButton btndelt = new JButton("Borrar");

    public AucorsaView() {
        super("Sistema de gestión AUCORSA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        setLayout(new BorderLayout());

        this.add(panelBtns, BorderLayout.NORTH);
        panelBtns.add(btnadd);
        panelBtns.add(btndelt);
    }

    public JPanel getPanelBtns() {
        return panelBtns;
    }

    public void setPanelBtns(JPanel panelBtns) {
        this.panelBtns = panelBtns;
    }

    public JButton getBtnadd() {
        return btnadd;
    }

    public void setBtnadd(JButton btnadd) {
        this.btnadd = btnadd;
    }

    public JButton getBtndelt() {
        return btndelt;
    }

    public void setBtndelt(JButton btndelt) {
        this.btndelt = btndelt;
    }
}
