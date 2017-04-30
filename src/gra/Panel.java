package gra;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * @author Marcin
 */

public class Panel extends JPanel {
    Pomocnik pom = new Pomocnik();

    final int rozzdj = 200,
            odst = 2;

    int[][] tab = new int[5][5];
    BufferedImage[][] tabObraz = new BufferedImage[5][5];


    public Panel() {

        tab=pom.wypelnij_tab();

        try {                                                                 //czytanie plików
            tabObraz[0][0] = ImageIO.read(new File("zdj/00.jpg"));
            tabObraz[0][1] = ImageIO.read(new File("zdj/01.jpg"));
            tabObraz[0][2] = ImageIO.read(new File("zdj/02.jpg"));
            tabObraz[0][3] = ImageIO.read(new File("zdj/03.jpg"));
            tabObraz[0][4] = ImageIO.read(new File("zdj/04.jpg"));
            tabObraz[1][0] = ImageIO.read(new File("zdj/10.jpg"));
            tabObraz[1][1] = ImageIO.read(new File("zdj/11.jpg"));
            tabObraz[1][2] = ImageIO.read(new File("zdj/12.jpg"));
            tabObraz[1][3] = ImageIO.read(new File("zdj/13.jpg"));
            tabObraz[1][4] = ImageIO.read(new File("zdj/14.jpg"));
            tabObraz[2][0] = ImageIO.read(new File("zdj/20.jpg"));
            tabObraz[2][1] = ImageIO.read(new File("zdj/21.jpg"));
            tabObraz[2][2] = ImageIO.read(new File("zdj/22.jpg"));
            tabObraz[2][3] = ImageIO.read(new File("zdj/23.jpg"));
            tabObraz[2][4] = ImageIO.read(new File("zdj/24.jpg"));
            tabObraz[3][0] = ImageIO.read(new File("zdj/30.jpg"));
            tabObraz[3][1] = ImageIO.read(new File("zdj/31.jpg"));
            tabObraz[3][2] = ImageIO.read(new File("zdj/32.jpg"));
            tabObraz[3][3] = ImageIO.read(new File("zdj/33.jpg"));
            tabObraz[3][4] = ImageIO.read(new File("zdj/34.jpg"));
            tabObraz[4][0] = ImageIO.read(new File("zdj/40.jpg"));
            tabObraz[4][1] = ImageIO.read(new File("zdj/41.jpg"));
            tabObraz[4][2] = ImageIO.read(new File("zdj/42.jpg"));
            tabObraz[4][3] = ImageIO.read(new File("zdj/43.jpg"));
            tabObraz[4][4] = ImageIO.read(new File("zdj/44.png"));


        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            JOptionPane.showMessageDialog(null, "UWAGA!  Nie znaleziono obrazka");
        }

    }

    public void paintComponent(Graphics g) {            //główna metoda rysowania
        Graphics2D g2d = (Graphics2D) g;
        Font czcionka = new Font("Sans Serif", Font.BOLD, 20);
        for (int b = 0; b <= 4; b++)
            for (int a = 0; a <= 4; a++) {
                g2d.drawImage(tabObraz[b][a],a * (rozzdj + 2), b * (rozzdj + 2), this); //rysowanie obrazków
                g.setFont(czcionka);
                g.setColor(Color.green);
                g.drawString(String.valueOf(tab[a][b]), ((a + 1) * (rozzdj)) - 20, (b + 1) * (rozzdj));
            }
    }
}
