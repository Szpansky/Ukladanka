package gra;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class PanelGry extends JPanel {

    final int odst = 2;
    private Pomocnik pomocnicza = new Pomocnik();
    private int rozmiar_kawalka;
    private BufferedImage obraz;

    public int[][] tab_numerow = new int[5][5];

    BufferedImage[][] tab_obrazkow = new BufferedImage[5][5];

    public PanelGry(String sciezka) {
        tab_numerow = pomocnicza.wypelnij_tablice();
        tab_obrazkow = pomocnicza.wczytaj_zdjecia();
        rozmiar_kawalka = tab_obrazkow[1][1].getHeight();
        obraz = pomocnicza.wczytaj_zdjecie(sciezka);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Font czcionka = new Font("Sans Serif", Font.BOLD, 20);

        int start_rysowania = (int) ((d.getWidth() - obraz.getWidth()) / 2);

        for (int b = 0; b <= 4; b++)
            for (int a = 0; a <= 4; a++) {

                //g2d.drawImage(tab_obrazkow[b][a], a * (rozmiar_kawalka + 2), b * (rozmiar_kawalka + 2), this); //rysowanie obrazków
                //g.setFont(czcionka);
                //g.setColor(Color.green);
                //g.drawString(String.valueOf(tab_numerow[a][b]), ((a + 1) * (rozmiar_kawalka)) - 20, (b + 1) * (rozmiar_kawalka));
                g2d.drawImage(obraz, start_rysowania, 0, this);
            }
    }
}
