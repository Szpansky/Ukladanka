package gra;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pomocnik {


    public int[][] wypelnij_tablice() {
        int licznik = 0;
        int[][] tab = new int[5][5];
        for (int b = 0; b <= 4; b++)
            for (int a = 0; a <= 4; a++) {
                tab[a][b] = licznik;
                licznik++;
            }
        return tab;
    }


    public BufferedImage[][] wczytaj_zdjecia() {        // TODO to bedzie usuniete

        BufferedImage[][] tab_obrazow = new BufferedImage[5][5];
        try {
            tab_obrazow[0][0] = ImageIO.read(new File("src/gra/zdj/00.jpg"));
            tab_obrazow[0][1] = ImageIO.read(new File("src/gra/zdj/01.jpg"));
            tab_obrazow[0][2] = ImageIO.read(new File("src/gra/zdj/02.jpg"));
            tab_obrazow[0][3] = ImageIO.read(new File("src/gra/zdj/03.jpg"));
            tab_obrazow[0][4] = ImageIO.read(new File("src/gra/zdj/04.jpg"));
            tab_obrazow[1][0] = ImageIO.read(new File("src/gra/zdj/10.jpg"));
            tab_obrazow[1][1] = ImageIO.read(new File("src/gra/zdj/11.jpg"));
            tab_obrazow[1][2] = ImageIO.read(new File("src/gra/zdj/12.jpg"));
            tab_obrazow[1][3] = ImageIO.read(new File("src/gra/zdj/13.jpg"));
            tab_obrazow[1][4] = ImageIO.read(new File("src/gra/zdj/14.jpg"));
            tab_obrazow[2][0] = ImageIO.read(new File("src/gra/zdj/20.jpg"));
            tab_obrazow[2][1] = ImageIO.read(new File("src/gra/zdj/21.jpg"));
            tab_obrazow[2][2] = ImageIO.read(new File("src/gra/zdj/22.jpg"));
            tab_obrazow[2][3] = ImageIO.read(new File("src/gra/zdj/23.jpg"));
            tab_obrazow[2][4] = ImageIO.read(new File("src/gra/zdj/24.jpg"));
            tab_obrazow[3][0] = ImageIO.read(new File("src/gra/zdj/30.jpg"));
            tab_obrazow[3][1] = ImageIO.read(new File("src/gra/zdj/31.jpg"));
            tab_obrazow[3][2] = ImageIO.read(new File("src/gra/zdj/32.jpg"));
            tab_obrazow[3][3] = ImageIO.read(new File("src/gra/zdj/33.jpg"));
            tab_obrazow[3][4] = ImageIO.read(new File("src/gra/zdj/34.jpg"));
            tab_obrazow[4][0] = ImageIO.read(new File("src/gra/zdj/40.jpg"));
            tab_obrazow[4][1] = ImageIO.read(new File("src/gra/zdj/41.jpg"));
            tab_obrazow[4][2] = ImageIO.read(new File("src/gra/zdj/42.jpg"));
            tab_obrazow[4][3] = ImageIO.read(new File("src/gra/zdj/43.jpg"));
            tab_obrazow[4][4] = ImageIO.read(new File("src/gra/zdj/44.jpg"));
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            JOptionPane.showMessageDialog(null, "UWAGA!  Nie znaleziono obrazka");
        }
        return tab_obrazow;
    }

    public BufferedImage wczytaj_zdjecie() {        // TODO przekazanie String jako sciezka

        BufferedImage Obraz = new BufferedImage(8000, 6000, BufferedImage.TYPE_INT_RGB);
        try {
            Obraz = ImageIO.read(new File("src/gra/zdj/pelne.jpg"));     // TODO dodanie mozliwosci wczytania nazwy przez usera, sciezki
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            JOptionPane.showMessageDialog(null, "UWAGA!  Nie znaleziono obrazka");
        }
        // TODO uzycie funkcji skaluj_zdjecie(Obraz)
        // TODO uzycie funkcji podziel_zdjecie(Obraz)

        return Obraz;       // TODO Funkcja bedzie zwracac tablice obrazow
    }


    private void skaluj_zdjecie(BufferedImage Obraz){
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = d.height -30;
        int y = x;

        // TODO funkcja skalujaca do rozmiaru x i y
    }


    private BufferedImage[][] podziel_zdjecie(BufferedImage Obraz){

        BufferedImage[][] tab_obrazow = new BufferedImage[5][5];

        // TODO funkcja dzielaca Obraz na mnejsze kawalki dodawane do tablicy obrazow

        return tab_obrazow;
    }

}
