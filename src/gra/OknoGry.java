package gra;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class OknoGry extends JFrame implements KeyListener {

    public static PanelGry obraz = new PanelGry();
    AdapterGry adapter;

    private int x, y;


    public OknoGry() {
        super("Super Gra");
        JOptionPane.showMessageDialog(null, "UWAGA!  Sterowanie Strzałkami");
        JOptionPane.showMessageDialog(null, "Klawisz F2= Nowa Gra");

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        add(obraz);
        addKeyListener(this);

        setSize(d.width, d.height-30);
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

