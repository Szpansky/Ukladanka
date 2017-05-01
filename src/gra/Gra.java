package gra;

import javax.swing.JFrame;

public class Gra {

    public static void main(String[] args) {
                                                    // TODO Okno z menu gl
        OknoGry gra = new OknoGry();
        gra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gra.setVisible(true);
    }
}
