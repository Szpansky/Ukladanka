package gra;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

/**
 * Klasa która przechowuje pomocnicze metody
 * do obsługi wczytywanego zdjęcia
 */
public class Pomocnik {

    /**
     * Metoda wypełnia tablice liczbami
     * @return zwraca referencje do wypełnionej tablicy
     */
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

    /**
     * Metoda wczytuje zdjęcie z przekazanego parametru,
     * oraz przy pomocy kolejnych metod skaluje zdjęcie oraz
     * dzieli na kawałki
     * @param sciezka scieżka pliku graficznego
     * @return Zwraca Referencje do obiektu tablicy zdjęc buforowanych
     */
    public BufferedImage[][] wczytaj_zdjecie(String sciezka) {

        BufferedImage[][] tab_obrazow;
        BufferedImage Obraz = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        try {
            Obraz = ImageIO.read(new File(sciezka));
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            JOptionPane.showMessageDialog(null, "UWAGA!  Nie znaleziono obrazka");
        }

        Obraz = skaluj_zdjecie(Obraz);
        tab_obrazow = podziel_zdjecie(Obraz);

        return tab_obrazow;
    }

    /**
     * Metoda skaluje zdjęcie do rozmiarów zależnych od danego rozmiaru
     * ekranu.
     * @param Obraz Referencja do całego obrazu
     * @return Zwraca referencję do przeskalowanego obrazu
     */
    private BufferedImage skaluj_zdjecie(BufferedImage Obraz){
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = d.height -100;
        int y = x;

        int w = Obraz.getWidth();
        int h = Obraz.getHeight();

        AffineTransform scale = AffineTransform.getScaleInstance((double) x/w, (double) y/h);
        BufferedImageOp op = new AffineTransformOp(scale, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        BufferedImage filteredImage = new BufferedImage(x, y, Obraz.getType());
        op.filter(Obraz, filteredImage);

        Obraz = filteredImage;
        return Obraz;
    }

    /**
     * Metoda dzieli zdjęcia na kawałki oraz zapisuje je do tablicy.
     * @param Obraz Referencja do obrazu
     * @return Zwraca referencje do obiektu tablicy zdjęć
     */
    private BufferedImage[][] podziel_zdjecie(BufferedImage Obraz){

        BufferedImage[][] tab_obrazow = new BufferedImage[5][5];
        tab_obrazow[0][0] = Obraz.getSubimage(0, 0, Obraz.getWidth()/5, Obraz.getHeight()/5);

        for (int b = 0; b <= 4; b++)
            for (int a = 0; a <= 4; a++) {
                tab_obrazow[b][a] = Obraz.getSubimage(a*(Obraz.getWidth()/5), b*(Obraz.getHeight()/5), Obraz.getWidth()/5, Obraz.getHeight()/5);
            }

        Graphics2D    graphics = tab_obrazow[4][4].createGraphics();
        graphics.setPaint ( new Color ( 0, 254, 0 ) );
        graphics.fillRect ( 0, 0, tab_obrazow[4][4].getWidth(), tab_obrazow[4][4].getHeight() );

        return tab_obrazow;
    }

}
