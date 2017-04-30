package gra;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pomocnik {


    public int[][] wypelnij_tablice() {               //funkcja wypełniająca tablice liczbami od 0 do 24
        int licznik = 0;
        int[][] tab = new int[5][5];
        for (int b = 0; b <= 4; b++)
            for (int a = 0; a <= 4; a++) {
                tab[a][b] = licznik;
                licznik++;
            }
        return tab;
    }


    public BufferedImage[][] wczytaj_zdjecia() {

        BufferedImage[][] tabObraz = new BufferedImage[5][5];
        try {                                                                 //czytanie plików
            tabObraz[0][0] = ImageIO.read(new File("src/gra/zdj/00.jpg"));
            tabObraz[0][1] = ImageIO.read(new File("src/gra/zdj/01.jpg"));
            tabObraz[0][2] = ImageIO.read(new File("src/gra/zdj/02.jpg"));
            tabObraz[0][3] = ImageIO.read(new File("src/gra/zdj/03.jpg"));
            tabObraz[0][4] = ImageIO.read(new File("src/gra/zdj/04.jpg"));
            tabObraz[1][0] = ImageIO.read(new File("src/gra/zdj/10.jpg"));
            tabObraz[1][1] = ImageIO.read(new File("src/gra/zdj/11.jpg"));
            tabObraz[1][2] = ImageIO.read(new File("src/gra/zdj/12.jpg"));
            tabObraz[1][3] = ImageIO.read(new File("src/gra/zdj/13.jpg"));
            tabObraz[1][4] = ImageIO.read(new File("src/gra/zdj/14.jpg"));
            tabObraz[2][0] = ImageIO.read(new File("src/gra/zdj/20.jpg"));
            tabObraz[2][1] = ImageIO.read(new File("src/gra/zdj/21.jpg"));
            tabObraz[2][2] = ImageIO.read(new File("src/gra/zdj/22.jpg"));
            tabObraz[2][3] = ImageIO.read(new File("src/gra/zdj/23.jpg"));
            tabObraz[2][4] = ImageIO.read(new File("src/gra/zdj/24.jpg"));
            tabObraz[3][0] = ImageIO.read(new File("src/gra/zdj/30.jpg"));
            tabObraz[3][1] = ImageIO.read(new File("src/gra/zdj/31.jpg"));
            tabObraz[3][2] = ImageIO.read(new File("src/gra/zdj/32.jpg"));
            tabObraz[3][3] = ImageIO.read(new File("src/gra/zdj/33.jpg"));
            tabObraz[3][4] = ImageIO.read(new File("src/gra/zdj/34.jpg"));
            tabObraz[4][0] = ImageIO.read(new File("src/gra/zdj/40.jpg"));
            tabObraz[4][1] = ImageIO.read(new File("src/gra/zdj/41.jpg"));
            tabObraz[4][2] = ImageIO.read(new File("src/gra/zdj/42.jpg"));
            tabObraz[4][3] = ImageIO.read(new File("src/gra/zdj/43.jpg"));
            tabObraz[4][4] = ImageIO.read(new File("src/gra/zdj/44.jpg"));
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            JOptionPane.showMessageDialog(null, "UWAGA!  Nie znaleziono obrazka");
        }
        return tabObraz;
    }


}
