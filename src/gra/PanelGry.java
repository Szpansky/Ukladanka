package gra;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 * Klasa która tworzy obszar roboczy w oknie gry,
 * gdzie możemy operować na funkcjach graficznych
 *
 */
public class PanelGry extends JPanel {


    /**
     * Cechy klasy zapisują odstęp wycinek zdjęcia,
     * rozmiar danego kawałka, tablice numerów, oraz
     * tablice zdjęć buforowanych
     * Klasa tworzy Zmienna referencyjną do obiektu Pomocnik @see Pomocnik
     * oraz zmienną która można przypisać do Obiektu BufferedImage
     */
    final int odst = 2;
    private int rozmiar_kawalka;
    private BufferedImage obraz;
    private Pomocnik pomocnicza = new Pomocnik();


    /**
     * Tablica do przechowywania numerów
     */
    public int[][] tab_numerow = new int[5][5];

    /**
     * Tablica do przechowywania wycinek z obrazu
     */
    BufferedImage[][] tab_obrazkow = new BufferedImage[5][5];

    /**
     * Przeciążony konstruktor który otrzymuje scieżkę do pliku
     * graficznego, wypelnia tablice numerów, numerami,
     * wczytuje rozmiar kawałka zdjęcia,
     * wczytuje dane zdjęcie ze ścieżki które jest także
     * skalowane.
     * @param sciezka Parametrem jest cała ścieżka obrazu
     */
    public PanelGry(String sciezka) {
        tab_numerow = pomocnicza.wypelnij_tablice();
        tab_obrazkow = pomocnicza.wczytaj_zdjecie(sciezka);
        rozmiar_kawalka = tab_obrazkow[0][0].getHeight();
    }

    /**
     * Metoda rysuje tablice zdjęc, tablice numerów, ustala czcionke.
     * Ustala mejsce rozpoczęcia rysowania.
     * @param g parametr Graphics
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Font czcionka = new Font("Sans Serif", Font.BOLD, 20);

        int start_rysowania = (int) ((d.getWidth() - (tab_obrazkow[0][0].getWidth())*5) / 2);

        for (int b = 0; b <= 4; b++)
            for (int a = 0; a <= 4; a++) {

                g2d.drawImage(tab_obrazkow[b][a],start_rysowania + (a * (rozmiar_kawalka + 2)), (b * (rozmiar_kawalka + 2)), this); //rysowanie obrazków
                g.setFont(czcionka);
                g.setColor(Color.green);
                g.drawString(String.valueOf(tab_numerow[a][b]), start_rysowania + ((a + 1) * (rozmiar_kawalka)) - 20, (b + 1) * (rozmiar_kawalka));
            }
    }
}
