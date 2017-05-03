package gra;

import javax.swing.JFrame;

/**
 *  <h1>Super Układanka!</h1>
 * Gra potrafi z każdego zdjecia stworzyć
 * super rozrywkę.
 * Wczytaj zdjęcie i układaj !
 * <p>
 * <b>Note:</b> Lepsze komentarze sprawiają,
 * że kod jest bardziej profesionalny
 *
 * @author  Ukladanka
 * @version 1.0
 * @since   2017-04-01
 */

public class Gra {
    /**
     * Główna metoda main, zawierająca utworzenie
     * zmiennej referencyjnej oraz przypisanie jej nowego obiektu OknoMenu
     * @param args Tablica argumentów przekazywanych do programu
     */
    public static void main(String[] args) {
        OknoMenu menu = new OknoMenu();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
