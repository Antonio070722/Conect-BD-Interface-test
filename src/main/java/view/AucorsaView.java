package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AucorsaView extends JFrame {
    private JPanel panelBtns = new JPanel();
    private JButton btnadd = new JButton("Añadir");
    private JButton btndelt = new JButton("Borrar");

    private DefaultTableModel tablaDrivers;
    private JTable vistaTabla;

    public AucorsaView() {
        super("Sistema de gestión AUCORSA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,400);
        this.setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        this.add(panelBtns, BorderLayout.NORTH);
        panelBtns.add(btnadd);
        panelBtns.add(btndelt);

        tablaDrivers = new DefaultTableModel(new String[]{"Número", "Nombre", "Apellidos"},0);
        vistaTabla = new JTable(tablaDrivers);

        this.add(vistaTabla, BorderLayout.CENTER);

        this.setVisible(true);

    }

    public JPanel getPanelBtns() {
        return panelBtns;
    }

    public void setPanelBtns(JPanel panelBtns) {
        this.panelBtns = panelBtns;
    }

    public DefaultTableModel getTablaDrivers() {
        return tablaDrivers;
    }

    public void setTablaDrivers(DefaultTableModel tablaDrivers) {
        this.tablaDrivers = tablaDrivers;
    }

    public JTable getVistaTabla() {
        return vistaTabla;
    }

    public void setVistaTabla(JTable vistaTabla) {
        this.vistaTabla = vistaTabla;
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

    public void cargarTabla
}
