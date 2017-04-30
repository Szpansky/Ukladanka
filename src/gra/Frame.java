package gra;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Frame extends JFrame implements KeyListener {

    public static Panel obrazPanel = new Panel();
    AdapterGry adapter;

    private int x, y;


    public Frame() {
        super("Super Gra");
        JOptionPane.showMessageDialog(null, "UWAGA!  Sterowanie Strzałkami");
        JOptionPane.showMessageDialog(null, "Klawisz F2= Nowa Gra");

        add(obrazPanel);
        addKeyListener(this);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((obrazPanel.rozzdj * 5) + (obrazPanel.odst * 5) + 10, (obrazPanel.rozzdj * 5) + (obrazPanel.odst * 5) + 30);
        adapter = new AdapterGry();
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        adapter.czytanieKlawisza(evt);
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent evt) {
    }

    @Override
    public void keyTyped(KeyEvent evt) {
    }


}

