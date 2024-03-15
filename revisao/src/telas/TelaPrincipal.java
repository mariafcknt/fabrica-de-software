package telas;

import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controladores.TelaPrincipalControlador;

public class TelaPrincipal extends JFrame{
    private TelaPrincipalControlador controlador = new TelaPrincipalControlador();

    public TelaPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton meuBotao = new JButton("ME CLICA");
        meuBotao.addActionListener(controlador);
        meuBotao.setName("meuBotao");
        getContentPane().add(meuBotao);

        JButton meuBotao2 = new JButton("ME CLICA TAMBEM");
        meuBotao2.setName("meuBotao2");
        meuBotao2.addActionListener(controlador);
        getContentPane().add(meuBotao2, "South");

        setSize(400,400);
        setVisible(true);
    }
    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
