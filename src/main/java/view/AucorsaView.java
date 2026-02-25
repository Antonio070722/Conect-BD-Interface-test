package view;

import controller.DAO.BusDAO;
import controller.DAO.DriverDAO;
import model.Bus;
import model.Driver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;

public class AucorsaView extends JFrame {
    private JPanel panelBtns = new JPanel();
    private JButton btnadd = new JButton("Añadir");
    private JButton btndelt = new JButton("Borrar");
    private JButton btnrefres = new JButton("Refrescar");

    private DefaultTableModel tablaDrivers;
    private JTable vistaTablaDrivers;

    private DefaultTableModel tablaBuses;
    private JTable vistaTablaBuses;

    public AucorsaView() {
        super("Sistema de gestión AUCORSA");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,400);
        this.setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();

        JPanel conductorPanel = new JPanel();
        JPanel busPanel = new JPanel();
        JPanel rutepanel = new JPanel();

        tabs.addTab("Conductor", conductorPanel);
        tabs.addTab("Bus", busPanel);
        tabs.add("Rutas", rutepanel);
        add(tabs, BorderLayout.CENTER);

        this.add(panelBtns, BorderLayout.NORTH);
        panelBtns.add(btnadd);
        panelBtns.add(btndelt);
        panelBtns.add(btnrefres);

        //Creacion y carga de los datos en la tabla de conductores
        tablaDrivers = new DefaultTableModel(new String[]{"Número", "Nombre", "Apellidos"},0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };
        vistaTablaDrivers = new JTable(tablaDrivers);
        vistaTablaDrivers.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPaneDriver = new JScrollPane(vistaTablaDrivers);

        conductorPanel.add(scrollPaneDriver, BorderLayout.CENTER);

        cargarTablaDrivers(tablaDrivers, vistaTablaDrivers);

        //Crear y cargar tabla bus
        tablaBuses = new DefaultTableModel(new String[]{"Registro", "Tipo", "Licencia"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };
        vistaTablaBuses = new JTable(tablaBuses);
        vistaTablaBuses.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPaneBuses = new JScrollPane(vistaTablaBuses);

        busPanel.add(scrollPaneBuses, BorderLayout.CENTER);

        cargarTablaBuses(tablaBuses, vistaTablaBuses);

        this.setVisible(true);

    }

    private void cargarTablaBuses(DefaultTableModel tablaBuses, JTable vistaTablaBuses) {
        ArrayList<Bus> busesCargar = new ArrayList<>();
        try {
            busesCargar = BusDAO.cargarBuses();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error en la carga de la tabla", "Error de carga", JOptionPane.ERROR_MESSAGE);
        }
        tablaBuses = (DefaultTableModel) vistaTablaBuses.getModel();
        for (Bus b :  busesCargar) {
            tablaBuses.addRow(new Object[]{
                    b.getRegistro(),
                    b.getTipo(),
                    b.getLicencia()
            });
        }

    }

    public static void cargarTablaDrivers(DefaultTableModel table, JTable vistaTabla){
        ArrayList<Driver> conductoresCargar = DriverDAO.cargarDrivers();
        table = (DefaultTableModel) vistaTabla.getModel();
        for (Driver d : conductoresCargar){
            table.addRow(new Object[]{
                    d.getNumeroConductor(),
                    d.getNombre(),
                    d.getApellido()
            });
        }
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

    public JTable getVistaTablaDrivers() {
        return vistaTablaDrivers;
    }

    public void setVistaTablaDrivers(JTable vistaTablaDrivers) {
        this.vistaTablaDrivers = vistaTablaDrivers;
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

    public JButton getBtnrefres() {
        return btnrefres;
    }

    public void setBtnrefres(JButton btnrefres) {
        this.btnrefres = btnrefres;
    }


}
