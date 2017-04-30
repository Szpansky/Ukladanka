package gra;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 * @author Marcin
 */

public class Panel extends JPanel {
    Pomocnik pomocnicza = new Pomocnik();

    final int rozzdj = 200;
    final int odst = 2;

    public int[][] tab = new int[5][5];
    public BufferedImage[][] tabObraz = new BufferedImage[5][5];


    public Panel() {

        tab = pomocnicza.wypelnij_tablice();
        tabObraz = pomocnicza.wczytaj_zdjecia();

    }

    public void paintComponent(Graphics g) {            //główna metoda rysowania
        Graphics2D g2d = (Graphics2D) g;
        Font czcionka = new Font("Sans Serif", Font.BOLD, 20);
        for (int b = 0; b <= 4; b++)
            for (int a = 0; a <= 4; a++) {
                g2d.drawImage(tabObraz[b][a], a * (rozzdj + 2), b * (rozzdj + 2), this); //rysowanie obrazków
                g.setFont(czcionka);
                g.setColor(Color.green);
                g.drawString(String.valueOf(tab[a][b]), ((a + 1) * (rozzdj)) - 20, (b + 1) * (rozzdj));
            }
    }
}
