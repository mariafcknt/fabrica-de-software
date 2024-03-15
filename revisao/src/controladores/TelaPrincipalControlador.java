package controladores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JComponent;

public class TelaPrincipalControlador implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JComponent)e.getSource()).getName().equals("meuBotao")){
            JOptionPane.showMessageDialog(null, "eu não acredito");
        }
    }
    
}
