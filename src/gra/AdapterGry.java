package gra;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;


public class AdapterGry {

    int x;
    int y;
    public Panel obrazPanel;

    public AdapterGry() {

        y = 4;
        x = 4;
        obrazPanel = Frame.obrazPanel;
    }

    public void czytanieKlawisza(KeyEvent evt) {

        int c = evt.getKeyCode();

        if ((c == 37) && (y - 1 >= 0)) {
            this.funzamzdj(x, y, x, y - 1);
            y--;
        } else if ((c == 39) && (y + 1 <= 4)) {
            this.funzamzdj(x, y, x, y + 1);
            y++;
        } else if ((c == 40) && (x + 1 <= 4)) {
            this.funzamzdj(x, y, x + 1, y);
            x++;
        } else if ((c == 38) && (x - 1 >= 0)) {
            this.funzamzdj(x, y, x - 1, y);
            x--;
        } else if ((c == 113)) {
            for (int i = 0; i <= 5; i++) this.mieszaj();
        }
        if (this.sprawdz() == 0) {
            JOptionPane.showMessageDialog(null, "Gratulejszyn ziomuś");
        }
    }


    public void funzamzdj(int a, int b, int a2, int b2) {
        int zamtab;
        BufferedImage[] zamzdj = new BufferedImage[1];
        zamzdj[0] = Frame.obrazPanel.tabObraz[a2][b2];
        obrazPanel.tabObraz[a2][b2] = obrazPanel.tabObraz[a][b];
        obrazPanel.tabObraz[a][b] = zamzdj[0];
        zamtab = obrazPanel.tab[b][a];
        obrazPanel.tab[b][a] = obrazPanel.tab[b2][a2];
        obrazPanel.tab[b2][a2] = zamtab;

    }

    public void mieszaj() {
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
        this.funzamzdj(a1, a2, a3, a4);
    }

    public int sprawdz() {
        int licz = 0;
        for (int b = 0; b <= 4; b++)
            for (int a = 0; a <= 4; a++) {
                if (obrazPanel.tab[a][b] == licz) licz++;
                else return 1;
            }
        return 0;
    }


}
