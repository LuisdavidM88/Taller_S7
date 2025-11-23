import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Ventana {
    private JPanel Principal;
    private JTabbedPane tabbedPane1;
    private JTextField txtBuscarID;
    private JTextField txtId;
    private JTextField txtNombre;
    private JComboBox cboMision;
    private JSlider sdrPeligrosidad;
    private JTextField txtPago;
    private JButton btnRegistar;
    private JButton btnEditar;
    private JButton btnBuscar;
    private JList lstBuscar;
    private JTextArea txtAreaReporte;
    private JButton btnReporte;
    Equipo equipo = new Equipo();

    Avenger a1 = new Avenger("1A", "IronMan", "Salvar al mundo", 5, 5000.2f);
    Avenger a2 = new Avenger("1B", "IronMan", "Salvar al mundo", 5, 5000.2f);
    Avenger a3 = new Avenger("1V", "IronMan", "Salvar al mundo", 5, 5000.2f);

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void llenarJList(){
        DefaultListModel dlm=new DefaultListModel<>();
        for(Avenger avg:equipo.getLista()){
            dlm.addElement(avg);
        }
        lstBuscar.setModel(dlm);
    }

    public Ventana() {
        sdrPeligrosidad.setMaximum(5);
        sdrPeligrosidad.setMinimum(1);
        sdrPeligrosidad.setMajorTickSpacing(1);
        sdrPeligrosidad.setPaintTicks(true);
        sdrPeligrosidad.setPaintLabels(true);

        llenarJList();

        btnRegistar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                String nombre = txtNombre.getText();
                String mision = cboMision.getSelectedItem().toString();
                int peligrosidad = sdrPeligrosidad.getValue();
                float pagoMensual = Float.parseFloat(txtPago.getText());
                Avenger a = new Avenger(id, nombre, mision, peligrosidad, pagoMensual);
                equipo.registrarAvenger(a);
                llenarJList();
            }
        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                String nombre = txtNombre.getText();
                String mision = cboMision.getSelectedItem().toString();
                int peligrosidad = sdrPeligrosidad.getValue();
                float pagoMensual = Float.parseFloat(txtPago.getText());
                Avenger a = new Avenger(id, nombre, mision, peligrosidad, pagoMensual);
                equipo.editarDatos(a);
            }
        });
        lstBuscar.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(lstBuscar.getSelectedIndex() != -1){
                    Avenger a = (Avenger) lstBuscar.getSelectedValue();
                    txtId.setText(a.getId());
                    txtNombre.setText(a.getNombre());
                    cboMision.setSelectedItem(a.getMision());
                    sdrPeligrosidad.setValue(a.getNivelPeligrosidad());
                    txtPago.setText(String.valueOf(a.getPagoMensual()));
                    JOptionPane.showMessageDialog(null, "Revise la pantalla de registro para editar");
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idBuscar = txtBuscarID.getText();
                DefaultListModel dlm = new DefaultListModel();
                List<Avenger> avg = equipo.getLista();
                if (idBuscar.isEmpty()) {
                    for (Avenger a : avg) {
                        dlm.addElement(a);
                    }
                }else {
                    for (Avenger a : avg) {
                        if (equipo.buscarDatos(a.getId(), idBuscar)) {
                            dlm.addElement(a);
                        }
                    }
                }
                lstBuscar.setModel(dlm);
            }
        });
        btnReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Avenger> avg = equipo.getLista();
                if(lstBuscar.getSelectedIndex() != -1){
                    Avenger a = (Avenger) lstBuscar.getSelectedValue();
                    txtAreaReporte.setText(" Nombre del Avenger: " + a.getNombre() +
                            "\n Pago Mensual: " + a.getPagoMensual() +
                            "\n Aporte al Fondo de Héroes: " + a.calcularAporte() +
                            "\n Impuesto anual al gobierno: " + a.calcularImpuesto() +
                            "\n Pago neto a recibir al mes: " + a.pagoNeto());
                    JOptionPane.showMessageDialog(null, "Revise la pantalla de reporte");
                }else {
                    JOptionPane.showMessageDialog(null, "Seleccione un avenger");
                }

            }
        });
    }
}
