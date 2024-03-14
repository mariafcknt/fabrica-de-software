package telas;

import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

public class TelaPrincipal extends JFrame 
                implements MouseInputListener{

    public TelaPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton meuBotao = new JButton("ME CLICA");
        //fala que eu te escuto!!!!
        meuBotao.addMouseListener(this);
        getContentPane().add(meuBotao);

        setSize(400,400);
        setVisible(true);
    }
    public static void main(String[] args) {
        new TelaPrincipal();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        JOptionPane.showMessageDialog(null, "EU NAO ACREDITO");
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseDragged(MouseEvent e) {
    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }
}