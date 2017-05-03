package gra;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Klasa AdapterGry, umożliwia komunikację
 * użytkownika z grą, posiada zmienne x i y,
 * przechowujące współrzędne gracza.
 */
public class AdapterGry {

    /**
     * Zmienna referencyjna obraz, zostaje przypisana
     * przez konstruktor Klasy
     */
    public PanelGry obraz;

    /**
     * Zmienne x i y przechowują współrzędne gracza
     */
    public int x, y;

    /**
     * Konstruktor AdapterGry, który inicjalizuje
     * zmienne oraz kopiuje zmienną referencyjną do
     * PanelGry z klasy OknoGry
     */
    public AdapterGry() {
        y = 4;
        x = 4;
        obraz = OknoGry.panel;
    }

    /**
     * Ta metoda pozwala graczowi komunikować
     * się z aplikacją za pomocą strzałek
     * @param evt Jest to parametr przekazujący zdarzenie klawisza
     */

    public void czytanieKlawisza(KeyEvent evt) {

        int c = evt.getKeyCode();


        if ((c == 37) && (y - 1 >= 0)) {
            this.zamianaZdjec(x, y, x, y - 1);
            y--;
        } else if ((c == 39) && (y + 1 <= 4)) {
            this.zamianaZdjec(x, y, x, y + 1);
            y++;
        } else if ((c == 40) && (x + 1 <= 4)) {
            this.zamianaZdjec(x, y, x + 1, y);
            x++;
        } else if ((c == 38) && (x - 1 >= 0)) {
            this.zamianaZdjec(x, y, x - 1, y);
            x--;
        } else if ((c == 113)) {
            for (int i = 0; i <= 5; i++) this.mieszaj();
        }
        if (this.sprawdz() == 0) {
            JOptionPane.showMessageDialog(null, "Brawo");
        }
    }

    /**
     * Metoda w prosty sposób zamienia elementy
     * w tablicy zdjęć. Parametrami są współrzędne zdjęc do zamiany
     * @param a x-owa pierwszego zdjęcia
     * @param b y-owa pierwszego zdjęcia
     * @param a2 x-owa drugiego zdjęcia
     * @param b2 y-owa drugiego zdjęcia
     */

    public void zamianaZdjec(int a, int b, int a2, int b2) {
        int zamtab;
        BufferedImage[] zamzdj = new BufferedImage[1];
        zamzdj[0] = OknoGry.panel.tab_obrazkow[a2][b2];
        obraz.tab_obrazkow[a2][b2] = obraz.tab_obrazkow[a][b];
        obraz.tab_obrazkow[a][b] = zamzdj[0];
        zamtab = obraz.tab_numerow[b][a];
        obraz.tab_numerow[b][a] = obraz.tab_numerow[b2][a2];
        obraz.tab_numerow[b2][a2] = zamtab;
    }


    /**
     * Ta metoda w prosty sposób wykorzystuje
     * metode zamiany zdjęć oraz dodatkowo
     * losuje parametry do zamiany
     */
    private void mieszaj() {
        Random pom = new Random();

        int a1 = pom.nextInt(5);
        int a2 = pom.nextInt(5);
        int a3 = pom.nextInt(5);
        int a4 = pom.nextInt(5);
        while ((a1 == x) && (a2 == y)) {
            a1 = pom.nextInt(5);
            a2 = pom.nextInt(5);
        }
        while ((a3 == x) && (a4 == y)) {
            a3 = pom.nextInt(5);
            a4 = pom.nextInt(5);
        }
        this.zamianaZdjec(a1, a2, a3, a4);
    }

    /**
     * Metoda sprawdza kolejność zmiennych w tablicy
     * dzięki czemu program wie, czy zdjęcia są ułożone
     * w poprawny sposób
     * @return Zwraca '1' jeżeli nastąpiła jakaś niepoprawność
     * w przeciwnym wypadku metoda zwraca 0
     */
    private int sprawdz() {
        int licz = 0;
        for (int b = 0; b <= 4; b++)
            for (int a = 0; a <= 4; a++) {
                if (obraz.tab_numerow[a][b] == licz) licz++;
                else return 1;
            }
        return 0;
    }
}