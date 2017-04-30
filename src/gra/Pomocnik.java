package gra;

public class Pomocnik {


    public int[][] wypelnij_tab() {               //funkcja wypełniająca tablice liczbami od 0 do 24
        int licznik = 0;
        int[][] tab = new int[5][5];
        for (int b = 0; b <= 4; b++)
            for (int a = 0; a <= 4; a++) {
                tab[a][b] = licznik;
                licznik++;
            }

        return tab;
    }

}
