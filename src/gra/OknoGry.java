package gra;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Klasa OknoGry, tworzy okno gry.
 * Klasa posiada możliwość sprawdzania rozszerzenia wczytywanego pliku,
 */
public class OknoGry extends JFrame implements KeyListener {

    /**
     * Zmienna referencyjna PanelGry panel, jest używana przez
     * zaprzyjaźnione klasy.
     * Posiada także obiekt Adaptera gry @see AdapterGry
     */
    protected static PanelGry panel;
    private AdapterGry adapter;

    /**
     * Konstruktor który ustawia główne elementy okna.
     * Sprawdza rozszerzenie pliku graficznego oraz
     * dodaje "nasłuchiwacza", by gracz mógł wyjść za pomocą ESC
     */
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

    /**
     * Metoda sprawdzająca czy został wciśnięty ESC
     * @param evt parametr przekazujący przez KeyListner
     */
    @Override
    public void keyPressed(KeyEvent evt) {

        adapter.czytanieKlawisza(evt);
        this.repaint();
        int esc = evt.getKeyCode();
        if ((esc == 27)) {
            this.dispose();
        }
    }

    /**
     * Metoda przeciążona
     * @param evt parametr przekazujący przez KeyListner
     */
    @Override
    public void keyReleased(KeyEvent evt) {
    }

    /**
     * Metoda przeciążona
     * @param evt parametr przekazujący przez KeyListner
     */
    @Override
    public void keyTyped(KeyEvent evt) {
    }

    /**
     * Metoda tworzy okno w którym użytkownik może wybrać
     * plik do odczytu
     * @return Zwraca całą ścieżkę bezwzględną
     */
    private String getSciezka_pliku() {

        JOptionPane.showMessageDialog(null, "Wybierz plik: jpg, jpeg lub png");
        FileDialog plik = new FileDialog(this, "Wczytaj", FileDialog.LOAD);
        plik.setVisible(true);

        return plik.getDirectory() + plik.getFile();
    }

}

