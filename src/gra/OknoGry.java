package gra;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OknoGry extends JFrame implements KeyListener {

    protected static PanelGry panel;
    private AdapterGry adapter;

    public OknoGry() {

        super("Super Gra");

        String sciezka;
        do {
            sciezka = getSciezka_pliku();
            sciezka = sciezka.toLowerCase();
        } while (!((sciezka.endsWith("jpg")) || (sciezka.endsWith("jpeg")) || (sciezka.endsWith("png"))));

        JOptionPane.showMessageDialog(null, "UWAGA!  Sterowanie Strzałkami");
        JOptionPane.showMessageDialog(null, "Klawisz F2= Nowa Gra");

        panel = new PanelGry(sciezka);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        add(panel);
        addKeyListener(this);

        setSize(d.width, d.height - 50);
        adapter = new AdapterGry();
    }

    @Override
    public void keyPressed(KeyEvent evt) {

        adapter.czytanieKlawisza(evt);
        this.repaint();
        int esc = evt.getKeyCode();
        if ((esc == 27)) {
            this.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {
    }

    @Override
    public void keyTyped(KeyEvent evt) {
    }

    private String getSciezka_pliku() {

        JOptionPane.showMessageDialog(null, "Wybierz plik: jpg, jpeg lub png");
        FileDialog plik = new FileDialog(this, "Wczytaj", FileDialog.LOAD);
        plik.setVisible(true);

        return plik.getDirectory() + plik.getFile();
    }

}

