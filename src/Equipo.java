import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private List<Avenger> lista;

    public Equipo(){
        lista = new ArrayList<>();
        lista.add(new Avenger("IRN-03", "IronMan", "Rescate Internacional", 3, 5000.2f));
        lista.add(new Avenger("HLK-05", "Hulk", "Romper cosas", 5, 6000.9f));
        lista.add(new Avenger("THR-04", "Thor", "Vigilancia Galáctica", 4, 5500.0f));
    }

    public void registrarAvenger(Avenger a){
        for (Avenger x : lista) {
            if (x.getId().equals(a.getId())) {
                JOptionPane.showMessageDialog(null, "Ya existe un Avenger con esa ID");
                return;
            }
        }
        lista.add(a);
        JOptionPane.showMessageDialog(null, "Avenger registrado exitosamente");
    }


    public void editarDatos(Avenger a){
        for (Avenger x : lista) {
            if (x.getId().equals(a.getId())) {
                x.setNombre(a.getNombre());
                x.setMision(a.getMision());
                x.setNivelPeligrosidad(a.getNivelPeligrosidad());
                x.setPagoMensual(a.getPagoMensual());
                JOptionPane.showMessageDialog(null, "Avenger editado exitosamente");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No hay un avenger con esa id");
    }


    public boolean buscarDatos(String texto, String patron){
        texto = texto.toLowerCase();
        patron = patron.toLowerCase();

        int n = texto.length();
        int m = patron.length();

        if (m > n){
            return false;
        }

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (texto.charAt(i + j) != patron.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return true;
            }
        }
        return false;
    }

    public List<Avenger> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "lista=" + lista +
                '}';
    }
}
